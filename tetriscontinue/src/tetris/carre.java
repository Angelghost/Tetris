package tetris;

import java.awt.*;
import java.awt.geom.*;

/**
 * Class carre qui est hériditaire de la classe Rectangle de la bibliothéque awt.
 * @author Angelgosth
 */
public class carre extends Rectangle{
    
    private Color couleur;
    private Point2D center;
    private int plein;
    
   public carre()
    {
        
        couleur=null;
        plein=0;
    }
    public carre(int j,int i,Color couleur,int plein,Point Center)
    {
        super(i,j,model.taill_block,model.taill_block);
        
        center=new Point2D.Double(Center.x,Center.y);
        this.couleur=couleur;
        this.plein=plein;
    }
    public carre(carre temp)
    {
        super(temp.x,temp.y,temp.height,temp.width);
        center=new Point2D.Double(temp.center.getX(),temp.center.getY());
        couleur=temp.couleur;
        plein=temp.plein;
    }
    
   public Point2D getCenter()
    {
        return this.center;
    }
    public Rectangle2D getBound()
    {
        return new Rectangle2D.Double(1+center.getY()-model.taill_block/2,1+ center.getX()-model.taill_block/2, model.taill_block-2,model.taill_block-2);
    }
    public Color getCouleur()
    {
        return couleur;
    }
    public int getPlein()
    {
        return plein;
    }
    
   public void rotationCenter(double angle,Point2D cTetrominos)
    {
        AffineTransform transform = new AffineTransform();
       
        transform.rotate(-angle, cTetrominos.getY(), cTetrominos.getX());
        Point2D temp=new Point2D.Double();
        transform.transform(this.center, temp);
        
        this.center=temp;
    }
    
    
    public void changerCoordonne(int i, int j)
    {
        this.translate(j,i);
        this.center= new Point2D.Double(i+center.getX(),j+center.getY());
        
    }
    
    public void changeCarre(carre c)
    {
        this.couleur =c.couleur;
        this.plein =c.plein;
        c.plein = 0;
    }
}
