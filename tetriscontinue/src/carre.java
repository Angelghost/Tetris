/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akmale
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author Akmale
 */
public class carre extends Rectangle{
    
    private Color couleur;
    private Point2D center;
    private int plein;
    private int taill_block;
   public carre()
    {
        
        couleur=null;
        plein=0;
    }
    public carre(int j,int i,int taille,Color couleur,int plein,Point Center)
    {
        super(i,j,taille,taille);
        
        center=new Point2D.Double(Center.x,Center.y);
        this.couleur=couleur;
        this.plein=plein;
        taill_block=taille;
    }
    public carre(carre temp)
    {
        super(temp.x,temp.y,temp.height,temp.width);
        center=new Point2D.Double(temp.center.getX(),temp.center.getY());
        couleur=temp.couleur;
        plein=temp.plein;
        taill_block=temp.taill_block;
    }
    
    public Point2D getCenter()
    {
        return this.center;
    }
    public Rectangle2D getBound()
    {
        return new Rectangle2D.Double(2+center.getY()-taill_block/2,2+ center.getX()-taill_block/2, taill_block-4,taill_block-4);
    }
    public Color getCouleur()
    {
        return couleur;
    }
    public int getPlein()
    {
        return plein;
    }
    public void paintCarre(Graphics2D g2d)
    {
        g2d.setColor(couleur);
        if(plein == 1){
            g2d.draw(this);
            g2d.setColor(Color.black);
            //g2d.draw(this);
        }
          g2d.setColor(Color.black);
    }
    public void rotationCenter(double angle,Point2D cTetrominos)
    {
        AffineTransform transform = new AffineTransform();
       
        transform.rotate(-angle, cTetrominos.getY(), cTetrominos.getX());
        Point2D temp=new Point2D.Double();
        transform.transform(this.center, temp);
        
        this.center=temp;
    }
    
    
    public void changerCoordonne(int i, int j , int taille)
    {
        this.translate(j,i);
        this.center= new Point2D.Double(i+center.getX(),j+center.getY());
        
    }
}
