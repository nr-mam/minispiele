/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;

/**
 * Erstellt das PingPong-Spiel.
 *
 * @author Richard
 */
public final class PingPong extends JPanel implements Runnable, KeyListener {

    public final static int WIDTH_FRAME = 1206,
            HEIGHT_FRAME = 776,
            WIDTH_FIELD = 1200,
            HEIGHT_FIELD = 750,
            TREFFER_RECHTS = 1,
            TREFFER_LINKS = -1;

    private int HOCH_SPIELER1,
            RUNTER_SPIELER1,
            HOCH_SPIELER2,
            RUNTER_SPIELER2,
            schwierigkeit = 15,
            maxPunkte;

    private boolean up1, down1, up2, down2, multiplayer, solo;

    private Spieler spieler1, spieler2;
    private Ball ball;
    private KI ki;
    private PingPongFrame pframe;
    private Punktezaehler pzRechts, pzLinks;

    private JFrame ppFrame;
    private JLayeredPane layers;

    private Thread thread;

    /**
     * Erstellt zwei Spieler (Multiplayer)
     *
     * @param spieler1
     * @param spieler2
     */
    public PingPong(Spieler spieler1, Spieler spieler2) {
        multiplayer = true;
        this.spieler2 = spieler2;

        HOCH_SPIELER1 = KeyEvent.VK_W;
        RUNTER_SPIELER1 = KeyEvent.VK_S;
        HOCH_SPIELER2 = KeyEvent.VK_UP;
        RUNTER_SPIELER2 = KeyEvent.VK_DOWN;

        System.out.println("Steuerung: W/S und Pfeil hoch/Pfeil runter");
        ball = new Ball(100, 100, this);

        pframe = new PingPongFrame("PINGPONG --- MODUS: MULTIPLAYER", this, ball);
        setSimilarities(spieler1);
        //Starten des Spieles
        thread = new Thread(this);
        thread.start();

    }

    /**
     * Erstellt einen Spieler und einen KI (Sologame)
     *
     * @param spieler1
     * @param ki
     * @param schwierigkeit 10 = schwer 50 = leicht;
     */
    public PingPong(Spieler spieler1, KI ki) {

        solo = true;
        this.ki = ki;

        HOCH_SPIELER1 = KeyEvent.VK_UP;
        RUNTER_SPIELER1 = KeyEvent.VK_DOWN;
        ball = new Ball(100, 100, this);
        pframe = new PingPongFrame("PINGPONG --- MODUS: SOLO", this, ball);
        setSimilarities(spieler1);
        //Starten des Spieles
        thread = new Thread(this);
        thread.start();

    }

    public void setSimilarities(Spieler spieler1) {

        pzLinks = new Punktezaehler(pframe.getTfPunkteLinks(), ball, TREFFER_LINKS);
        pzRechts = new Punktezaehler(pframe.getTfPunkteRechts(), ball, TREFFER_RECHTS);

        setOpaque(false);
        setFocusable(true);
        addKeyListener(this);
        this.spieler1 = spieler1;

        up1 = false;
        down1 = false;
        up2 = false;
        down2 = false;

    }

    public boolean kollisionPruefen(Spieler spieler, Ball ball) {
        Rectangle spielerHitbox = new Rectangle(spieler.getX(), spieler.getY(), spieler.getBREITE(), spieler.getHOEHE());
        Rectangle ballHitbox = new Rectangle(ball.getX(), ball.getY(), 50, 50);
        return spielerHitbox.intersects(ballHitbox);

    }

    public boolean kollisionPruefen(KI ki, Ball ball) {
        Rectangle kiHitbox = new Rectangle(ki.getX(), ki.getY(), ki.getBREITE(), ki.getHOEHE());
        Rectangle ballHitbox = new Rectangle(ball.getX(), ball.getY(), 50, 50);
        return kiHitbox.intersects(ballHitbox);

    }

    /**
     * Zeichnet das Hintergrundbild und den Ball.
     *
     * @param gr
     */
    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        //Ball zeichnen
        ball.paintComponent(gr);
        spieler1.paintComponent(gr);
        if (multiplayer) {
            spieler2.paintComponent(gr);
        } else if (solo) {
            ki.paintComponent(gr);
        }

    }

    /**
     * Methode zur dauerhaften durchführung der Methode move(), sowie der
     * ständigen "Neuzeichung" durch repaint(). sleep(10) dient zur Pausierung,
     * da sonst viel zu oft repaint() durchgeführt und somit paintComponent()
     * ausgeführt wird
     */
    @Override
    public void run() {

        while (true) {

            ball.move();
            //STEUERUNG
            if (up1) {
                spieler1.move(1);
                repaint();
            } else if (down1) {
                spieler1.move(-1);
                repaint();
            }
            if (up2) {
                spieler2.move(1);
                repaint();
            } else if (down2) {
                spieler2.move(-1);
                repaint();
            }
            //SOLO
            if (solo) {
                ki.move(ball);
                if (kollisionPruefen(spieler1, ball)) {
                    ball.setxGeschw(Ball.V);
                }
                if (kollisionPruefen(ki, ball)) {
                    ball.setxGeschw(-Ball.V);
                }

                if (pzRechts.maxPunkteVergleichen()) {
                    pframe.getLabelGewinnermeldung().setText("Spieler 1 gewinnt!");
                    pframe.labelGewinnermeldung.setVisible(true);
                    thread.stop();
                }
                if (pzLinks.maxPunkteVergleichen()) {
                    pframe.getLabelGewinnermeldung().setText("KI gewinnt!");
                    pframe.labelGewinnermeldung.setVisible(true);
                    thread.stop();
                }

            }
            //MULTIPLAYER
            if (multiplayer) {
                if (kollisionPruefen(spieler1, ball)) {
                    ball.setxGeschw(Ball.V);
                }
                if (kollisionPruefen(spieler2, ball)) {
                    ball.setxGeschw(-Ball.V);
                }
                
                if (pzRechts.maxPunkteVergleichen()) {
                    pframe.getLabelGewinnermeldung().setText("Spieler 1 gewinnt!");
                    pframe.labelGewinnermeldung.setVisible(true);
                    thread.stop();
                }
                if (pzLinks.maxPunkteVergleichen()) {
                    pframe.getLabelGewinnermeldung().setText("Spieler 2 gewinnt!");
                    pframe.labelGewinnermeldung.setVisible(true);
                    thread.stop();
                }
            }

            if (pzLinks.kollisionLinksPruefen(ball)) {
                pzLinks.addieren(pframe.getTfPunkteRechts());
            }
            if (pzRechts.kollisionRechtsPruefen(ball)) {
                pzRechts.addieren(pframe.getTfPunkteLinks());
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getFrameWidth() {
        return ppFrame.getWidth();
    }

    public int getFrameHeight() {
        return ppFrame.getHeight();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == HOCH_SPIELER1) {
            up1 = true;
        }
        if (e.getKeyCode() == RUNTER_SPIELER1) {
            down1 = true;
        }
        if (e.getKeyCode() == HOCH_SPIELER2) {
            up2 = true;
        }
        if (e.getKeyCode() == RUNTER_SPIELER2) {
            down2 = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        up1 = false;
        down1 = false;
        up2 = false;
        down2 = false;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

}
