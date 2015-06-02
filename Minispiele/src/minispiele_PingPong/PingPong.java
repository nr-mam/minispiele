/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Richard
 */
public class PingPong extends JComponent implements Runnable {

    private final static int WIDTHPP = 1207;
    private final int HEIGHTPP = 777;
    private final Ball ball;
    private JFrame ppFrame;
    private int x, y;
    private BufferedImage HintergrundPingPong;

    public PingPong(String title) {
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

        //ppFrame.pack();
        ppFrame.setLocationRelativeTo(null);
        ppFrame.setVisible(true);

    }

    private BufferedImage ladeHintergrundbild() {
        try {
            HintergrundPingPong = ImageIO.read(new File("C:\\Users\\Richard\\Documents\\NetBeansProjects\\minispiele\\Minispiele\\src\\images\\PingPongFeld.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
        }

        return HintergrundPingPong;
    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(HintergrundPingPong, 0, 0, this);
        ball.paintComponent(gr);

    }

    public BufferedImage getHintergrundPingPong() {
        return HintergrundPingPong;
    }

    /**
     *
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
