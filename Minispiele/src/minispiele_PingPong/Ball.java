/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *Klasse zur Erstelung des PingPong-Balles welcher sich konstant bewegt und von 
 *den Rändern sowie den Spielern Abprallt.
 * @author Richard
 */
public class Ball extends JComponent {

    private int xGeschw, yGeschw;//Koordinatenänderung
    private int x, y;//Koordinaten
    private Component comp;
    private Image PingPongBall;
   
    /**
     * Erstellt den Ball an der Stelle P(x/y) und bekommt den Komponenten der 
     * PingPong-Klasse übergeben um ihn letztendlich in der paintComponent() 
     * Methode zeichnen zu können.
    **/
    public Ball(int x, int y, Component comp) {
        this.x = x;
        this.y = y;
        this.xGeschw = 5;
        this.yGeschw = 5;
        this.comp = comp;
        ladeBall();

    }
    /**
     * 
     * @return 
     */

    private Image ladeBall() {
        try {
            PingPongBall = ImageIO.read(new File("C:\\Users\\Richard\\Documents\\"
                    + "NetBeansProjects\\minispiele\\Minispiele\\src\\images\\"
                    + "PingPongBallGruenCutted.png"));
        } catch (IOException ex) {
            Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PingPongBall;
    }
    
    /**
     * Zeichnet den PingPong-Ball.
     * @param gr 
     */

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(PingPongBall, x, y, comp);

    }
    /**
     * Bewegt den PingPong-Ball und legt Fest, ab wann dieser abprallen (seine 
     * Richtung ändern) soll.
     */

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
