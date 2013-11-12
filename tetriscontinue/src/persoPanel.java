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
    
    private char[][] matrix ;
    private int taill_block =20;
    private Tetrominos tetrominos; 
   
    public void setTaille(int taille)
    {
        taill_block=taille;
    }
    public void setMatrix(char[][] matrix)
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
    AffineTransform transform ;
    Shape rotatedRect;
 
    if(matrix != null)
    {
        for(int i=0;i<matrix.length;i++)
        {
          for(int j=0;j<matrix[i].length;j++)
            {

                g2d.setColor(getColor(matrix[i][j]));
                g2d.drawRect(j*taill_block, i*taill_block, taill_block, taill_block);
                g2d.setColor(Color.black);
            }
        }
    }
    int X=(int)(tetrominos.coordonne.x+tetrominos.distanceMinX().x)/taill_block;
    int Y=tetrominos.coordonne.y/taill_block;
    g2d.drawString("position : "+ (int)matrix[Y][X]+"matrix["+Y+"]["+X+"]", 400, 30);
    
    g2d.setColor(Color.RED);
    r2d = new Rectangle2D.Double(tetrominos.distanceMinX().x, tetrominos.distanceMinX().y, taill_block, taill_block);                    
    transform = new AffineTransform();
    transform.translate(tetrominos.coordonne.x, tetrominos.coordonne.y);
    rotatedRect = transform.createTransformedShape(r2d);
    g2d.fill(rotatedRect );
    r2d = new Rectangle2D.Double(tetrominos.distanceMaxX().x, tetrominos.distanceMaxX().y, taill_block, taill_block);                    
    transform = new AffineTransform();
    transform.translate(tetrominos.coordonne.x, tetrominos.coordonne.y);
    rotatedRect = transform.createTransformedShape(r2d);
    g2d.fill(rotatedRect );
    r2d = new Rectangle2D.Double(tetrominos.distanceMaxY().x, tetrominos.distanceMaxY().y, taill_block, taill_block);                    
    transform = new AffineTransform();
    transform.translate(tetrominos.coordonne.x, tetrominos.coordonne.y);
    rotatedRect = transform.createTransformedShape(r2d);
    g2d.fill(rotatedRect );
    g2d.setColor(Color.BLACK);
    g2d.drawString("position :"+(int)(tetrominos.coordonne.y+Math.ceil(tetrominos.distanceMinY().y))/taill_block+"miny/", 300, 30);

    g2d.drawString("position :"+(int)(tetrominos.coordonne.y+Math.ceil(tetrominos.distanceMaxY().y))/taill_block+"maxy/", 300, 40);

    g2d.drawString("position :"+(int)(tetrominos.coordonne.x+Math.ceil(tetrominos.distanceMaxX().x))/taill_block+"maxx/", 300, 50);
    
    X=tetrominos.coordonne.x/taill_block;
    Y=(int)((tetrominos.coordonne.y+Math.ceil(tetrominos.distanceMaxY().y))/taill_block);
    g2d.drawString("position : "+ (int)matrix[Y][X]+"matrix["+Y+"]["+X+"]", 400, 40);

    g2d.drawString("Angle:"+tetrominos.getAngle()+"-"+Math.toRadians(45)+"-"+Math.toDegrees(tetrominos.getAngle())+"", 300, 60);
    
    
    
    g2d.setColor(Color.RED);
    g2d.drawLine(tetrominos.coordonne.x,tetrominos.coordonne.y, tetrominos.coordonne.x+(int)(tetrominos.distanceMinX().x), tetrominos.coordonne.y);
    g2d.setColor(Color.YELLOW);
    g2d.drawLine(tetrominos.coordonne.x,tetrominos.coordonne.y, tetrominos.coordonne.x+(int)(tetrominos.distanceMaxX().x), tetrominos.coordonne.y);
    g2d.setColor(Color.GREEN);
    g2d.drawLine(tetrominos.coordonne.x,tetrominos.coordonne.y, tetrominos.coordonne.x, tetrominos.coordonne.y+(int)tetrominos.distanceMaxY().y);
    g2d.setColor(Color.MAGENTA);
    g2d.drawLine(tetrominos.coordonne.x,tetrominos.coordonne.y, tetrominos.coordonne.x, tetrominos.coordonne.y+(int)tetrominos.distanceMinY().y);
    
    g2d.setColor(Color.BLUE);
    g2d.drawOval(tetrominos.coordonne.x, tetrominos.coordonne.y, 1, 1);
    g2d.setColor(Color.BLACK);
    
    if(tetrominos != null)
    {
        for(int i=0;i<tetrominos.piece.length;i++)
        {
          for(int j=0;j<tetrominos.piece[i].length;j++)
            {
                if(tetrominos.piece[i][j] == 1)
                {
                    g2d.setColor(Color.BLACK);
                    r2d = new Rectangle2D.Double(i*taill_block, j*taill_block, taill_block, taill_block);
                    
                    transform = new AffineTransform();
                    transform.translate(tetrominos.coordonne.x, tetrominos.coordonne.y);
                    transform.rotate(tetrominos.getAngle());
                    rotatedRect = transform.createTransformedShape(r2d);

                    g2d.fill(rotatedRect );
                }
                else
                {
                    g2d.setColor(Color.GREEN);
                    r2d = new Rectangle2D.Double(i*taill_block, j*taill_block, taill_block, taill_block);
                    
                    transform = new AffineTransform();
                    transform.translate(tetrominos.coordonne.x, tetrominos.coordonne.y);
                    transform.rotate(tetrominos.getAngle());
                    rotatedRect = transform.createTransformedShape(r2d);

                    g2d.draw(rotatedRect );
                }
                
            }
        }
    }
    
}
    
    public Color getColor(int temp)
    {
        Color tempColor;
        switch(temp)
        {
            case 1 : tempColor=Color.BLACK;
                break;
            case 2 : tempColor=Color.YELLOW;
                break;
            case 3 : tempColor=Color.CYAN;
                break;
            default:
                     tempColor=Color.WHITE;
                break;
                 
        }
        
        return tempColor;
    }
}