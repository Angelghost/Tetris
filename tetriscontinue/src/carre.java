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
public class carre {
    
    private Shape carre;
    private Color couleur;
    private int plein;
    
   public carre()
    {
        carre=null;
        couleur=null;
        plein=0;
    }
    public carre(int i,int j,int taille,Color couleur,int plein)
    {
        carre=new Rectangle2D.Double(j,i,taille,taille);
        this.couleur=couleur;
        this.plein=plein;
    }
    public carre(carre temp)
    {
        carre=new Rectangle2D.Double(temp.getRectangle().getBounds2D().getX(),temp.getRectangle().getBounds2D().getY(),temp.getRectangle().getBounds2D().getHeight(),temp.getRectangle().getBounds2D().getWidth());
        couleur=temp.couleur;
        plein=temp.plein;
    }
    public Shape getRectangle()
    {     
        return carre;
    }
    public void setCarre(Rectangle2D r)
    {
        carre=r;
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
        if(plein == 1) g2d.draw(carre);
          g2d.setColor(Color.black);
    }
    
    public void carreRotation(double angle,Point centre)
    {
        AffineTransform transform = new AffineTransform();
        transform.setToRotation(angle,centre.x, centre.y);
        carre=transform.createTransformedShape(carre);

    }
}
