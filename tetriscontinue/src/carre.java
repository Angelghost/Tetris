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
    
    private Polygon carre;
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
        carre=new Polygon();
        carre.addPoint(j, i);
        carre.addPoint(j+taille, i);
        carre.addPoint(j+taille, i+taille);
        carre.addPoint(j, i+taille);
        this.couleur=couleur;
        this.plein=plein;
    }
    public carre(carre temp)
    {
        carre=new Polygon();
        for(int i=0;i<temp.getRectangle().npoints;i++)
        {
            carre.addPoint(temp.getRectangle().xpoints[i],temp.getRectangle().ypoints[i]);
        }
        couleur=temp.couleur;
        plein=temp.plein;
    }
    public Polygon getRectangle()
    {     
        return carre;
    }
    public void setCarre(Polygon r)
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
        if(plein == 1) g2d.drawPolygon(carre);
          g2d.setColor(Color.black);
    }
    
    public void carreRotation(double angle,Point centre)
    {
        AffineTransform transform = new AffineTransform();
        transform.setToRotation(angle,centre.x, centre.y);
        
        int[] x = carre.xpoints;
        int[] y = carre.ypoints;
        int[] rx = new int[x.length];
        int[] ry = new int[y.length];

        for(int i=0; i<carre.npoints; i++){
          Point p = new Point(x[i], y[i]);
          transform.transform(p, p);
          rx[i]=p.x;
          ry[i]=p.y;
        }

        carre = new Polygon(rx, ry, carre.npoints);
        

    }
    
    public void changerCoordonne(int i, int j , int taille)
    {
        carre.translate(j,i);
    }
}
