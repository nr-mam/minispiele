/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import static minispiele_PingPong.PingPong.HEIGHT_FIELD;
import static minispiele_PingPong.PingPong.WIDTH_FIELD;


/**
 *
 * @author Richard
 */
public class PingPongFrame extends javax.swing.JFrame {

    private String title;
    private Component comp;
    private Ball ball;

    /**
     * Creates new form PingPongFrame
     */
    public PingPongFrame(String title, Component comp, Ball ball) {
        initComponents();
        //Gewinnermeldung.setLocationRelativeTo(null);
        this.ball = ball;
        this.title = title;
        this.comp = comp;
        
        labelGewinnermeldung.setVisible(false);

        layers.add(comp);
        comp.setBounds(0, 0, WIDTH_FIELD, HEIGHT_FIELD);
        layers.setLayer(comp, JLayeredPane.MODAL_LAYER);
        add(layers);
        setTitle(title);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layers = new javax.swing.JLayeredPane();
        tfPunkteLinks = new javax.swing.JTextField();
        tfPunkteRechts = new javax.swing.JTextField();
        labelGewinnermeldung = new javax.swing.JLabel();
        labelHintergrund = new javax.swing.JLabel();

        tfPunkteLinks.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        tfPunkteLinks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPunkteLinks.setText("0");
        tfPunkteLinks.setFocusable(false);
        layers.add(tfPunkteLinks);
        tfPunkteLinks.setBounds(470, 10, 110, 60);

        tfPunkteRechts.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        tfPunkteRechts.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPunkteRechts.setText("0");
        tfPunkteRechts.setFocusable(false);
        layers.add(tfPunkteRechts);
        tfPunkteRechts.setBounds(620, 10, 110, 60);

        labelGewinnermeldung.setBackground(new java.awt.Color(255, 255, 255));
        labelGewinnermeldung.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelGewinnermeldung.setForeground(new java.awt.Color(255, 0, 0));
        labelGewinnermeldung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        layers.add(labelGewinnermeldung);
        labelGewinnermeldung.setBounds(350, 310, 500, 110);

        labelHintergrund.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PingPongFeld.jpg"))); // NOI18N
        layers.add(labelHintergrund);
        labelHintergrund.setBounds(0, 0, 1200, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layers, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layers, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1216, 788));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    public JTextField getTfPunkteLinks() {
        return tfPunkteLinks;
    }

    public JTextField getTfPunkteRechts() {
        return tfPunkteRechts;
    }

    public JLabel getLabelGewinnermeldung() {
        return labelGewinnermeldung;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel labelGewinnermeldung;
    private javax.swing.JLabel labelHintergrund;
    private javax.swing.JLayeredPane layers;
    private javax.swing.JTextField tfPunkteLinks;
    private javax.swing.JTextField tfPunkteRechts;
    // End of variables declaration//GEN-END:variables
}
