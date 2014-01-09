/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Color;

/**
 *
 * @author Akmale
 */
public class main {
    public static option myOption;
    
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
            java.util.logging.Logger.getLogger(option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        myOption=new option();
        myOption.setVisible(true);
    }
    
    /**
     * Fonction qui lance le Tétris
     * @param controleur
     * @param nomSavFile
     * @param robotNameFile
     * @param sameColor
     * @param c 
     */
    public static void startTetris(int controleur,String nomSavFile, String robotNameFile,boolean sameColor, Color c)
    {
        if(controleur == 0) return;
        
        
        myOption.setVisible(false);
         final Tetris myTetris = new Tetris();
         if(sameColor == true)  myTetris.getView().setSameColor(c);
         myTetris.setModel(new model());
         switch(controleur)
         {
             case 1: {
                 tetrominosFactory.setModCreation(2);
                 tetrominosFactory.setNameFileSeq(robotNameFile+".seq");
                    myTetris.setControleur(new lecteurSeq(myTetris.getModel(),robotNameFile+".SAV"));
                      myTetris.getModel().setTimer(new Timer(10,new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                   myTetris.getControleur().gestionTouche(null);
                                }
                            }));
                        myTetris.getModel().getTimer().start();
                           
                    }
                 break;
             case 2: {
                 tetrominosFactory.setModCreation(1);
                 tetrominosFactory.setNameFileSav(nomSavFile+".seq");
                 myTetris.setControleur(new souris(myTetris.getModel()));  
                 myTetris.getModel().setTimer(new Timer(100,new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e){
                                 myTetris.getModel().deplacerTetrominosY(1);
                                savFile.addDesc(0, 1);
                             }
                         }));
                        myTetris.getModel().getTimer().start();
             }
                 break;
             
             
         }
        
        myTetris.setVisible(true);  
        myTetris.getControleur().addSavFile(nomSavFile+".SAV");
        myTetris.getModel().start();
    }
}
