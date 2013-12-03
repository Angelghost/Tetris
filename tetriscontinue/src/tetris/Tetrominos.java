package tetris;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.awt.*;

public class Tetrominos {
    private int taill_block =20;
    private char color;
    private double angle = 0;
    public Point coordonne=new Point(20,20);
    public ArrayList<carre> vecCarre= new ArrayList<carre>();
    
     
    public Tetrominos () {

        this.tetrominosFactory();
    }
     public Tetrominos (Tetrominos temp) {
        angle=temp.angle;
        coordonne=new Point(temp.coordonne);
        for(carre c :temp.vecCarre)
        {
            this.vecCarre.add(new carre(c));
        }
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
        return new Point(coordonne.x+2*taill_block,coordonne.y+2*taill_block);
    }
  synchronized boolean testDeplacement(carre[][] matrix)
  {
      for (int row=0;row<matrix.length;row++) {
            for (int col=0;col<matrix[0].length;col++) {
                for(carre c: vecCarre)
                {
                    if(matrix[row][col].getBound().intersects(c.getBound()) && matrix[row][col].getPlein()==1 ) return false;
                        
                    // if(c.getBound().intersects(new Rectangle2D.Double(13*taill_block,0,800,600))) return false;
                        
                }

           } 
      }
      return true;
  }
  void tetrominosFactory() // peut etre mettre le random ailleur
  {
      Random generator = new Random(); 
      int random =generator.nextInt(6)+ 1;
      System.out.print(random);
      Color tempColor;
      switch(random)
      {
          case 1 :
            tempColor=Color.BLUE;
            vecCarre.add(new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));         
            vecCarre.add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+3*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+3*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));

              break;
         case 2 :
            tempColor=Color.MAGENTA;
            vecCarre.add(new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
            
                 break;
          case 3 :
            tempColor=Color.GREEN;
            vecCarre.add(new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+2*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
            
            
              break;
          case 4 :
            tempColor=Color.LIGHT_GRAY;
            vecCarre.add(new carre(coordonne.y+0*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            
              break;
            case 5 :
            tempColor=Color.YELLOW;
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+2*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+2*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+2*taill_block,coordonne.x+2*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+2*taill_block+taill_block/2)));
            
            break; 
          default:
            tempColor=Color.RED;
            vecCarre.add(new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
            vecCarre.add(new carre(coordonne.y+2*taill_block,coordonne.x+0,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
            
              break;
      
                  
      }
      
  }
  synchronized public boolean placer(carre[][] matrix,view myView)
  {
      double temp;
      
      temp=angle;
      double angl= angle%(2*Math.PI);
      
      if(angl<0){
          if(angl<-7*Math.PI/4 || angl >= -Math.PI/4)
        {
            temp=temp-0;
            System.out.println("angle 0");
        }
        else if(angl<-Math.PI/4 && angl>=- 3*Math.PI/4)
        {
            temp=-temp-Math.PI/2;
               System.out.println("angle -Pi/2");

        }
        else if(angl>=-5*Math.PI/4 && angl< -3*Math.PI/4)
        {
            temp=-temp-Math.PI;
                System.out.println("angle -Pi");

        }
        else if(angl>= -7*Math.PI/4 && angl< -5*Math.PI/4)
        {
            temp=-temp-3*Math.PI/2;
                System.out.println("angle -3Pi/2");

        }
        else
        {
            System.out.println(angl);
            System.out.println("caca1");
            System.out.println(angle);
        }
      }
      else{
        if(angl>7*Math.PI/4 || angl <= Math.PI/4)
        {
            temp=temp-0;
            System.out.println("angle 0");
        }
        else if(angl>Math.PI/4 && angl<= 3*Math.PI/4)
        {
            temp=-temp+Math.PI/2;
               System.out.println("angle Pi/2");

        }
        else if(angl<=5*Math.PI/4 && angl> 3*Math.PI/4)
        {
            temp=-temp+Math.PI;
                System.out.println("angle Pi");

        }
        else if(angl<=7*Math.PI/4 && angl> 5*Math.PI/4)
        {
            temp=-temp+3*Math.PI/2;
                System.out.println("angle 3Pi/2");

        }
        else
        {
            System.out.println(angl);
            System.out.println("caca2");
             System.out.println(angle);
        }
      }
     
      this.rotation(1,temp);
      
      /*for(carre c : vecCarre)
          {
                   
      
              Point center = new Point((int)(c.getCenter().getX()/taill_block)*taill_block,(int)(c.getCenter().getY()/taill_block)*taill_block);
              
             c=new carre(center.y-taill_block/2,center.x-taill_block/2,taill_block,c.getCouleur(),1,new Point (center.x,center.y));
            } */
      ListIterator<carre> i = vecCarre.listIterator();
            while (i.hasNext()) {
               carre c = i.next(); 
               Point center = new Point((int)(c.getCenter().getX()/taill_block)*taill_block,(int)(c.getCenter().getY()/taill_block)*taill_block);
               
               i.set(new carre(center.x,center.y,taill_block,c.getCouleur(),1,new Point (center.x+taill_block/2,center.y+taill_block/2)));
           
            }
     
      this.mettreAJourY(0, taill_block, taill_block);
        /*for(carre c : vecCarre){
            Graphics2D g2d =(Graphics2D)((panel)myView).getPanel().getGraphics();
              g2d.scale(2, 2);
              g2d.setColor(Color.BLUE);
               g2d.draw(c.getBound());
              g2d.setColor(Color.yellow);
          }*/
      if(!this.testDeplacement(matrix)){
        this.mettreAJourY(0,-taill_block, taill_block);  
          for(carre c : vecCarre)
          {
                        
             
              //Graphics2D g2d =(Graphics2D)((panel)myView).getPanel().getGraphics();
              //g2d.scale(2, 2);
            Point center = new Point((int)(c.getCenter().getX()/taill_block)*taill_block,(int)(c.getCenter().getY()/taill_block)*taill_block);
           // g2d.setColor(Color.yellow);
           // g2d.drawOval(center.y, center.x, 2, 2);
            
          matrix[center.x/taill_block][center.y/taill_block]= new carre(center.x,center.y,(int)taill_block,c.getCouleur(),1,new Point (center.x+taill_block/2,center.y+taill_block/2));

          }

      return true;
      }
     // this.mettreAJourY(0,-taill_block, taill_block);
      return false;
  }

  
  synchronized void mettreAJour(int x, int y, int taille)
  {
       int dx=(x-(coordonne.x+2*taill_block));
      coordonne.x=x-2*taill_block;
      for(carre c: vecCarre){
          c.changerCoordonne(0, dx, taille);   
      }

  }
  synchronized void mettreAJourY(int x, int y, int taille)
  {
      
      coordonne.y+=y;
      for(carre c: vecCarre){
          c.changerCoordonne(y, 0, taille);  
      }
  }

  
  
  
  synchronized void rotation(int sens,double angle)
  {
      
       this.angle+=sens*angle;
       
       for(carre c: vecCarre){
          c.rotationCenter(sens*angle, this.getCenter()); 
      }
       
  }
}

