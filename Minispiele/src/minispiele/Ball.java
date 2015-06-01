/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.*;
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
public class Ball extends JFrame{

    private int x, y;
    private Component comp;
    BufferedImage PingPongBall;

    public Ball(int x, int y, Component comp) {
        this.x = x;
        this.y = y;
        this.comp = comp;
        try {
            PingPongBall = ImageIO.read(new File("C:\\Users\\Richard\\Documents\\NetBeansProjects\\minispiele\\Minispiele\\src\\images\\PingPongBallGruen.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void paint(Graphics gr){
        gr.drawImage(PingPongBall, 0, 0, comp);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    

}
