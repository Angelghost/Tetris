package tetris;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.font.FontRenderContext;

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
    private int taill_block =20;
    private Tetrominos tetrominos; 
   
    public void setTaille(int taille)
    {
        taill_block=taille;
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
    Rectangle2D r2d;
    AffineTransform transform = new AffineTransform() ;
    Shape rotatedRect;
 
    if(matrix != null)
    {
        for(int i=0;i<matrix.length;i++)
        {
          for(int j=0;j<matrix[i].length;j++)
            {
               
                g2d.setColor(matrix[i][j].getCouleur());
                if(matrix[i][j].getPlein() == 1){
                    g2d.fill(matrix[i][j]);
                    g2d.setColor(Color.black);
                    g2d.draw(matrix[i][j]);
                }
                  g2d.setColor(Color.black);
 
            }
        }
    }

    g2d.setTransform(transform);
    g2d.rotate(tetrominos.getAngle(),tetrominos.getCenter().x, tetrominos.getCenter().y);
    if(tetrominos != null)
    {
        for(int i=0;i<tetrominos.listeCarre.length;i++)
        {
          for(int j=0;j<tetrominos.listeCarre[i].length;j++)
            {
                if(tetrominos.listeCarre[i][j].getPlein() == 1)
                {
                    g2d.setColor(tetrominos.listeCarre[i][j].getCouleur());
                        if(tetrominos.listeCarre[i][j].getPlein() == 1){
                            g2d.fill(tetrominos.listeCarre[i][j]);
                            g2d.setColor(Color.black);
                            g2d.draw(tetrominos.listeCarre[i][j]);
                        }
                          g2d.setColor(Color.black);
 
                   
                }
            }
        }
    }
     
}
    
}