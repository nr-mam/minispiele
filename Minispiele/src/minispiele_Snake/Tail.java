
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
    public Tail next;
    public int taillength =1;

    public Tail(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
        try {
            imgTail = ImageIO.read(this.getClass().getResource("/imagesSnake/SnakeFragment.jpg"));

        } catch (IOException ex) {
            System.out.println("Image not found.");
        }
        imgTail = this.imgTail;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(imgTail, xCoordinate, yCoordinate, this);
        if(next != null){
            next.paintComponent(gr);
        }
        
               
        
        

    }

    public void update(int x, int y) {
        if (next != null) {
            next.update(xCoordinate, yCoordinate);
            xCoordinate = x;
            yCoordinate = y;
            next.repaint();

        }

    }

    public void draw(Graphics g) {
        paintComponent(g);
        if (next != null) {
            next.draw(g);
        }
    }

    public void add() {
        
        if (next == null) {
            next = new Tail(xCoordinate, yCoordinate);
            next.repaint();

        } else {
            next.add();
        }
    }

    public int getTaillength() {
        return taillength;
    }
    

}
