/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import minispiele_PingPong.Einstellungen;
import minispiele_Snake.Snake;
import minispiele_Tetris.Tetris;
import minispiele_Tetris.TetrisSteuerung;

/**
 *
 * @author Marc
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(1080, 726);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSnake = new javax.swing.JLabel();
        jLabelTetris = new javax.swing.JLabel();
        jLabelBeenden = new javax.swing.JLabel();
        jLabelPingPong = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSnake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonSnake.jpg"))); // NOI18N
        jLabelSnake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSnakeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSnakeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelSnakeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelSnakeMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelSnake, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 520, -1));

        jLabelTetris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonTetris.jpg"))); // NOI18N
        jLabelTetris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelTetrisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelTetrisMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelTetrisMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelTetrisMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelTetris, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 440, 520, 90));

        jLabelBeenden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonBeenden.jpg"))); // NOI18N
        jLabelBeenden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBeendenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBeendenMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelBeendenMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelBeendenMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelBeenden, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 550, 520, -1));

        jLabelPingPong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonPingPong.jpg"))); // NOI18N
        jLabelPingPong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPingPongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPingPongMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelPingPongMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelPingPongMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelPingPong, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 250, 500, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundHauptmenüMinispiele.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // PING PONG Botton
    private void jLabelPingPongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPingPongMouseEntered
        jLabelPingPong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonPingPongE.jpg")));
    }//GEN-LAST:event_jLabelPingPongMouseEntered

    private void jLabelPingPongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPingPongMousePressed
        jLabelPingPong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonPingPongP.jpg")));
    }//GEN-LAST:event_jLabelPingPongMousePressed

    private void jLabelPingPongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPingPongMouseExited
        jLabelPingPong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonPingPong.jpg")));
    }//GEN-LAST:event_jLabelPingPongMouseExited

    private void jLabelPingPongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPingPongMouseReleased
        jLabelPingPong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonPingPongE.jpg")));
        Einstellungen einstellungen = new Einstellungen();
        einstellungen.setVisible(true);
    }//GEN-LAST:event_jLabelPingPongMouseReleased
    // SNAKE Botton
    private void jLabelSnakeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSnakeMouseEntered
        jLabelSnake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonSnakeE.jpg")));
    }//GEN-LAST:event_jLabelSnakeMouseEntered

    private void jLabelSnakeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSnakeMouseExited
        jLabelSnake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonSnake.jpg")));
    }//GEN-LAST:event_jLabelSnakeMouseExited

    private void jLabelSnakeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSnakeMousePressed
        jLabelSnake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonSnakeP.jpg")));
    }//GEN-LAST:event_jLabelSnakeMousePressed

    private void jLabelSnakeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSnakeMouseReleased
        jLabelSnake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonSnakeE.jpg")));
        new Snake();
    }//GEN-LAST:event_jLabelSnakeMouseReleased

    //TETRIS Botton
    private void jLabelTetrisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTetrisMouseEntered
        jLabelTetris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonTetrisE.jpg")));
    }//GEN-LAST:event_jLabelTetrisMouseEntered

    private void jLabelTetrisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTetrisMouseExited
        jLabelTetris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonTetris.jpg")));
    }//GEN-LAST:event_jLabelTetrisMouseExited

    private void jLabelTetrisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTetrisMousePressed
        jLabelTetris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonTetrisP.jpg")));
    }//GEN-LAST:event_jLabelTetrisMousePressed

    private void jLabelTetrisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTetrisMouseReleased
        jLabelTetris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonTetrisE.jpg")));
        new TetrisSteuerung();
    }//GEN-LAST:event_jLabelTetrisMouseReleased

    //BEENDEN Botton
    private void jLabelBeendenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBeendenMouseEntered
        jLabelBeenden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonBeendenE.jpg")));
    }//GEN-LAST:event_jLabelBeendenMouseEntered

    private void jLabelBeendenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBeendenMouseExited
        jLabelBeenden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonBeenden.jpg")));
    }//GEN-LAST:event_jLabelBeendenMouseExited

    private void jLabelBeendenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBeendenMousePressed
        jLabelBeenden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonBeendenP.jpg")));
    }//GEN-LAST:event_jLabelBeendenMousePressed

    private void jLabelBeendenMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBeendenMouseReleased
        jLabelBeenden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu/BottonBeendenE.jpg")));
        System.exit(0);
    }//GEN-LAST:event_jLabelBeendenMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    private ImageIcon ii;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBeenden;
    private javax.swing.JLabel jLabelPingPong;
    private javax.swing.JLabel jLabelSnake;
    private javax.swing.JLabel jLabelTetris;
    // End of variables declaration//GEN-END:variables
}
