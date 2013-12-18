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
import static tetris.model.taill_block;

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
    
    public static void startTetris(int controleur,String nomSavFile, String robotNameFile,boolean sameColor, Color c)
    {
        if(controleur == 0) return;
        
        
        myOption.setVisible(false);
         final Tetris myTetris = new Tetris();
         if(sameColor == true)  myTetris.getView().setSameColor(c);
         myTetris.setModel(new model(myTetris.getView()));
         switch(controleur)
         {
             case 1: {
                 tetrominosFactory.setModCreation(2);
                 tetrominosFactory.setNameFileSeq(robotNameFile+".seq");
                    myTetris.setControleur(new lecteurSeq(myTetris.getModel(),robotNameFile+".SAV"));
                      myTetris.getModel().timer1=new Timer(10,new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                   myTetris.getControleur().gestionTouche(null);
                                }
                            });
                        myTetris.getModel().timer1.start();
                           
                    }
                 break;
             case 2: {
                 tetrominosFactory.setModCreation(1);
                 tetrominosFactory.setNameFileSav(nomSavFile+".seq");
                 myTetris.setControleur(new souris(myTetris.getModel()));  
                 myTetris.getModel().timer1=new Timer(500,new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e){
                                 myTetris.getModel().deplacerTetrominosY(taill_block);
                                savFile.addDesc(0, taill_block);
                             }
                         });
                        myTetris.getModel().timer1.start();
             }
                 break;
             
             
         }
        
        myTetris.setVisible(true);  
        myTetris.getControleur().addSavFile(nomSavFile+".SAV");
        myTetris.getModel().start();
    }
}
