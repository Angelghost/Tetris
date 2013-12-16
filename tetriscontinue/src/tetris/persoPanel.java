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
   
   public persoPanel()
   {
       super();
   }
   
    public void setMatrix(carre[][] matrix)
    {
        this.matrix=matrix;
        
    }
    
    public void printTetrominos(Tetrominos tetrominos)
    {
        this.tetrominos=tetrominos;
        
    }
    
    
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
    if(matrix != null)
    {
        for (carre[] matrix1 : matrix) {
            for (carre matrix11 : matrix1) {
                g2d.setColor(matrix11.getCouleur());
                if (matrix11.getPlein() == 1) {
                    g2d.fill(matrix11);
                    g2d.setColor(Color.black);
                    g2d.draw(matrix11);
                }
                g2d.setColor(Color.black);    
            }
        }
    }
    g2d.drawOval(tetrominos.getCenter().x,tetrominos.getCenter().y,10, 10);
    g2d.setTransform(transform);
    g2d.rotate(tetrominos.getAngle(),tetrominos.getCenter().x, tetrominos.getCenter().y);
    if(tetrominos != null)
    {
        for(carre c: tetrominos.vecCarre)
        {
            g2d.setColor(c.getCouleur());
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