package tetris;



// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E67B37D8-C120-0609-23AB-EEDA755321BA]
// </editor-fold> 
public class panel extends view {

    public persoPanel monPanel = new persoPanel();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5447C2E0-4810-DD72-E024-084459812711]
    // </editor-fold> 
    public panel () {
    }
    public persoPanel getPanel()
    {
        return (persoPanel)monPanel;
    }
    @Override
    public void afficher(carre[][] matrix,Tetrominos tetrominos) {
        
        ((persoPanel)monPanel).setSameColor(this.getSameColor());
        ((persoPanel)monPanel).setMatrix(matrix);
        ((persoPanel)monPanel).printTetrominos(tetrominos);
        monPanel.repaint();
    }

}

