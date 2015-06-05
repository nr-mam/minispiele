/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import minispiele_PingPong.PingPong;

/**
 *
 * @author Marc
 */
public class TBaustein extends JComponent {

    private int xmax, ymax; // Die maximale Größe des Typs vom Block
    private int[][] blockForm; // Speichert die Form des jeweiligen Typs
    private Image img; // Blockbild
    private int ID; // Typ des Blocks
    private int X, Y; // X-/ Y- Position des Blocks
    private int queue; // Wartezeit, bis der Block sich um eine Ebene bewegen soll

    TBaustein(int blockID) {
        X = 180;
        Y = 30;
        queue = 0;

        try {
            img = ImageIO.read(new File("D:\\Eigene Dokumente\\NetBeansProjects\\minispiele\\Minispiele\\src\\images\\Tetris_img\\Block_blau.jpg"));
        } catch (IOException e) {
            System.out.println("Couldn't find Image.");
        }

        if (blockID == -1) {
            Random r = new Random();
            ladeBloecke(r.nextInt(7));
        } else {
            ladeBloecke(blockID);
        }
    }

    private void ladeBloecke(int ID) {

        this.ID = ID;

        if (ID == 0) {
            blockForm = new int[][]{{1}, {1}, {1}, {1}};
        }

        if (ID == 1) {
            blockForm = new int[][]{{1, 1, 1}, {0, 1, 0}};
        }

        if (ID == 2) {
            blockForm = new int[][]{{1, 1}, {1, 1}};
        }

        if (ID == 3) {
            blockForm = new int[][]{{1, 0}, {1, 0}, {1, 1}};
        }

        if (ID == 4) {
            blockForm = new int[][]{{0, 1}, {0, 1}, {1, 1}};
        }

        if (ID == 5) {
            blockForm = new int[][]{{0, 1, 1}, {1, 1, 0}};
        }

        if (ID == 6) {
            blockForm = new int[][]{{0, 1, 1}, {1, 1, 0}};
        }

        ymax = blockForm.length;
        xmax = blockForm[ymax - 1].length;

    }

    @Override
    public void paintComponent(Graphics gr) {

        for (int i = 0; i < blockForm.length; i++) {
            for (int j = 0; j < blockForm[i].length; j++) {
                if (blockForm[i][j] == 1) {
                    gr.drawImage(img, ((i * 30)+X), ((j * 30)+Y), this);
                }

            }

        }

    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    //Methoden zur Blockbewegung
    public void moveBlockLeft(int grenze) {
        if (grenze!=X){
        X -= 30;
        }
        
    }

    public void moveBlockRight(int grenze) {
        if (grenze!=(X+(30*(ymax-1)))){
        X += 30;
        }
    }

    public boolean moveBlockDown(int grenze) {
        queue++;
        if(queue > 5){
        Y += 30;
        queue = 0;
        } else {
        
        }
        if (grenze==(Y+(30*(xmax-2)))){
        return true;
        }
        
        return false;           
    }

}
