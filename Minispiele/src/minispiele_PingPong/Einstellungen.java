/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele_PingPong;

import java.awt.Color;

/**
 *
 * @author Richard
 */
public class Einstellungen extends javax.swing.JFrame {

    private final int SCHWER, MITTEL, LEICHT;
    public static int maxPunkte;
    private boolean multiplayer, solo;
    public static int schwierigkeit;
    private Color colorKI, colorP1, colorP2;

    /**
     * Creates new form Einstellungen
     */
    public Einstellungen() {

        SCHWER = 11;
        MITTEL = 10;
        LEICHT = 9;
        schwierigkeit = LEICHT;
        multiplayer = false;
        solo = false;
        colorKI = Color.RED;
        colorP1 = Color.WHITE;
        colorP2 = Color.ORANGE;

        initComponents();
        maxPunkte = 1;
        losButton.setEnabled(false);
        ComputerPanel.setVisible(false);
        Spieler2Panel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        multiplayerButton = new javax.swing.JToggleButton();
        soloButton = new javax.swing.JToggleButton();
        zurueck = new javax.swing.JButton();
        losButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Spieler2Panel = new javax.swing.JPanel();
        Spieler2ComboBox = new javax.swing.JComboBox();
        LabelFarbe2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Spieler1Panel = new javax.swing.JPanel();
        Spieler1ComboBox = new javax.swing.JComboBox();
        LabelFarbe1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComputerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        KIComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        MaxPunktzahlTF = new javax.swing.JTextField();

        setTitle("Einstellungen");
        setBackground(new java.awt.Color(0, 0, 0));

        multiplayerButton.setText("Multiplayer");
        multiplayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplayerButtonActionPerformed(evt);
            }
        });

        soloButton.setText("Solo");
        soloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soloButtonActionPerformed(evt);
            }
        });

        zurueck.setText("Zurück");
        zurueck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zurueckActionPerformed(evt);
            }
        });

        losButton.setText("Los!");
        losButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                losButtonActionPerformed(evt);
            }
        });

        Spieler2Panel.setBackground(new java.awt.Color(204, 204, 204));

        Spieler2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "orange", "rot", "weiß" }));
        Spieler2ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Spieler2ComboBoxActionPerformed(evt);
            }
        });

        LabelFarbe2.setText("Farbe:");

        jLabel1.setText("Spieler 2:");

        javax.swing.GroupLayout Spieler2PanelLayout = new javax.swing.GroupLayout(Spieler2Panel);
        Spieler2Panel.setLayout(Spieler2PanelLayout);
        Spieler2PanelLayout.setHorizontalGroup(
            Spieler2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Spieler2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Spieler2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelFarbe2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(Spieler2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Spieler2PanelLayout.setVerticalGroup(
            Spieler2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Spieler2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(Spieler2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelFarbe2)
                    .addComponent(Spieler2ComboBox))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        Spieler1Panel.setBackground(new java.awt.Color(204, 204, 204));

        Spieler1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "weiß", "orange", "rot" }));
        Spieler1ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Spieler1ComboBoxActionPerformed(evt);
            }
        });

        LabelFarbe1.setText("Farbe:");

        jLabel2.setText("Spieler 1:");

        javax.swing.GroupLayout Spieler1PanelLayout = new javax.swing.GroupLayout(Spieler1Panel);
        Spieler1Panel.setLayout(Spieler1PanelLayout);
        Spieler1PanelLayout.setHorizontalGroup(
            Spieler1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Spieler1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(110, 110, 110)
                .addComponent(LabelFarbe1)
                .addGap(18, 18, 18)
                .addComponent(Spieler1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Spieler1PanelLayout.setVerticalGroup(
            Spieler1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Spieler1PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Spieler1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LabelFarbe1)
                    .addComponent(Spieler1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ComputerPanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Computer:");

        jLabel4.setText("Farbe:");

        KIComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "rot", "orange", "weiß" }));
        KIComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KIComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Schwierigkeit:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "leicht", "mittel", "schwer" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ComputerPanelLayout = new javax.swing.GroupLayout(ComputerPanel);
        ComputerPanel.setLayout(ComputerPanelLayout);
        ComputerPanelLayout.setHorizontalGroup(
            ComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComputerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(ComputerPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(ComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(KIComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        ComputerPanelLayout.setVerticalGroup(
            ComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComputerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(ComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(KIComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("maximale Punktzahl:");

        MaxPunktzahlTF.setText("1");
        MaxPunktzahlTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MaxPunktzahlTFFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(multiplayerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Spieler1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(MaxPunktzahlTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Spieler2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addComponent(ComputerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zurueck)
                        .addGap(18, 18, 18)
                        .addComponent(losButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multiplayerButton)
                    .addComponent(soloButton))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Spieler1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Spieler2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(MaxPunktzahlTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ComputerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zurueck)
                    .addComponent(losButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void zurueckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zurueckActionPerformed
        setVisible(false);

    }//GEN-LAST:event_zurueckActionPerformed

    private void multiplayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplayerButtonActionPerformed
        losButton.setEnabled(true);
        if (soloButton.isSelected()) {
            soloButton.setSelected(false);
            solo = false;
            ComputerPanel.setVisible(false);
        }
        Spieler2Panel.setVisible(true);
        multiplayer = true;

    }//GEN-LAST:event_multiplayerButtonActionPerformed

    private void soloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soloButtonActionPerformed
        losButton.setEnabled(true);
        if (multiplayerButton.isSelected()) {
            multiplayerButton.setSelected(false);
            multiplayer = false;
            Spieler2Panel.setVisible(false);
        }
        ComputerPanel.setVisible(true);
        solo = true;
    }//GEN-LAST:event_soloButtonActionPerformed

    private void losButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_losButtonActionPerformed
        setVisible(false);
        if (solo) {
            new PingPong(new Spieler(100, colorP1), new KI(1100, colorKI, LEICHT));
        } else {
            new PingPong(new Spieler(100, colorP1), new Spieler(1100, colorP2));
        }

    }//GEN-LAST:event_losButtonActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        setSchwierigkeit();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void MaxPunktzahlTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MaxPunktzahlTFFocusLost
        setMaxPunkte();
    }//GEN-LAST:event_MaxPunktzahlTFFocusLost

    private void Spieler2ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Spieler2ComboBoxActionPerformed
        setColor();
    }//GEN-LAST:event_Spieler2ComboBoxActionPerformed

    private void KIComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KIComboBoxActionPerformed
        setColor();
    }//GEN-LAST:event_KIComboBoxActionPerformed

    private void Spieler1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Spieler1ComboBoxActionPerformed
        setColor();
    }//GEN-LAST:event_Spieler1ComboBoxActionPerformed

    public void setMaxPunkte() {
        maxPunkte = Integer.parseInt(MaxPunktzahlTF.getText());
    }

    public void setColor() {

        //Spieler1 Farbe
        if (Spieler1ComboBox.getSelectedItem().equals("rot")) {
            colorP1 = Color.RED;
        }
        if (Spieler1ComboBox.getSelectedItem().equals("orange")) {
            colorP1 = Color.ORANGE;
        }
        if (Spieler1ComboBox.getSelectedItem().equals("weiß")) {
            colorP1 = Color.WHITE;
        }
        if (Spieler1ComboBox.getSelectedItem().equals("blau")) {
            colorP1 = Color.BLUE;
        }
        if (Spieler1ComboBox.getSelectedItem().equals("grün")) {
            colorP1 = Color.GREEN;
        }
        
        //Spieler2 Farbe
        if (Spieler2ComboBox.getSelectedItem().equals("rot")) {
            colorP2 = Color.RED;
        }
        if (Spieler2ComboBox.getSelectedItem().equals("orange")) {
            colorP2 = Color.ORANGE;
        }
        if (Spieler2ComboBox.getSelectedItem().equals("weiß")) {
            colorP2 = Color.WHITE;
        }
        if (Spieler2ComboBox.getSelectedItem().equals("blau")) {
            colorP2 = Color.BLUE;
        }
        if (Spieler2ComboBox.getSelectedItem().equals("grün")) {
            colorP2 = Color.GREEN;
        }
        
        //KI Farbe
        if (KIComboBox.getSelectedItem().equals("rot")) {
            colorKI = Color.RED;
        }
        if (KIComboBox.getSelectedItem().equals("orange")) {
            colorKI = Color.ORANGE;
        }
        if (KIComboBox.getSelectedItem().equals("weiß")) {
            colorKI = Color.WHITE;
        }
        if (KIComboBox.getSelectedItem().equals("blau")) {
            colorKI = Color.BLUE;
        }
        if (KIComboBox.getSelectedItem().equals("grün")) {
            colorKI = Color.GREEN;
        }
    }

    public void setSchwierigkeit() {

        if (jComboBox2.getSelectedItem().equals("schwer")) {
            schwierigkeit = SCHWER;
        }
        if (jComboBox2.getSelectedItem().equals("mittel")) {
            schwierigkeit = MITTEL;
        }
        if (jComboBox2.getSelectedItem().equals("leicht")) {
            schwierigkeit = LEICHT;
        }

    }

    public int getSchwierigkeit() {
        return schwierigkeit;
    }

    public int getMaxPunkte() {
        return maxPunkte;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ComputerPanel;
    private javax.swing.JComboBox KIComboBox;
    private javax.swing.JLabel LabelFarbe1;
    private javax.swing.JLabel LabelFarbe2;
    private javax.swing.JTextField MaxPunktzahlTF;
    private javax.swing.JComboBox Spieler1ComboBox;
    private javax.swing.JPanel Spieler1Panel;
    private javax.swing.JComboBox Spieler2ComboBox;
    private javax.swing.JPanel Spieler2Panel;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton losButton;
    private javax.swing.JToggleButton multiplayerButton;
    private javax.swing.JToggleButton soloButton;
    private javax.swing.JButton zurueck;
    // End of variables declaration//GEN-END:variables
}
