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
import javax.swing.JPanel;

/**
 *
 * @author Marc
 */
public class Tetris extends JPanel implements Runnable, KeyListener {

    private TBaustein block = new TBaustein(-1);
    private TBaustein blockTest;
    private int LINKS_BEWEGUNG, RECHTS_BEWEGUNG, UNTEN_BEWEGUNG;
    private boolean links, rechts, unten, stop;
    private final int GRENZE_UNTEN = 570, GRENZE_RECHTS = 360, GRENZE_LINKS = 30;
    private Image img;
    private int[][] spielflaeche;
    private TScore scores;

    public Tetris() {
        //Initialisiert die einzelnen Komponenten
        LINKS_BEWEGUNG = KeyEvent.VK_LEFT;
        RECHTS_BEWEGUNG = KeyEvent.VK_RIGHT;
        UNTEN_BEWEGUNG = KeyEvent.VK_DOWN;
        blockTest = new TBaustein(block.getID());
        scores = new TScore(new TBaustein(-1), new TBaustein(-1));
        //blockTest.setVisible(false);
        links = false;
        rechts = false;
        stop = false;
        initialisiereSpielflaeche();
        try {
            System.out.println("dd");
            img = ImageIO.read(this.getClass().getResource("..\\images\\Tetris_img\\TetrisFeld_Design_01.jpg"));
            System.out.println("ddd");

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
        spielflaeche = new int[16][26];
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

        block.paintComponent(gr);
        for (int i = 0; i < spielflaeche.length; i++) {
            for (int j = 0; j < spielflaeche[i].length; j++) {
                if (spielflaeche[i][j] != -1) {
                    gr.drawImage(block.getImgs(spielflaeche[i][j]), (i * 30), ((j * 30) - 1), this);
                }
            }

        }
        scores.paintComponent(gr);

    }

    @Override
    public void run() {
        int wartezeit;
        int x, y, y1;
        int[] geprüft;
        boolean isOK;
        boolean isLine;
        int[][] spielflaecheKopie;
        while (true) {
            isOK = true;
            wartezeit = 70;
            scores.ScoreAdd(1);

            //Pfeiltaste nach unten wurde gedrückt.            
            if (unten) {
                block.moveBlockDown(GRENZE_UNTEN);
                wartezeit = 40;
            }
            boolean isUnten = block.moveBlockDown(GRENZE_UNTEN);

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
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
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
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            //boolean isUnten = false;
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

            if (isUnten) {
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
            }

            isLine = false;
            for (int i = 1; i < 14; i++) {
                for (int j = 1; j < spielflaeche[i].length; j++) {
                    if (spielflaeche[i][j] != -1) {
                        isLine = true;
                    } else {
                        break;
                    }
                }
            }
            spielflaecheKopie = spielflaeche;
            if (isLine) {
                for (int i = 1; i < 15; i++) {
                    for (int j = 1; j < spielflaecheKopie[i].length; j++) {
                        y = j + 1;
                        spielflaeche[i][y] = spielflaecheKopie[i][j];
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
    }

    @Override
    public void keyReleased(KeyEvent e) {
        links = false;
        rechts = false;
        unten = false;
    }

}
