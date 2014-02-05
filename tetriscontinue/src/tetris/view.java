package tetris;

import java.awt.Color;
/**
 * Classe view est la classe abstract pour l'affichage de notre tétris
 * @author Lucas
 */
public abstract class view {

    private Color sameColor = null;
    /**
     * Construteur par défaut de notre classe view
     */    
    public view () {
    }
    
    /**
     * Getter de sameColor
     * @return 
     */
    public Color getSameColor()
    {
        
        return sameColor;
    }
    public void setSameColor(Color c)
    {
        sameColor=c;
    }

    public abstract void afficher(carre[][] matrix,Tetrominos tetrominos);
}

