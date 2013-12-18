package tetris;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.Color;

public class Tetrominos {
    
    private double angle = 0;
    private Point coordonne=new Point(20,20);
    private ArrayList<carre> vecCarre= new ArrayList<>();
    
     
    public Tetrominos () {

        
    }
     public Tetrominos (Tetrominos temp) {
        angle=temp.angle;
        coordonne=new Point(temp.coordonne);
        for(carre c :temp.vecCarre)
        {
            this.vecCarre.add(new carre(c));
        }
    }
     
     public ArrayList<carre> getVecCarre()
     {
         
         return vecCarre;
     }
     public Point getCoordonne()
     {
         return coordonne;
     }
     
    double getAngle()
    {
        return angle;
    }
    
    void setAngle(double angle)
    {
       this.angle=angle;
    }
    
    Point getCenter()
    {
        return new Point(coordonne.x+2*model.taill_block,coordonne.y+2*model.taill_block);
    }
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

  public boolean placer(carre[][] matrix,view myView)
  {
      double temp;
      
      temp=angle;
      double angl= angle%(2*Math.PI);
      
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
     System.out.println(temp);
     System.out.print(angle);
     
      this.rotation(1,temp);
      Graphics2D g2d = (Graphics2D)((panel)myView).getPanel().getGraphics();
      for(carre c: vecCarre)
        {
            g2d.setColor(Color.red);
            g2d.draw(c.getBound());
        }
      ListIterator<carre> i = vecCarre.listIterator();
        while (i.hasNext()) {
           carre c = i.next(); 
           Point center = new Point((int)(c.getCenter().getX()/model.taill_block)*model.taill_block,(int)(c.getCenter().getY()/model.taill_block)*model.taill_block);  
           i.set(new carre(center.x,center.y,c.getCouleur(),1,new Point (center.x+model.taill_block/2,center.y+model.taill_block/2)));

        }
     for(carre c: vecCarre)
        {
            g2d.setColor(Color.blue);
            g2d.draw(c.getBound());
        }
      this.mettreAJourY(model.taill_block);
      for(carre c: vecCarre)
        {
            g2d.setColor(Color.green);
            g2d.draw(c.getBound());
        }
      if(!this.testDeplacement(matrix)){
        this.mettreAJourY(-model.taill_block);  
          for(carre c : vecCarre)
          {
            Point center = new Point((int)(c.getCenter().getX()/model.taill_block)*model.taill_block,(int)(c.getCenter().getY()/model.taill_block)*model.taill_block);
            matrix[center.x/model.taill_block][center.y/model.taill_block]= new carre(center.x,center.y,c.getCouleur(),1,new Point (center.x+model.taill_block/2,center.y+model.taill_block/2));
          }

      return true;
      }
      else
      {
        this.mettreAJourY(-model.taill_block);
      }
      return false;
  }

  
   void mettreAJourX(int x)
  {
      int dx=(x-(coordonne.x+2*model.taill_block));
      coordonne.x=x-2*model.taill_block;
      for(carre c: vecCarre){
          c.changerCoordonne(0,dx);   
      }

  }
   void mettreAJourY(int y)
  {
      
      coordonne.y+=y;
      for(carre c: vecCarre){
          c.changerCoordonne(y,0);  
      }
  }

   void rotation(int sens,double angle)
  {
      
       this.angle+=sens*angle;
       
       for(carre c: vecCarre){
          c.rotationCenter(sens*angle, this.getCenter()); 
      }
       
  }
}

