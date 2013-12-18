package tetris;

import java.awt.Color;
public abstract class view {
    // The views width and height
    private int viewHeight = 0;
    private int viewWidth = 0;    
    
    private Color sameColor = null;
        
    public view () {
    }
    
    public int getViewHeight () {
        return viewHeight;
    }
    public Color getSameColor()
    {
        
        return sameColor;
    }
    public void setSameColor(Color c)
    {
        sameColor=c;
    }
    public void setViewHeight (int val) {
        this.viewHeight = val;
    }
    
    public int getViewWidth () {
        return viewWidth;
    }

    public void setViewWidth (int val) {
        this.viewWidth = val;
    }
    
    public abstract void afficher(carre[][] matrix,Tetrominos tetrominos);
}

