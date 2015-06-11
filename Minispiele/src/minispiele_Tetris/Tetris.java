/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Tetris;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Marc
 */
public class Tetris extends JPanel implements Runnable, KeyListener {

    private TBaustein block = new TBaustein(-1);
    private TBaustein blockTest;
    private int LINKS_BEWEGUNG, RECHTS_BEWEGUNG, UNTEN_BEWEGUNG, ROTATION;
    private boolean links, rechts, unten, rotieren, start;
    private final int GRENZE_UNTEN = 570, GRENZE_RECHTS = 360, GRENZE_LINKS = 30;
    private Image img;
    private int[][] spielflaeche;
    private TScore scores;

    public Tetris() {
        //Initialisiert die einzelnen Komponenten
        LINKS_BEWEGUNG = KeyEvent.VK_LEFT;
        RECHTS_BEWEGUNG = KeyEvent.VK_RIGHT;
        UNTEN_BEWEGUNG = KeyEvent.VK_DOWN;
        ROTATION = KeyEvent.VK_UP;
        blockTest = new TBaustein(block.getID());
        scores = new TScore(new TBaustein(-1), new TBaustein(-1));
        //blockTest.setVisible(false);
        links = false;
        rechts = false;
        start = true;
        initialisiereSpielflaeche();
        try {
            img = ImageIO.read(this.getClass().getResource("..\\images\\Tetris_img\\TetrisFeld_Design_01.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            GUI();
        } catch (IOException ex) {
            Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initialisiereSpielflaeche() {
        spielflaeche = new int[17][27];
        for (int i = 0; i < spielflaeche.length; i++) {
            for (int j = 0; j < spielflaeche[i].length; j++) {
                spielflaeche[i][j] = -1;
                // -1 = kein BausteinBlock befindet sich an dieser Position
            }

        }

    }

    private void GUI() throws IOException {
        //Erstellt die GUI
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(img.getWidth(this) + 6, img.getHeight(this) + 26));
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        frame.setResizable(false);
        setOpaque(false);
        setFocusable(true);
        addKeyListener(this);
        new Thread(this).start();

    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(img, 0, 0, this);
        //blockTest.paintComponent(gr);
        block.paintComponent(gr);
        for (int i = 0; i < spielflaeche.length; i++) {
            for (int j = 0; j < spielflaeche[i].length; j++) {
                if (spielflaeche[i][j] != -1 && start) {
                    gr.drawImage(block.getImgs(spielflaeche[i][j]), (i * 30), ((j * 30) - 1), this);
                }
            }

        }
        scores.paintComponent(gr);

    }

    @Override
    public void run() {
        int wartezeit;
        int x = 0, y = 0, y1;
        int[] geprüft;
        boolean isOK;
        boolean isLine;
        int[][] spielflaecheKopie;
        while (start) {
            isOK = true;
            wartezeit = 70;
            scores.ScoreAdd(1);

            //Pfeiltaste nach unten wurde gedrückt.
            if (rotieren) {
                block.RotateBlock();
                blockTest.RotateBlock();
            }
            if (unten) {
                block.moveBlockDown(GRENZE_UNTEN);
                wartezeit = 40;
            }

            linksTesten(x, y, isOK);
            rechtsTesten(x, y, isOK);
            boolean isUnten = block.moveBlockDown(GRENZE_UNTEN);
            //Pfeiltaste nach unten wurde gedrückt.
            if (unten) {
                block.moveBlockDown(GRENZE_UNTEN);
                wartezeit = 40;
                scores.ScoreAdd(10);
            }

            geprüft = new int[block.getBlockForm()[0].length];
            for (int i = 0; i < geprüft.length; i++) {
                geprüft[i] = 0;
            }

            for (int i = block.getBlockForm().length - 1; i >= 0; i--) {
                for (int j = 0; j < block.getBlockForm()[i].length; j++) {
                    x = (((block.getX() / 30) + i));
                    y = (((block.getY() / 30) + j));
                    if (block.getBlockForm()[i][j] == 0 && geprüft[j] == 0) {
                        geprüft[j] = 1;
                        if (spielflaeche[x][y] != -1) {
                            isUnten = true;
                        }
                    }

                    if (block.getBlockForm()[i][j] == 1) {
                        y1 = y + 1;
                        if (spielflaeche[x][y1] != -1) {
                            isUnten = true;
                        }
                    }

                }

            }
            // Ist der Block unten angekommen?

            if (isUnten) {
                x = ((block.getY() / 30));
                if (x < 2) {
                    start = false;
                    break;
                }

                for (int i = 0; i < geprüft.length; i++) {
                    geprüft[i] = 0;
                }
                for (int i = 0; i < block.getBlockForm().length; i++) {
                    for (int j = 0; j < block.getBlockForm()[i].length; j++) {
                        x = (((block.getX() / 30) + i));
                        y = (((block.getY() / 30) + j));
                        if (block.getBlockForm()[i][j] == 1) {
                            spielflaeche[x][y] = block.getID();

                        }

                    }

                }
                block = scores.neuerBaustein();
                blockTest = new TBaustein(block.getID());
                scores.ScoreAdd((block.getXmax() + 1) * (block.getYmax() + 1));

                isLine = false;
                int c = 0;
                for (int j = 1; j < spielflaeche[0].length; j++) {
                    c = 0;
                    for (int i = 1; i < 13; i++) {
                        if (spielflaeche[i][j] != -1) {
                            isLine = true;
                            c++;
                            if (c == 12) {

                                scores.LinesAdd(1);
                                scores.ScoreAdd(200);

                                spielflaecheKopie = new int[spielflaeche.length][spielflaeche[0].length];
                                for (int k = 0; k < spielflaeche.length; k++) {
                                    for (int l = 0; l < spielflaeche[k].length; l++) {
                                        spielflaecheKopie[k][l] = spielflaeche[k][l];

                                    }

                                }
                                for (int k = 1; k < spielflaecheKopie.length; k++) {
                                    for (int l = 1; l < j + 1; l++) {
                                        if (spielflaeche[k][l] != -1) {
                                            y = l - 1;
                                            spielflaecheKopie[k][l] = spielflaeche[k][y];
                                        }

                                    }
                                }
                                spielflaeche = spielflaecheKopie;
                                break;
                            }
                        } else {
                            isLine = false;
                        }
                    }
                }

            }

            repaint();
            try {
                Thread.sleep(wartezeit);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String end = "GAME OVER";
        JOptionPane.showMessageDialog(null, end, "Tetris",
                JOptionPane.INFORMATION_MESSAGE);

    }

    private void linksTesten(int x, int y, boolean isOK) {

        //Pfeiltaste nach links wurde gedrückt.
        if (links) {

            if (block.getX() - 30 > 0) {
                blockTest.X = block.getX() - 30;
            }

            blockTest.Y = block.getY();
            for (int i = 0; i < blockTest.getBlockForm().length; i++) {
                for (int j = 0; j < blockTest.getBlockForm()[i].length; j++) {
                    x = (((blockTest.getX() / 30) + i));
                    y = (((blockTest.getY() / 30) + j));
                    if (blockTest.getBlockForm()[i][j] == 1) {
                        if (spielflaeche[x][y] != -1) {
                            isOK = false;
                        }
                    }

                }

            }
            if (isOK) {
                block.moveBlockLeft(GRENZE_LINKS);
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    private void rechtsTesten(int x, int y, boolean isOK) {
        //Pfeiltaste nach rechts wurde gedrückt.
        if (rechts) {
            blockTest.X = block.getX() + 30;
            blockTest.Y = block.getY();
            isOK = true;
            for (int i = 0; i < blockTest.getBlockForm().length; i++) {
                for (int j = 0; j < blockTest.getBlockForm()[i].length; j++) {
                    x = (((blockTest.getX() / 30) + i));
                    y = (((blockTest.getY() / 30) + j));
                    if (blockTest.getBlockForm()[i][j] == 1) {
                        if (spielflaeche[x][y] != -1) {
                            isOK = false;
                        }
                    }
                }

            }
            if (isOK) {
                block.moveBlockRight(GRENZE_RECHTS);
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == LINKS_BEWEGUNG) {
            links = true;
        }
        if (e.getKeyCode() == RECHTS_BEWEGUNG) {
            rechts = true;
        }
        if (e.getKeyCode() == UNTEN_BEWEGUNG) {
            unten = true;
        }
        if (e.getKeyCode() == ROTATION) {
            rotieren = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        links = false;
        rechts = false;
        unten = false;
        rotieren = false;
    }

}
