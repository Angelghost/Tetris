package tetris;

import java.awt.Point;
import java.util.ArrayList;
import java.util.ListIterator;

public class Tetrominos {
    
    private double angle = 0;
    private Point coordonne;
    private final ArrayList<carre>  vecCarre;
    
     
    public Tetrominos () {
        vecCarre= new ArrayList();
        coordonne=new Point(20,20);
    }
    /**
     * Fonction de recopie du tétrominos
     * @param temp 
     */
     public Tetrominos (Tetrominos temp) {
        vecCarre= new ArrayList();
        angle=temp.angle;
        coordonne=new Point(temp.coordonne);
        for(carre c :temp.vecCarre)
        {
            this.vecCarre.add(new carre(c));
        }
    }
     /**
      * Getter de la liste des carres du tétrominos
      * @return 
      */
     public ArrayList<carre> getVecCarre()
     {
         
         return vecCarre;
     }
     /**
      * Getter du coordonnee du Tetrominos
      * @return 
      */
     public Point getCoordonne()
     {
         return coordonne;
     }
     /**
      * Getter de l'angle du tetrominos
      * @return 
      */
    double getAngle()
    {
        return angle;
    }
    /**
     * Setter du Tétrominos
     * @param angle 
     */
    void setAngle(double angle)
    {
       this.angle=angle;
    }
    /**
     * Getter du centre du tetrominos
     * @return 
     */
    Point getCenter()
    {
        return new Point(coordonne.x+2*model.taill_block,coordonne.y+2*model.taill_block);
    }
   /**
    * Fonction qui test si on peut placer le tétrominos sur le plateau pacer en paramétre.
    * @param matrix
    * @return 
    */ 
  boolean testDeplacement(carre[][] matrix)
  {
        for (carre[] matrix1 : matrix) {
            for (int col = 0; col<matrix[0].length; col++) {
                for (carre c : vecCarre) {
                    if (matrix1[col].getBound().intersects(c.getBound()) && matrix1[col].getPlein() == 1) {
                        return false;                             
                    }
                }
            }
        }
      return true;
  }
    /**
     * Fonction qui replace droit le Tétrominos et qui le rajoute au plateau.
     * @param matrix
     * @return 
     */
  public boolean placer(carre[][] matrix)
  {
      double temp;
      
      temp=angle;
      double angl= angle%(2*Math.PI);
      //On cherche l'angle de rotation normal du Tétrominos
      if(angl<0){
          if(angl<-7*Math.PI/4 || angl >= -Math.PI/4)
        {
            temp=-temp;
        }
        else if(angl<-Math.PI/4 && angl>=- 3*Math.PI/4)
        {
            temp=-temp-Math.PI/2;
       }
        else if(angl>=-5*Math.PI/4 && angl< -3*Math.PI/4)
        {
            temp=-temp-Math.PI;
        }
        else if(angl>= -7*Math.PI/4 && angl< -5*Math.PI/4)
        {
            temp=-temp-3*Math.PI/2;
       }
       }
      else{
        if(angl>7*Math.PI/4 || angl <= Math.PI/4)
        {
            temp=-temp;
        }
        else if(angl>Math.PI/4 && angl<= 3*Math.PI/4)
        {
            temp=-temp+Math.PI/2;
        }
        else if(angl<=5*Math.PI/4 && angl> 3*Math.PI/4)
        {
            temp=-temp+Math.PI;
        }
        else if(angl<=7*Math.PI/4 && angl> 5*Math.PI/4)
        {
            temp=-temp+3*Math.PI/2;
        }
      }
     
      this.rotation(1,temp);
      ListIterator<carre> i = vecCarre.listIterator();
        while (i.hasNext()) {
           carre c = i.next(); 
           Point center = new Point((int)(c.getCenter().getX()/model.taill_block)*model.taill_block,(int)(c.getCenter().getY()/model.taill_block)*model.taill_block);  
           i.set(new carre(center.x,center.y,c.getCouleur(),1,new Point (center.x+model.taill_block/2,center.y+model.taill_block/2)));
        }
        
      this.mettreAJourY(3);
      // On retest si on peut toujours ne pas déplacer le Tétrominos dans le cas contraire 
      // on rend la main à l'utilisateur.
      if(!this.testDeplacement(matrix)){
        this.mettreAJourY(-3);  
          for(carre c : vecCarre)
          {
            Point center = new Point((int)(c.getCenter().getX()/model.taill_block)*model.taill_block,(int)(c.getCenter().getY()/model.taill_block)*model.taill_block);
            matrix[center.x/model.taill_block][center.y/model.taill_block]= new carre(center.x,center.y,c.getCouleur(),1,new Point (center.x+model.taill_block/2,center.y+model.taill_block/2));
          }
         return true;
      }
      else
      {
            this.mettreAJourY(-3);
      }
      return false;
  }

  /**
   * Deplacement du tétrominos celon la coordonnée X
   * @param x 
   */
   void mettreAJourX(int x)
  {
      
      for(carre c: vecCarre){
          c.changerCoordonne(0,x);   
      }

  }
   /**
    * Deplacement du tétrominos celon la coordonnée Y
    * @param y 
    */
   void mettreAJourY(int y)
  {
      
      coordonne.y+=y;
      for(carre c: vecCarre){
          c.changerCoordonne(y,0);  
      }
  }
   /**
    * On effectue la rotation du tétrominos dans le sens donnée
    * et l'angle voulue.
    * @param sens
    * @param angle 
    */
   void rotation(int sens,double angle)
  {
      
       this.angle+=sens*angle;
       
       for(carre c: vecCarre){
          c.rotationCenter(sens*angle, this.getCenter()); 
      }
       
  }
}

