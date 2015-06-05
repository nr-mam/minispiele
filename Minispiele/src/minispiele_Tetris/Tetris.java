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
import javax.swing.JPanel;

/**
 *
 * @author Marc
 */
public class Tetris extends JPanel implements Runnable, KeyListener {

    private TBaustein block = new TBaustein(-1);
    private int LINKS_BEWEGUNG, RECHTS_BEWEGUNG, UNTEN_BEWEGUNG;
    private boolean links, rechts, unten;
    private final int GRENZE_UNTEN = 600, GRENZE_RECHTS = 360, GRENZE_LINKS = 30;
    private Image img;
    private LinkedList<TBaustein> alleBausteine;

    public Tetris() {
        //Initialisiert die einzelnen Komponenten
        LINKS_BEWEGUNG = KeyEvent.VK_LEFT;
        RECHTS_BEWEGUNG = KeyEvent.VK_RIGHT;
        UNTEN_BEWEGUNG = KeyEvent.VK_DOWN;
        links = false;
        rechts = false;
        alleBausteine = new LinkedList<>();
        try {
            img = ImageIO.read(new File("D:\\Eigene Dokumente\\NetBeansProjects\\minispiele\\Minispiele\\src\\images\\Tetris_img\\TetrisFeld.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    }

    @Override
    public void run() {
        TBaustein stein;
        while (true) {

            if (links) {
                block.moveBlockLeft(GRENZE_LINKS);
            }
            if (rechts) {
                block.moveBlockRight(GRENZE_RECHTS);
            }
            if (unten) {
                block.moveBlockDown(GRENZE_UNTEN);
            }
            boolean isUnten = block.moveBlockDown(GRENZE_UNTEN);
            if (isUnten) {
                stein = block;
                alleBausteine.add(stein);
                block = new TBaustein(-1);
            }

            repaint();
            try {
                Thread.sleep(70);
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
