package tetris;


public abstract class view {
    // The views width and height
    private int viewHeight = 0;
    private int viewWidth = 0;    
        
    public view () {
    }
    
    public int getViewHeight () {
        return viewHeight;
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

