import java.awt.Color;
import java.awt.Point;
import java.awt.geom.*;
import java.util.ArrayList;

public class Tetrominos {
    private int taill_block =20;
    private char color;
    private double angle = 0;
    public Point coordonne=new Point(22,22);
    public carre[][] listeCarre = new carre[4][4];
    
    
    public Tetrominos () {
        for (int row=0;row<listeCarre.length;row++) {
                        for (int col=0;col<listeCarre[0].length;col++) {
                                listeCarre[row][col] = new carre(coordonne.y+row*taill_block,coordonne.x+col*taill_block,taill_block,Color.WHITE,0);
                        }
                }
        
        listeCarre[0][1]= new carre(coordonne.y+0,coordonne.x+1*taill_block,taill_block,Color.YELLOW,1);
        listeCarre[1][1]= new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,taill_block,Color.YELLOW,1);
        listeCarre[2][1]= new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,taill_block,Color.YELLOW,1);
        listeCarre[2][0]= new carre(coordonne.y+2*taill_block,coordonne.x+0,taill_block,Color.YELLOW,1);

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
    
  boolean testDeplacement(carre[][] matrix)
  {
      for (int row=0;row<matrix.length;row++) {
            for (int col=0;col<matrix[0].length;col++) {
                for(int i=0;i<listeCarre.length;i++)
                    {
                      for(int j=0;j<listeCarre[i].length;j++)
                        {
                            if(matrix[row][col].getRectangle().intersects(listeCarre[i][j].getRectangle()) && matrix[row][col].getPlein()==1 && listeCarre[i][j].getPlein() == 1 ) return false;
                        
                            if(listeCarre[i][j].getRectangle().intersects(new Rectangle2D.Double(12*taill_block,0,800,600))) return false;
                        
                        }
                    }
                    
           } 
      }
      return true;
  }
  void placer(char[][] matrix)
  {
     
     
      
  }

  boolean testRotation(char[][] matrix)
  {
  
     
  
      return true;
  }
  
  void mettreAJour(int x, int y, int taille)
  {
      coordonne.x=x;
       for (int row=0;row<listeCarre.length;row++) {
                        for (int col=0;col<listeCarre[0].length;col++) {
                                listeCarre[row][col].getRectangle().setRect(coordonne.x+row*taille, coordonne.y+col*taille, taille, taille);
                        }
                }
  }
}

