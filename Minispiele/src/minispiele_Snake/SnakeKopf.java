/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Snake;

import java.awt.Component;
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
public class SnakeKopf extends JComponent {

    private Image imgFragment;
    private final int MOVE_LEFT, MOVE_RIGHT, MOVE_DOWN, MOVE_UP;
    private int movingDirection;//1 = up; 2 = right; 3 = down; 4 = left
    private boolean LEFT = false, RIGHT = false, UP = false, DOWN = false;
    public Snake snake;
    public LinkedList<Tail> tail = new LinkedList<>();
    public int previousxCoordinate, previousyCoordinate;
    public int taillengt;
    private int[] xPixel = new int[840000];
    private int[] yPixel = new int[840000];
    private Component comp;
    private boolean gameover;

    public SnakeKopf(int taillenght, Component comp) {
        this.taillengt = taillenght;
        this.comp = comp;
        for (int i = 0; i < taillenght; i++) {
            xPixel[i] = 100 - i * 10;
            yPixel[i] = 100;

        }

        try {
            imgFragment = ImageIO.read(this.getClass().getResource("..\\images\\Snake\\SnakeFragment.jpg"));

        } catch (IOException ex) {
            System.out.println("Image not found.");
        }
        MOVE_LEFT = KeyEvent.VK_LEFT;
        MOVE_RIGHT = KeyEvent.VK_RIGHT;
        MOVE_DOWN = KeyEvent.VK_DOWN;
        MOVE_UP = KeyEvent.VK_UP;

    }

    @Override
    public void paintComponent(Graphics gr) {
        for (int i = 0; i <= taillengt; i++) {
            gr.drawImage(imgFragment, xPixel[i], yPixel[i], comp);

        }

    }

    public int getMovingDirection() {
        return movingDirection;
    }

    public void move(int keyCode) {
        int key = keyCode;
        if (key == MOVE_LEFT && movingDirection != 2) {
            LEFT = true;
            RIGHT = false;
            UP = false;
            DOWN = false;

        }
        if (key == MOVE_RIGHT && movingDirection != 4) {
            LEFT = false;
            RIGHT = true;
            UP = false;
            DOWN = false;

        }
        if (key == MOVE_DOWN && movingDirection != 1) {
            LEFT = false;
            RIGHT = false;
            UP = false;
            DOWN = true;

        }
        if (key == MOVE_UP && movingDirection != 3) {
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

    public void moveHead() {
        for (int i = taillengt; i > 0; i--) {
            xPixel[i] = xPixel[(i - 1)];
            yPixel[i] = yPixel[(i - 1)];
        }
        if (movingDirection == 1) {
            if (yPixel[0] - 10 > 0) {
                yPixel[0] -= 10;
            } 
        }
        if (movingDirection == 2) {
            if (xPixel[0] + 10 < snake.WIDTH_FIELD_1 + 10) {
                xPixel[0] += 10;
            } 
        }
        if (movingDirection == 3) {
            if (yPixel[0] + 10 < snake.HEIGHT_FIELD_1 + 10) {
                yPixel[0] += 10;
            } 
        }
        if (movingDirection == 4) {
            if (xPixel[0] - 10 > 0) {
                xPixel[0] -= 10;
            } 
            

        }

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

    public void tailAdd() {
        Tail t = new Tail(previousxCoordinate, previousyCoordinate);
        tail.add(t);
        taillengt++;

    }

    public int getTaillengt() {
        return taillengt;
    }

    
    public void setMovingDirection(int movingDirection) {
        this.movingDirection = movingDirection;
    }

    public int getxPixel() {
        return xPixel[0];
    }

    public int getyPixel() {
        return yPixel[0];
    }

    public void setTaillengt(int taillengt) {
        this.taillengt = taillengt;
    }

    public void collision() {
        if (xPixel[0] < 10) {
            gameover = true;
        }
        if (xPixel[0] > Snake.WIDTH_FIELD_1) {
            gameover = true;
        }
        if (yPixel[0] < 10) {
            gameover = true;
        }
        if (yPixel[0] > Snake.HEIGHT_FIELD_1) {
            gameover = true;
        }
        for (int i = 1; i <= taillengt; i++) {
            if (xPixel[0] == xPixel[i] && yPixel[0] == yPixel[i]) {
                gameover = true;
            }

        }
    }

    boolean getGameover() {
        return gameover;
    }

}
