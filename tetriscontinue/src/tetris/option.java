/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;


import java.util.*;
import javax.swing.AbstractButton;
import java.awt.Point;
import java.awt.Color;
/**
 *
 * @author Akmale
 */
public class option extends javax.swing.JFrame {
    
    public static double scale;
    public static Point position;
    
    public option() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controleurGroup = new javax.swing.ButtonGroup();
        radioSouris = new javax.swing.JRadioButton();
        radioClavier = new javax.swing.JRadioButton();
        radioFichier = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        robotFile = new javax.swing.JTextField();
        savFile = new javax.swing.JTextField();
        textScale = new javax.swing.JTextField();
        positionX = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        positionY = new javax.swing.JTextField();
        colorCheck = new javax.swing.JCheckBox();
        jColorChooser1 = new javax.swing.JColorChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controleurGroup.add(radioSouris);
        radioSouris.setText("Souris");
        radioSouris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSourisActionPerformed(evt);
            }
        });

        controleurGroup.add(radioClavier);
        radioClavier.setText("Clavier");
        radioClavier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioClavierActionPerformed(evt);
            }
        });

        controleurGroup.add(radioFichier);
        radioFichier.setText("Lecture de fichier");
        radioFichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFichierActionPerformed(evt);
            }
        });

        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        robotFile.setText("Fichier robot");
        robotFile.setEnabled(false);

        savFile.setText("Fichier de sauvegarde");

        textScale.setText("1");

        positionX.setText("0");

        jLabel1.setText("Scale");

        jLabel2.setText("Position.x");

        jLabel3.setText("Position.y");

        positionY.setText("0");

        colorCheck.setText("Même couleur");
        colorCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorCheckActionPerformed(evt);
            }
        });

        jColorChooser1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jColorChooser1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioSouris)
                                .addGap(68, 68, 68)
                                .addComponent(savFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton1))
                            .addComponent(radioClavier)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioFichier)
                                .addGap(18, 18, 18)
                                .addComponent(robotFile, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(colorCheck))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(positionY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(positionX, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textScale))))
                .addContainerGap(402, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioSouris)
                            .addComponent(savFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioClavier)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(robotFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioFichier))
                        .addGap(27, 27, 27)
                        .addComponent(colorCheck))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(positionX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel1))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(positionY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int controleur=0;
        Enumeration elements = controleurGroup.getElements();
            while (elements.hasMoreElements()) {
              AbstractButton button = (AbstractButton)elements.nextElement();
              if (button.isSelected()) {
                switch(button.getText())
                {
                    case "Clavier":controleur = 3;
                        break;
                    case "Souris" :controleur = 2;
                        break;
                    case "Lecture de fichier":controleur = 1;
                        break;
                }
              }
            }
        System.out.print(textScale.getText());
       option.scale=Double.parseDouble(textScale.getText());
       option.position=new Point(Integer.parseInt(positionX.getText()),Integer.parseInt(positionY.getText()));    
       Color c =jColorChooser1.getColor();
       main.startTetris(controleur,savFile.getText(),robotFile.getText(),colorCheck.isSelected(),c);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioFichierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFichierActionPerformed
        robotFile.setEnabled(true);
        savFile.setEnabled(false);
    }//GEN-LAST:event_radioFichierActionPerformed

    private void radioClavierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioClavierActionPerformed
        robotFile.setEnabled(false);
        savFile.setEnabled(true);
    }//GEN-LAST:event_radioClavierActionPerformed

    private void radioSourisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSourisActionPerformed
         robotFile.setEnabled(false);
         savFile.setEnabled(true);
    }//GEN-LAST:event_radioSourisActionPerformed

    private void colorCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorCheckActionPerformed
        if(colorCheck.isSelected()) jColorChooser1.setEnabled(true);
        else jColorChooser1.setEnabled(false);
    }//GEN-LAST:event_colorCheckActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox colorCheck;
    private javax.swing.ButtonGroup controleurGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField positionX;
    private javax.swing.JTextField positionY;
    private javax.swing.JRadioButton radioClavier;
    private javax.swing.JRadioButton radioFichier;
    private javax.swing.JRadioButton radioSouris;
    private javax.swing.JTextField robotFile;
    private javax.swing.JTextField savFile;
    private javax.swing.JTextField textScale;
    // End of variables declaration//GEN-END:variables
}
