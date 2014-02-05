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
    /**
     * Constructeur de base pour la classe carre
     */
   public carre()
    {
        
        couleur=null;
        plein=0;
    }
   /**
    * Constructeur de carre avec les paramètres données.
    * @param j
    * @param i
    * @param couleur
    * @param plein
    * @param Center 
    */
    public carre(int j,int i,Color couleur,int plein,Point Center)
    {
        super(i,j,model.taill_block,model.taill_block);
        
        center=new Point2D.Double(Center.x,Center.y);
        this.couleur=couleur;
        this.plein=plein;
    }
    /**
     * Constructeur de recopie
     * @param temp 
     */
    public carre(carre temp)
    {
        super(temp.x,temp.y,temp.height,temp.width);
        center=new Point2D.Double(temp.center.getX(),temp.center.getY());
        couleur=temp.couleur;
        plein=temp.plein;
    }
   /**
    * Getter du center
    * @return 
    */ 
   public Point2D getCenter()
    {
        return this.center;
    }
   /**
    * Getter du Rectangle moyen du carré dans l'état actuel.
    * @return 
    */
    public Rectangle2D getBound()
    {
        return new Rectangle2D.Double(1+center.getY()-model.taill_block/2,1+ center.getX()-model.taill_block/2, model.taill_block-2,model.taill_block-2);
    }
    /**
     * Getter de la couleur du carré.
     * @return 
     */
    public Color getCouleur()
    {
        return couleur;
    }
    /**
     * Getter de Plein
     * @return 
     */
    public int getPlein()
    {
        return plein;
    }
    /**
     * On effectue la rotation du centre du carre.
     * @param angle
     * @param cTetrominos 
     */
   public void rotationCenter(double angle,Point2D cTetrominos)
    {
        AffineTransform transform = new AffineTransform();
       
        transform.rotate(-angle, cTetrominos.getY(), cTetrominos.getX());
        Point2D temp=new Point2D.Double();
        transform.transform(this.center, temp);
        
        this.center=temp;
    }
    
    /**
     * permet de déplacer de translaté les coordonnes 
     * @param i
     * @param j 
     */
    public void changerCoordonne(int i, int j)
    {
        this.translate(j,i);
        this.center= new Point2D.Double(i+center.getX(),j+center.getY());
        
    }
    /**
     * Permet de changer de carré et de mettre l'autre à vide.
     * @param c 
     */
    public void changeCarre(carre c)
    {
        this.couleur =c.couleur;
        this.plein =c.plein;
        c.plein = 0;
    }
}
