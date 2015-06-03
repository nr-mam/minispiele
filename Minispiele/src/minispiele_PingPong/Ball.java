
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Klasse zur Erstelung des PingPong-Balles welcher sich konstant bewegt und von
 * den Rändern sowie den Spielern Abprallt.
 *
 * @author Richard
 */
public class Ball extends JComponent {

    //Balldurchmesser 50px
    public static final int V = 10;
    private static final int bHeight = 50, bWidth = 50;
    private static int Ballhoehe;
    private int xGeschw, yGeschw;//Koordinatenänderung
    private int x, y;//Koordinaten
    private Component comp;
    private Image PingPongBall;

    /**
     * Erstellt den Ball an der Stelle P(x/y) und bekommt den Komponenten der
     * PingPong-Klasse übergeben um ihn letztendlich in der paintComponent()
     * Methode zeichnen zu können.
     *
     * @param x
     * @param y
     * @param comp
     */
    public Ball(int x, int y, Component comp) {
        this.x = x;
        this.y = y;
        this.xGeschw = V;
        this.yGeschw = V;
        this.comp = comp;
        Ballhoehe = this.y;
        ladeBall();

    }

    /**
     *
     * @return
     */
    private Image ladeBall() {
        try {
            PingPongBall = ImageIO.read(PingPong.class.getResource("../images/PingPongBallGruenCutted.png"));
        } catch (IOException e) {
        }
        return PingPongBall;
    }
    
    
    

    /**
     * Zeichnet den PingPong-Ball.
     *
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

        if (x + 50 > 1200) {
            xGeschw = -V;
        } else if (x <= 0) {
            xGeschw = V;
        }
        if (y + 50 > 750) {
            yGeschw = -V;
        } else if (y <= 0) {
            yGeschw = V;
        }
        x += xGeschw;
        y += yGeschw;
        Ballhoehe = y;

    }

    public void setxGeschw(int xGeschw) {
        this.xGeschw = xGeschw;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public static int getBallhoehe() {
        return Ballhoehe;
    }

}