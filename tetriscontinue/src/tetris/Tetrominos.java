package tetris;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.util.Random;

public class Tetrominos {
    private int taill_block =20;
    private char color;
    private double angle = 0;
    public Point coordonne=new Point(20,20);
    public carre[][] listeCarre = new carre[4][4];
    
     
    public Tetrominos () {
        for (int row=0;row<listeCarre.length;row++) {
                        for (int col=0;col<listeCarre[0].length;col++) {
                                listeCarre[row][col] = new carre(coordonne.y+row*taill_block,coordonne.x+col*taill_block,taill_block,Color.WHITE,0,new Point(coordonne.x+row*taill_block+taill_block/2,coordonne.y+col*taill_block+taill_block/2));
                        }
                }
        
        this.tetrominosFactory();
    }
     public Tetrominos (Tetrominos temp) {
        angle=temp.angle;
        coordonne=new Point(temp.coordonne);
        for (int row=0;row<listeCarre.length;row++) {
                for (int col=0;col<listeCarre[0].length;col++) {
                        listeCarre[row][col] =new carre(temp.listeCarre[row][col]);
                }
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
  boolean testDeplacement(carre[][] matrix)
  {
      for (int row=0;row<matrix.length;row++) {
            for (int col=0;col<matrix[0].length;col++) {
                for(int i=0;i<listeCarre.length;i++)
                    {
                      for(int j=0;j<listeCarre[i].length;j++)
                        {
                            if(matrix[row][col].getBound().intersects(listeCarre[i][j].getBound()) && matrix[row][col].getPlein()==1 && listeCarre[i][j].getPlein() == 1 ) return false;
                        
                            if(listeCarre[i][j].getBound().intersects(new Rectangle2D.Double(13*taill_block,0,800,600))) return false;
                        
                        }
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
            listeCarre[0][1]= new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[1][1]= new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[2][1]= new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[3][1]= new carre(coordonne.y+3*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+3*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));

              break;
         case 2 :
            tempColor=Color.MAGENTA;
            listeCarre[0][1]= new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[1][1]= new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[2][1]= new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[1][0]= new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2));

              break;
          case 3 :
            tempColor=Color.GREEN;
            listeCarre[0][1]= new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[1][1]= new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[2][0]= new carre(coordonne.y+2*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2));
            listeCarre[1][0]= new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2));

              break;
          case 4 :
            tempColor=Color.LIGHT_GRAY;
            listeCarre[0][0]= new carre(coordonne.y+0*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2));
            listeCarre[1][0]= new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2));
            listeCarre[2][1]= new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[1][1]= new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));

              break;
            case 5 :
            tempColor=Color.YELLOW;
            listeCarre[1][1]= new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[2][1]= new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[1][2]= new carre(coordonne.y+1*taill_block,coordonne.x+2*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+2*taill_block+taill_block/2));
            listeCarre[2][2]= new carre(coordonne.y+2*taill_block,coordonne.x+2*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+2*taill_block+taill_block/2));

              break; 
          default:
            tempColor=Color.RED;
            listeCarre[0][1]= new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[1][1]= new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[2][1]= new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2));
            listeCarre[2][0]= new carre(coordonne.y+2*taill_block,coordonne.x+0,taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2));

              break;
      
                  
      }
      
  }
  void placer(carre[][] matrix)
  {
      double temp;
      
      temp=angle;
      double angl= angle%(2*Math.PI);
      
      if(angl<0){
          if(angl<-7*Math.PI/4 && angl >= -Math.PI/4)
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
      }
      else{
        if(angl>7*Math.PI/4 && angl <= Math.PI/4)
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
      }
     
      this.rotation(1,temp);
      for (int row=0;row<listeCarre.length;row++) {
                        for (int col=0;col<listeCarre[0].length;col++) {
                            if(listeCarre[row][col].getPlein() == 1)
                            {
                                Point center = new Point((int)(listeCarre[row][col].getCenter().getX()/taill_block)*taill_block,(int)(listeCarre[row][col].getCenter().getY()/taill_block)*taill_block);
                                        
                                        
                                matrix[center.x/taill_block][center.y/taill_block]= new carre(center.x,center.y,(int)taill_block,listeCarre[row][col].getCouleur(),1,new Point (center.x+taill_block/2,center.y+taill_block/2));
                            }
                                
                        }
                }
     
      
  }

  
  void mettreAJour(int x, int y, int taille)
  {
       int dx=(x-(coordonne.x+2*taill_block));
      coordonne.x=x-2*taill_block;
       for (int row=0;row<listeCarre.length;row++) {
                        for (int col=0;col<listeCarre[0].length;col++) {
                            listeCarre[row][col].changerCoordonne(0, dx, taille);
                        }
                }

  }
  void mettreAJourY(int x, int y, int taille)
  {
      
      coordonne.y+=y;
       for (int row=0;row<listeCarre.length;row++) {
                        for (int col=0;col<listeCarre[0].length;col++) {
                            listeCarre[row][col].changerCoordonne(y, 0, taille);
                        }
                }

  }
  
  
  void rotation(int sens,double angle)
  {
      
       this.angle+=sens*angle;
       for(int i=0;i<listeCarre.length ;i++)
       {
           for(int j =0 ; j<listeCarre[i].length  ; j++)
           {
               if(listeCarre[i][j].getPlein() ==1)
               listeCarre[i][j].rotationCenter(sens*angle, this.getCenter());
           }
       }
       
  }
}

