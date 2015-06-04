/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_Tetris;

import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author Marc
 */
public class Block extends JComponent{

    private int xmax, ymax; // Die maximale Größe des Typs vom Block
    private int[][] blockForm; // Speichert die Form des jeweiligen Typs
    private Image img; // Blockbild
    private int ID; // Typ des Blocks
    private int xmom, ymom; // X-/ Y- Position des Blocks
    
    public Block() {
    
        
        
    }
    
    private void ladeBlockfolge(){
    
        
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
    
}
