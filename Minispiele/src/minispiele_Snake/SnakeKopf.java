/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Snake;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
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
public class SnakeKopf extends JComponent{

    private Image imgFragment;
    //private int size = pictureSnakeSize();
    private int MOVE_LEFT, MOVE_RIGHT, MOVE_DOWN, MOVE_UP;
    private int movingDirection;
    private boolean LEFT = false, RIGHT = false, UP = false, DOWN = false;
    public int xCoordinate =  10 * (int)((Math.random())*(Snake.WIDTH_FIELD/10 -10)),
            yCoordinate = 10 * (int)((Math.random())*(Snake.HEIGHT_FIELD/10 -10));
    public Snake snake;
    public LinkedList<Tail> tail = new LinkedList<>();
    public int previousxCoordinate, previousyCoordinate; 
    public int taillengt = 0;

    public SnakeKopf() {
        try {
            imgFragment = ImageIO.read(this.getClass().getResource("..\\images\\SnakeFragment.jpg"));

        } catch (IOException ex) {
            System.out.println("Image not found.");
        }
        MOVE_LEFT = KeyEvent.VK_LEFT;
        MOVE_RIGHT = KeyEvent.VK_RIGHT;
        MOVE_DOWN = KeyEvent.VK_DOWN;
        MOVE_UP = KeyEvent.VK_UP;
    }

    /*private int pictureSnakeSize() {
        if (imgFragment.getHeight(null) != imgFragment.getWidth(null)) {
            throw new NumberFormatException("Das Bild ist nicht quadratisch.");
        }
        return imgFragment.getHeight(null);
    }
    */

    public int getMovingDirection() {
        return movingDirection;
    }

    public void move(int keyCode) {
        int key = keyCode;
        if (key == MOVE_LEFT) {
            LEFT = true;
            RIGHT = false;
            UP = false;
            DOWN = false;

        }
        if (key == MOVE_RIGHT) {
            LEFT = false;
            RIGHT = true;
            UP = false;
            DOWN = false;

        }
        if (key == MOVE_DOWN) {
            LEFT = false;
            RIGHT = false;
            UP = false;
            DOWN = true;

        }
        if (key == MOVE_UP) {
            LEFT = false;
            RIGHT = false;
            UP = true;
            DOWN = false;
        }
        
    }

    public boolean isLEFT() {
        return LEFT;
    }

    public boolean isRIGHT() {
        return RIGHT;
    }

    public boolean isUP() {
        return UP;
    }

    public boolean isDOWN() {
        return DOWN;
    }

    public void moveHeadUp() {
        previousyCoordinate = yCoordinate;
        if (yCoordinate - 10 > 0) {
            yCoordinate -= 10;
        } else {
            snake.setGameover(true);
        }

    }

    public void moveHeadDown() {
        previousyCoordinate = yCoordinate;
        if (yCoordinate + 10 < snake.HEIGHT_FIELD+10) {
            yCoordinate += 10;
        } else {
            snake.setGameover(true);
        }
        
                

    }

    public void moveHeadLeft() {
        previousxCoordinate = xCoordinate;
        if (xCoordinate - 10 > 0) {
            xCoordinate -= 10;
        } else {
            snake.setGameover(true);;
        }
    }

    public void moveHeadRight() {
        previousxCoordinate = xCoordinate;
        if (xCoordinate + 10 < snake.WIDTH_FIELD +10) {
            xCoordinate += 10;
        } else {
            snake.setGameover(true);
        }

    }

    //public int getSizeHead() {
    //    return size;
    //}
    public void paintComponent(Graphics gr) {
        gr.drawImage(imgFragment, xCoordinate, yCoordinate, this);
        

    }

    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
    }

    public void setUP(boolean UP) {
        this.UP = UP;
    }

    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
    }
    public void tailAdd(){
        Tail t = new Tail(previousxCoordinate,previousyCoordinate);
        tail.add(t);
        taillengt++;
        
    }

    public int getTaillengt() {
        return taillengt;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
    
    

}
