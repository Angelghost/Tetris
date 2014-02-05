package tetris;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe clavier permettant la gestion du clavier pour 
 * jouer (pas encore implémenté)
 * @author Akmale
 */
public class clavier extends controleur {
  
    /**
     * Contructeur de base pour la classe clavier.
     * @param myModel 
     */
    public clavier (model myModel) {
        
        super(myModel,3);
    }
    /**
     *  Implementation de la focntion principale de la 
     * classe controleur
     * @param o 
     */
    @Override
    public void gestionTouche(Object o){
            
       //        myModel.deplacerTetrominos(evt.getX(),evt.getY());
    }
}
