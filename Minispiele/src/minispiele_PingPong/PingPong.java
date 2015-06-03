

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Erstellt das PingPong-Spiel.
 *
 * @author Richard
 */
public class PingPong extends JPanel implements Runnable, KeyListener {

    public final static int WIDTH_FRAME = 1207, HEIGHT_FRAME = 777;
    public final static int WIDTH_FIELD = 1200, HEIGHT_FIELD = 750;
    private int HOCH_SPIELER1, RUNTER_SPIELER1;
    private int HOCH_SPIELER2, RUNTER_SPIELER2, schwierigkeit = 15;
    private boolean up1, down1, up2, down2, multiplayer, solo;

    private Spieler spieler1, spieler2;
    private final Ball ball;
    private KI ki;

    private Image HintergrundPingPong;
    private JFrame ppFrame;

    /**
     * Erstellt zwei Spieler (Multiplayer)
     *
     * @param spieler1
     * @param spieler2
     */
    public PingPong(Spieler spieler1, Spieler spieler2) {

        multiplayer = true;
        //Component
        this.setFocusable(true);
        this.addKeyListener(this);
        //Frame
        ppFrame = new JFrame();
        ppFrame.setMinimumSize(new Dimension(WIDTH_FRAME, HEIGHT_FRAME));
        ppFrame.setResizable(false);
        ppFrame.add(this);
        ppFrame.setTitle("PINGPONG --- MODUS: MULTIPLAYER");
        ppFrame.setLocationRelativeTo(null);
        //Variablen
        HOCH_SPIELER1 = KeyEvent.VK_W;
        RUNTER_SPIELER1 = KeyEvent.VK_S;
        HOCH_SPIELER2 = KeyEvent.VK_UP;
        RUNTER_SPIELER2 = KeyEvent.VK_DOWN;
        up1 = false;
        down1 = false;
        up2 = false;
        down2 = false;
        
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        //Ball
        ball = new Ball(100, 100, this);
        //lade Hintergundbild
        ladeHintergrundbild();
        //setze Hintergrundbild
        // ppFrame.add(new JLabel(new ImageIcon(HintergrundPingPong)));
        //ppFrame.pack();
        System.out.println("Steuerung: W/S und Pfeil hoch/Pfeil runter");
        //Frame sichtbar machen
        ppFrame.setVisible(true);
        //Starten des Spieles
        new Thread(this).start();

    }

    /**
     * Erstellt einen Spieler und einen KI (Sologame)
     *
     * @param spieler1
     * @param ki
     * @param schwierigkeit 10 = schwer 50 = leicht;
     */
    public PingPong(Spieler spieler1, KI ki, int schwierigkeit) {
        solo = true;
        //Component
        this.setFocusable(true);
        this.addKeyListener(this);
        //Frame
        ppFrame = new JFrame();
        ppFrame.setMinimumSize(new Dimension(WIDTH_FRAME, HEIGHT_FRAME));
        ppFrame.setResizable(false);
        ppFrame.add(this);
        ppFrame.setTitle("PINGPONG --- MODUS: SOLO");
        ppFrame.setLocationRelativeTo(null);
        //Variablen
        HOCH_SPIELER1 = KeyEvent.VK_UP;
        RUNTER_SPIELER1 = KeyEvent.VK_DOWN;
        up1 = false;
        down1 = false;
        this.schwierigkeit = schwierigkeit;
        this.spieler1 = spieler1;
        this.ki = ki;
        //Ball
        ball = new Ball(100, 100, this);
        //lade Hintergundbild
        ladeHintergrundbild();
        //setze Hintergrundbild
        // ppFrame.add(new JLabel(new ImageIcon(HintergrundPingPong)));
        //ppFrame.pack();

        //Frame sichtbar machen
        ppFrame.setVisible(true);
        //Starten des Spieles
        new Thread(this).start();

    }

    /**
     * Lädt das Hintergrundbild.
     *
     * @return Gibt das Hintergrundbild zurück.
     */
    private Image ladeHintergrundbild() {

        try {
            HintergrundPingPong = ImageIO.read(PingPong.class.getResource("../images/PingPongFeld.jpg"));
        } catch (IOException e) {
        }

        return HintergrundPingPong;
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
        //Hintergrund zeichnen
        gr.drawImage(HintergrundPingPong, 0, 0, this);
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
                ki.move();
                if (kollisionPruefen(spieler1, ball)) {
                    ball.setxGeschw(Ball.V);
                }
                if (kollisionPruefen(ki, ball)) {
                    ball.setxGeschw(-Ball.V);
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
