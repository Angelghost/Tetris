package tetris;

import java.awt.event.MouseEvent;
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4CC04675-08BC-6B10-9EE1-CD7A05D3A0E6]
// </editor-fold> 
/**
 * Classe souris implémentant la classe controleur
 * permettant la gestion de la souris
 * @author Lucas
 */
public class souris extends controleur {

    /**
     * Constructeur par défaut de la classe souris
     * @param myModel 
     */
    public souris (model myModel) {
        
        super(myModel,2);
    }
/**
 * Implémentation de la classe gestionTouche de la classe controleur
 * permettant de décrire les actions lors d'événement de la souris
 * @param o 
 */
    @Override
    public void gestionTouche(Object o){
            MouseEvent evt = (MouseEvent)o;
            savFile.addMove((int)(evt.getX()/option.scale),(int)(evt.getY()/option.scale));
            this.getModel().deplacerTetrominosX((int)(evt.getX()/option.scale));
    }
}

