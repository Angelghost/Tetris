package tetris;

import java.awt.event.MouseEvent;
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4CC04675-08BC-6B10-9EE1-CD7A05D3A0E6]
// </editor-fold> 
public class souris extends controleur {

    
    public souris (model myModel) {
        
        super(myModel,2);
    }

    @Override
    public void gestionTouche(Object o){
            MouseEvent evt = (MouseEvent)o;
            savFile.addMove((int)evt.getX()/getScale(),(int)evt.getY()/getScale());
            myModel.deplacerTetrominosX(evt.getX()/getScale());
    }
}

