/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Snake;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author nmamerow
 */
public class Tail extends JComponent {

    public int xCoordinate, yCoordinate;
    public Image imgTail;

    public Tail() {
        try {
            imgTail = ImageIO.read(this.getClass().getResource("..\\images\\SnakeFragment.jpg"));

        } catch (IOException ex) {
            System.out.println("Image not found.");
        }
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void paintComponent(Graphics gr) {
        gr.drawImage(imgTail, xCoordinate, yCoordinate, this);

    }
}
