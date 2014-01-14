package tetris;

import java.awt.Color;
public abstract class view {

    private Color sameColor = null;
        
    public view () {
    }
    
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

