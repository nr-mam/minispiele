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

    public SnakeTail(int x, int y) {
        try {
            imgTail = ImageIO.read(this.getClass().getResource("..\\images\\SnakeFragment.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(SnakeTail.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgTail = this.imgTail;
        xCoordinate = x;
        yCoordinate = y;
        
        
    }
    

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr); 
        gr.drawImage(imgTail, 0, 0, this);
    }
    
    
    
    
}
