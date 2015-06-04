/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Snake;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Windows7
 */
public class SnakeKoerper extends JComponent {

    private int xPosition = 100, yPosition = 100;
    private int geschwindigkeit;
    private int xGeschwindigkeit, yGeschwindigkeit;
    private Component comp;
    private Image Snakefragment;
    private int richtung;

    public SnakeKoerper(int vx, int vy, Component comp, int richtung,int geschwindigkeit) {
        this.xGeschwindigkeit = vx;
        this.yGeschwindigkeit = vy;
        this.comp = comp;
        this.richtung = richtung;
        this.geschwindigkeit = geschwindigkeit;
        erzeugeFragment();

    }

    private Image erzeugeFragment() {
        try {
            Snakefragment = ImageIO.read(Snake.class.getResource("../images/SnakeFragment.png"));
        } catch (IOException e) {
        }
        return Snakefragment;
    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(Snakefragment, xPosition, yPosition, comp);

    }
    
    
    public void move(){
        //Bewegung in positive x-Richtung
        if (richtung ==3){
            xGeschwindigkeit = geschwindigkeit;
            yGeschwindigkeit = 0;
        }
        //Bewegung in positive y-Richtung
        if (richtung == 2){
            xGeschwindigkeit = 0;
            yGeschwindigkeit = geschwindigkeit;
        }
        //Bewegung in negative x-Richtung
        if (richtung == 1){
            xGeschwindigkeit = -geschwindigkeit;
            yGeschwindigkeit = 0;
            
        }
        if (richtung == 0){
            xGeschwindigkeit = 0;
            yGeschwindigkeit = -geschwindigkeit;
        }
        
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public int getRichtung() {
        return richtung;
    }
    
}
