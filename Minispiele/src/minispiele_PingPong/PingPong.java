/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Erstellt das PingPong-Spiel.
 * @author Richard
 */
public class PingPong extends JComponent implements Runnable {

    private final static int WIDTHPP = 1207;
    private final int HEIGHTPP = 777;
    private final Ball ball;
    private JFrame ppFrame;
    private int x, y;
    private BufferedImage HintergrundPingPong;
    
    /**
     * Erstellt das Fenster des PingPong-Spieles und zentriert es.
     * @param title Titel des Fensters.
     */

    public PingPong() {
        x = 0;
        y = 0;

        ppFrame = new JFrame();
        ball = new Ball(100, 100, this);
        //lade Hintergundbild
        ladeHintergrundbild();
        //setze Hintergrundbild
        //add(new JLabel(new ImageIcon(HintergrundPingPong)));
        //Breite und Höhe

        ppFrame.setMinimumSize(new Dimension(WIDTHPP, HEIGHTPP));
        System.out.println(HintergrundPingPong.getHeight());
        ppFrame.setResizable(false);
        ppFrame.add(this);
        ppFrame.setTitle("PingPong");

        //ppFrame.pack();
        ppFrame.setLocationRelativeTo(null);
        ppFrame.setVisible(true);
        new Thread(this).start();//Starten des Spieles

    }
    
    /**
     * Lädt das Hintergrundbild.
     * 
     * Mittlerweile unnötig aber Bauteil für eine mögliche andere umsetzung des Spieles.
     * Bitte stehen lassen!
     * @return Gibt das Hintergrundbild zurück.
     */

    private BufferedImage ladeHintergrundbild() {
        try {
            HintergrundPingPong = ImageIO.read(new File("C:\\Users\\Richard\\"
                    + "Documents\\NetBeansProjects\\minispiele\\Minispiele\\src\\"
                    + "images\\PingPongFeld.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
        }

        return HintergrundPingPong;
    }
    
    /**
     * Zeichnet das Hintergrundbild und den Ball.
     * @param gr 
     */

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        //Hintergrund zeichnen
        gr.drawImage(HintergrundPingPong, 0, 0, this);
        //Ball zeichnen
        ball.paintComponent(gr);

    }

    /**
     *Methode zur dauerhaften durchführung der Methode move(), sowie der ständigen 
     *"Neuzeichung" durch repaint(). sleep(10) dient zur Pausierung, da sonst viel 
     * zu oft repaint() durchgeführt und somit paintComponent() ausgeführt wird 
     */
    @Override
    public void run() {

        while (true) {
            ball.move();
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

}
