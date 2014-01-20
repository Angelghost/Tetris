package tetris;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angelgosth
 */
public class persoPanel extends JPanel{
    
    private carre[][] matrix ;
    private Tetrominos tetrominos; 
   private Color sameColor=null;
   public persoPanel()
   {
       super();
   }
   /**
    * Setter pour la variable sameColor
    * @param c 
    */
   public void setSameColor(Color c)
   {
       sameColor =c;
   }
   /**
    * Setter pour la matrix d'affichage
    * @param matrix 
    */
    public void setMatrix(carre[][] matrix)
    {
        this.matrix=matrix;
        
    }
    
    /**
     * Setter pour le tétrominos d'affichage
     * @param tetrominos 
     */
    public void printTetrominos(Tetrominos tetrominos)
    {
        this.tetrominos=tetrominos;
        
    }
    
    /**
     * Fonction permettant l'affichage de l'écran
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D)g;
    
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
    super.paintComponent(g2d);
    AffineTransform transform = new AffineTransform() ;
   
    transform.setToScale(option.scale, option.scale);
    transform.translate(option.position.x, option.position.y);
    transform.concatenate(g2d.getTransform());
    g2d.setTransform(transform);
    //on dessine le plateau du tétris
    if(matrix != null)
    {
        for (int i = 0; i< matrix.length ;i++) {
            for (int j = 0; j< matrix[i].length ;j++) {
                if (matrix[i][j].getPlein() == 1 ) {
                    if(sameColor == null || i == 0 || j == 0 ||j == matrix[i].length -1|| i ==matrix.length -1) g2d.setColor(matrix[i][j].getCouleur());
                    else g2d.setColor(sameColor);
                    g2d.fill(matrix[i][j]);
                    g2d.setColor(Color.black);
                    g2d.draw(matrix[i][j]);
                }
                g2d.setColor(Color.white);    
            }
        }
    }
    //dessiner le centre de rotation
    //g2d.drawOval(tetrominos.getCenter().x,tetrominos.getCenter().y,10, 10);
    g2d.setTransform(transform);
    g2d.rotate(tetrominos.getAngle(),tetrominos.getCenter().x, tetrominos.getCenter().y);
    if(tetrominos != null)
    {
        for(carre c: tetrominos.getVecCarre())
        {
            if(sameColor == null) g2d.setColor(c.getCouleur());
            else g2d.setColor(sameColor);
            if(c.getPlein() == 1){
                            g2d.fill(c);
                            g2d.setColor(Color.black);
                            g2d.draw(c);
            }
            g2d.setColor(Color.black);
        }
       
    }
     
}
    
}