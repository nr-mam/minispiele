
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Richard
 */
public class KI extends Spieler{

    private final int HOEHE, BREITE;
    private int x, y, schwierigkeit;
    private final Color color;

    public KI(int x, Color color,int schwierigkeit) {
        super(x, color);
        this.x = x;
        y = 100;
        HOEHE = 150;
        BREITE = 20;
        
        this.schwierigkeit = schwierigkeit;
        this.color = color;
        
    }

    public void move() {
        
        if (Ball.getBallhoehe() < 770 - HOEHE) {
            y = Ball.getBallhoehe()- HOEHE/2;
        } else {
            y = 750 - HOEHE;
        }
    }

    @Override
    public void paintComponent(Graphics gr) {
        gr.setColor(color);
        gr.fillRect(x, y, BREITE, HOEHE);
    }

    public int getHOEHE() {
        return HOEHE;
    }

    public int getBREITE() {
        return BREITE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
