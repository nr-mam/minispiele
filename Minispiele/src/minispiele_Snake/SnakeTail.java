/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Snake;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author nmamerow
 */
public class SnakeTail extends JComponent{
    private Image imgTail;
    private int xCoordinate, yCoordinate;
    private SnakeKopf head;

    public SnakeTail(int x, int y) {
        try {
            imgTail = ImageIO.read(this.getClass().getResource("..\\images\\SnakeFragment.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(SnakeTail.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgTail = this.imgTail;
        xCoordinate = x;
        yCoordinate = y;
        repaint();
        
        
    }
    

    @Override
    protected void paintComponent(Graphics gr) {
        gr.drawImage(imgTail, xCoordinate, yCoordinate, this);
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    
    
    
    
}
