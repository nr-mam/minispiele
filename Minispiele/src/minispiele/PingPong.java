/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Richard
 */
public class PingPong extends JFrame {

    private final int WIDTHPP;
    private final int HEIGHTPP;
    private Ball ball = new Ball(100, 100, this);
    private BufferedImage HintergrundPingPong;

    public PingPong(String title) {
        super(title);
        try {
            HintergrundPingPong = ImageIO.read(new File("C:\\Users\\Richard\\Documents\\NetBeansProjects\\minispiele\\Minispiele\\src\\images\\PingPongFeld.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
        }
        WIDTHPP = HintergrundPingPong.getWidth();
        HEIGHTPP = HintergrundPingPong.getHeight();
        setSize(WIDTHPP,HEIGHTPP);
    }

    public void paint(Graphics gr) {
        super.paint(gr);
        gr.drawImage(HintergrundPingPong, 0, 0, this);
        ball.paint(gr);

    }

}
