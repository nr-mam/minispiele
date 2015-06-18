/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.logging.*;
import javax.swing.*;

/**
 * Erstellt das PingPong-Spiel.
 *
 * Das PingPong Spiel an sich ist ein JPanel in das ständig gezeichnet wird.
 * Diese Panel wird letztendlich nur dem LayeredPanel layers in der Klasse
 * PingPongFrame hinzugefügt. Die Klasse muss Runnable sein, da diese ausgeführt
 * wird über die run() methode.
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
    //Steuerungsvariablen
    private int HOCH_SPIELER1,
            RUNTER_SPIELER1,
            HOCH_SPIELER2,
            RUNTER_SPIELER2,
            schwierigkeit;

    private boolean up1, down1, up2, down2, multiplayer, solo;

    private Spieler spieler1, spieler2;
    private Ball ball;
    private KI ki;
    private PingPongFrame pframe;
    private Punktezaehler pzRechts, pzLinks;

    private JFrame ppFrame;
    private Thread thread;

    /**
     * Erstellt zwei Spieler (MULTIPLAYER) - 
     * Startet das Spiel.
     *
     * @param spieler1 erster Spieler
     * @param spieler2 zweiter Spieler
     */
    public PingPong(Spieler spieler1, Spieler spieler2) {
        this.schwierigkeit = Einstellungen.schwierigkeit;
        multiplayer = true;
        this.spieler2 = spieler2;

        HOCH_SPIELER1 = KeyEvent.VK_W;
        RUNTER_SPIELER1 = KeyEvent.VK_S;
        HOCH_SPIELER2 = KeyEvent.VK_UP;
        RUNTER_SPIELER2 = KeyEvent.VK_DOWN;

        System.out.println("Steuerung: W/S und Pfeil hoch/Pfeil runter");
        ball = new Ball(100, 100, this, schwierigkeit);

        pframe = new PingPongFrame("PINGPONG --- MODUS: MULTIPLAYER", this);
        setSimilarities(spieler1);
        //Starten des Spieles
        thread = new Thread(this);
        thread.start();

    }

    /**
     * Erstellt einen Spieler und einen KI (SOLO) - 
     * Startet das Spiel.
     *
     * @param spieler1 der erste(einzige) Spieler
     * @param ki der "computergesteuerte" Gegner
     */
    public PingPong(Spieler spieler1, KI ki) {
        this.schwierigkeit = Einstellungen.schwierigkeit;

        solo = true;
        this.ki = ki;

        HOCH_SPIELER1 = KeyEvent.VK_UP;
        RUNTER_SPIELER1 = KeyEvent.VK_DOWN;
        ball = new Ball(100, 100, this, schwierigkeit);
        pframe = new PingPongFrame("PINGPONG --- MODUS: SOLO", this);
        setSimilarities(spieler1);
        //Starten des Spieles
        thread = new Thread(this);
        thread.start();

    }

    /**
     * Setzt die gemeinsamkeiten der beiden Konstruktoren um redundanten code zu
     * vermeiden.
     *
     * @param spieler1 der erste Spieler
     */
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

    /**
     * Prüft ob eine Kollision bei einem Spieler vorliegt.
     *
     * @param spieler der Spieler bei dem geprüft werden soll
     * @param ball der Spielball
     * @return
     */
    public boolean kollisionPruefen(Spieler spieler, Ball ball) {
        Rectangle spielerHitbox = new Rectangle(spieler.getX(), spieler.getY(), spieler.getBREITE(), spieler.getHOEHE());
        Rectangle ballHitbox = new Rectangle(ball.getX(), ball.getY(), 50, 50);
        return spielerHitbox.intersects(ballHitbox);

    }

    /**
     * Prüft ob eine Kollision bei dem KI vorliegt.
     *
     * @param ki der KI bei dem geprüft werden soll
     * @param ball der SPielball
     * @return
     */
    public boolean kollisionPruefen(KI ki, Ball ball) {
        Rectangle kiHitbox = new Rectangle(ki.getX(), ki.getY(), ki.getBREITE(), ki.getHOEHE());
        Rectangle ballHitbox = new Rectangle(ball.getX(), ball.getY(), 50, 50);
        return kiHitbox.intersects(ballHitbox);

    }

    /**
     * Zeichnet den Ball, Spieler1 und den KI oder Spieler2.
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
     * Dient zur erzeugung einer Variablen die zur veränderung der
     * Geschwindigkeit verwendet wird, um ein bisschen mehr bewegung in das
     * Spiel zu bringen.
     *
     * @return
     */
    public double bewegungsGewichtung() {
        Random r = new Random();
        Double gewichtung = 0.0;
        gewichtung = r.nextDouble();
        return gewichtung * 2;
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
                    ball.setxGeschw(Ball.V + bewegungsGewichtung());
                    //System.out.println(Ball.V + bewegungsGewichtung());

                }
                if (kollisionPruefen(ki, ball)) {
                    ball.setxGeschw(-Ball.V + bewegungsGewichtung());
                    // System.out.println(-Ball.V + bewegungsGewichtung());

                }

                if (pzRechts.maxPunkteVergleichen()) {
                    pframe.gewinnermeldungAnzeigen("Spieler 1 gewinnt!");
                    thread.stop();
                }
                if (pzLinks.maxPunkteVergleichen()) {
                    pframe.gewinnermeldungAnzeigen("KI gewinnt!");
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
                    pframe.gewinnermeldungAnzeigen("Spieler 1 gewinnt!");
                    thread.stop();
                }
                if (pzLinks.maxPunkteVergleichen()) {
                    pframe.gewinnermeldungAnzeigen("Spieler 2 gewinnt!");
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
                    Thread.sleep(schwierigkeit);
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
