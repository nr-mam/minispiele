
package minispiele_Tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import minispiele.Clock;

/**
 *
 * @author Marc
 */
public class Tetris extends JPanel implements Runnable, KeyListener {

    private TBaustein block = new TBaustein(-1);
    private TBaustein blockTest;
    private int LINKS_BEWEGUNG, RECHTS_BEWEGUNG, UNTEN_BEWEGUNG, ROTATION;
    boolean links, rechts, unten, rotieren, start, end;
    private final int GRENZE_UNTEN = 570, GRENZE_RECHTS = 360, GRENZE_LINKS = 30;
    private Image img;
    private int wartezeit;
    private int[][] spielflaeche;
    private TScore scores;
    private final TetrisFrame tetrisFrame;
    public Thread thread;
    private Clock c;

    public Tetris() {
        //Initialisiert die einzelnen Komponenten
        LINKS_BEWEGUNG = KeyEvent.VK_LEFT;
        RECHTS_BEWEGUNG = KeyEvent.VK_RIGHT;
        UNTEN_BEWEGUNG = KeyEvent.VK_DOWN;
        ROTATION = KeyEvent.VK_UP;
        blockTest = new TBaustein(block.getID());
        c = new Clock();
        scores = new TScore(new TBaustein(-1), new TBaustein(-1));
        //blockTest.setVisible(false);
        links = false;
        rechts = false;
        start = true;
        end = false;
        initialisiereSpielflaeche();
        try {
            img = ImageIO.read(this.getClass().getResource("/images/Tetris/TetrisFeld_Design_01.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
        }

        //GUI();
        setOpaque(false);
        setFocusable(true);
        addKeyListener(this);
        tetrisFrame = new TetrisFrame(this);
        thread = new Thread(this);
        thread.start();

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

    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(img, 0, 0, this);

        block.paintComponent(gr);
        for (int i = 0; i < spielflaeche.length; i++) {
            for (int j = 0; j < spielflaeche[i].length; j++) {
                if (spielflaeche[i][j] != -1 && start) {
                    gr.drawImage(block.getImgs(spielflaeche[i][j]), (i * 30), ((j * 30) - 1), this);
                }
            }

        }
        //Folgende (auskommentierte) Zeilen dienen nur zur Fehlerbehebung
        //blockTest.img = block.getImgs(7);
        //blockTest.paintComponent(gr);
        scores.paintComponent(gr);
        gr.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        gr.setColor(Color.WHITE);
        if (!start) {
            gr.drawString("GAME OVER", 55, 350);
            for (int i = 0; i < spielflaeche.length; i++) {
                for (int j = 0; j < spielflaeche[i].length; j++) {
                    if (spielflaeche[i][j] != -1 && start) {
                        System.out.println("did");
                        gr.drawImage(block.getImgs(spielflaeche[i][j]), (i * 30), ((j * 30) - 1), this);
                    }
                }

            }

            end = true;
        }

    }

    @Override
    public void run() {
        c.getT().start();
        int x = 0, y = 0;
        int[] geprüft;
        boolean isOK;
        boolean isLine;
        int[][] spielflaecheKopie;
        while (start) {
            isOK = true;
            wartezeit = 65 - ((scores.getLevel() - 1) * 3);

            RotierenTesten(x, y, isOK);
            linksTesten(x, y, isOK);
            rechtsTesten(x, y, isOK);

            boolean isUnten = block.moveBlockDown(GRENZE_UNTEN);
            boolean blockFestigen = untenTesten(x, y);
            if (isUnten) {
                blockFestigen = true;
            }

            //Pfeiltaste nach unten wurde gedrückt.
            if (unten) {
                block.moveBlockDown(GRENZE_UNTEN);
                wartezeit = 20;
                scores.ScoreAdd(10 * scores.getLevel());
            }

            geprüft = new int[block.getBlockForm()[0].length];
            for (int i = 0; i < geprüft.length; i++) {
                geprüft[i] = 0;
            }

            //Erhöhung des Levels, sobald die Bedinngungen dafür erfüllt sind.
            if (c.getMin() >= 1 && scores.getLines() >= scores.getLevel() * 2 && scores.getScore() > scores.getLevel() * 5000) {
                scores.level++;
                c.resetAll();
            }

            //aktuellen Block verfestigen
            if (blockFestigen) {
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
                scores.ScoreAdd((block.getXmax() + 1) * (block.getYmax() + 1) * scores.getLevel());

                isLine = false;
                int c1 = 0;
                for (int j = 1; j < spielflaeche[0].length; j++) {
                    c1 = 0;
                    for (int i = 1; i < 13; i++) {
                        if (spielflaeche[i][j] != -1) {
                            isLine = true;
                            c1++;
                            if (c1 == 12) {

                                scores.LinesAdd(1);
                                scores.ScoreAdd(200 * scores.getLevel());

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

            try {
                Thread.sleep(wartezeit);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
        while (!end) {
            repaint();
        }
        c.setEnd();

    }

    private void RotierenTesten(int x, int y, boolean isOK) {
        if (rotieren) {
            blockTest.X = block.getX();
            blockTest.Y = block.getY();
            blockTest.RotateBlock(GRENZE_RECHTS);
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
                block.RotateBlock(GRENZE_RECHTS);
                //block = blockTest;
            } else {
                blockTest = block;
            }

        }
    }

    private void linksTesten(int x, int y, boolean isOK) {

        isOK = true;
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
                    wartezeit = 45;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    private void rechtsTesten(int x, int y, boolean isOK) {
        //Pfeiltaste nach rechts wurde gedrückt.
        isOK = true;
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
                    wartezeit = 45;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private boolean untenTesten(int x, int y) {

        blockTest.X = block.getX();
        blockTest.Y = block.getY() + 30;
        for (int i = 0; i < blockTest.getBlockForm().length; i++) {
            for (int j = 0; j < blockTest.getBlockForm()[i].length; j++) {
                x = (((blockTest.getX() / 30) + i));
                y = (((blockTest.getY() / 30) + j));
                if (blockTest.getBlockForm()[i][j] == 1) {
                    if (spielflaeche[x][y] != -1) {
                        return true;
                    }
                }
            }

        }
        return false;

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
