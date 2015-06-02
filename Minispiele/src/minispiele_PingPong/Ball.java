/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Richard
 */
public class Ball extends JComponent {

    private int xGeschw, yGeschw;
    private int x, y;
    private Component comp;
    private Image PingPongBall;
    private PingPong ping;

    public Ball(int x, int y, Component comp) {
        this.x = x;
        this.y = y;
        this.xGeschw = 5;
        this.yGeschw = 5;
        this.comp = comp;
        ladeBall();

    }

    private Image ladeBall() {
        try {
            PingPongBall = ImageIO.read(new File("C:\\Users\\Richard\\Documents\\NetBeansProjects\\minispiele\\Minispiele\\src\\images\\PingPongBallGruenCutted.png"));
        } catch (IOException ex) {
            Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PingPongBall;
    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(PingPongBall, x, y, comp);

    }

    public void move() {

        if (x + 50 > 1200){
            xGeschw = -5;
        } else if (x <= 0) {
            xGeschw = 5;
        }
        if (y + 50 > 750) {
            yGeschw = -5;
        } else if (y <= 0) {
            yGeschw = 5;
        }
        x += xGeschw;
        y += yGeschw;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
