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
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Marc
 */
public class tBlock extends JComponent {

    private int xmax, ymax; // Die maximale Größe des Typs vom Block
    private int[][] blockForm; // Speichert die Form des jeweiligen Typs
    private Image img; // Blockbild
    private int ID; // Typ des Blocks
    private int xmom, ymom; // X-/ Y- Position des Blocks

    public void tBLock(int blockID) {

            try {
            img = ImageIO.read( new File("Z:\\GK inf 2Sem\\minispiele\\Minispiele\\src\\images\\Tetris_img\\blockteil.jpg"));
        } catch (IOException e) {
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
            xmax = 0;
            ymax = 3;
            blockForm = new int[][]{{1}, {1}, {1}, {1}};
        }

        if (ID == 1) {
            xmax = 2;
            ymax = 1;
            blockForm = new int[][]{{1, 1, 1}, {0, 1, 0}};
        }

        if (ID == 2) {
            xmax = 1;
            ymax = 1;
            blockForm = new int[][]{{1, 1}, {1, 1}};
        }

        if (ID == 3) {
            xmax = 1;
            ymax = 2;
            blockForm = new int[][]{{1, 0}, {1, 0}, {1, 1}};
        }

        if (ID == 4) {
            xmax = 1;
            ymax = 2;
            blockForm = new int[][]{{0, 1}, {0, 1}, {1, 1}};
        }

        if (ID == 5) {
            xmax = 2;
            ymax = 1;
            blockForm = new int[][]{{0, 1, 1}, {1, 1, 0}};
        }

        if (ID == 6) {
            xmax = 2;
            ymax = 1;
            blockForm = new int[][]{{0, 1, 1}, {1, 1, 0}};
        }

    }

    public void blockZeichnen(Graphics gr){
    for (int i = 0; i < xmax; i++) {
            for (int j = 0; j < ymax; j++) {
                if (blockForm[i][j] == 1) {
                    gr.drawImage(img, ((i + 1) * 30), ((j + 1) * 30), this);
                }

            }

        }
    }
    
    @Override
    public void paintComponent(Graphics gr) {
        //gr.fillRect(0, 0, 30, 30);       
        gr.setColor(Color.red);

        

    }

}
