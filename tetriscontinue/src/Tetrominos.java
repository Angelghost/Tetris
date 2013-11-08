import java.awt.Point;
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.884CD1FD-4277-7741-4F83-212D64EE915E]
// </editor-fold> 
public class Tetrominos {
    private int taill_block =20;
    private char color;
    private double angle = 0;
    public Point coordonne=new Point(22,22);
    public int[][] piece = new int[4][4];
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8B53D623-9B04-7BC2-403F-E7F66E43B06C]
    // </editor-fold> 
    public Tetrominos () {
        for (int row=0;row<piece.length;row++) {
                        for (int col=0;col<piece[0].length;col++) {
                                piece[row][col] = 0;
                        }
                }
        
        piece[0][1] = 1;
        piece[1][1] = 1;
        piece[2][1] = 1;
        piece[2][0] = 1;
    }
    
    double getAngle()
    {
        return angle;
    }
    
    void setAngle(double angle)
    {
       this.angle=angle;
    }
    
    Point distanceMaxX()
    {
        Point temp = new Point(-999,0);
       for(int i=0;i<piece.length;i++)
        {
          for(int j=0;j<piece[i].length;j++)
            {
                if(piece[i][j] == 1)
                {
                    for(int k=0;k<2;k++)
                    {
                            for(int G=0;G<2;G++)
                        {
                           double hyp=Math.sqrt((i+k)*taill_block*(i+k)*taill_block+(j+G)*taill_block*(j+G)*taill_block);
                           double calc=Math.cos(angle+Math.acos((i+k)*taill_block/hyp))*hyp;
                                if(calc > temp.x)
                                {
                                    temp.x=(int)calc;
                                    temp.y=(int)(Math.sin(angle+Math.acos((i+k)*taill_block/hyp))*hyp);
                                }
                        }
                
                    }
                }
                
            }
        }
       return temp;
    }
  Point distanceMinX()
    {
        Point temp =new Point(999,0);
       for(int i=0;i<piece.length;i++)
        {
          for(int j=0;j<piece[i].length;j++)
            {
                if(piece[i][j] == 1)
                {
                    for(int k=0;k<2;k++)
                    {
                            for(int G=0;G<2;G++)
                        {
                           double hyp=Math.sqrt((i+k)*taill_block*(i+k)*taill_block+(j+G)*taill_block*(j+G)*taill_block);
                           double calc=Math.cos(angle+Math.acos((i+k)*taill_block/hyp))*hyp;
                                if(calc <temp.x)
                                {
                                    temp.x=(int)calc;
                                    temp.y=(int)(Math.sin(angle+Math.acos((i+k)*taill_block/hyp))*hyp);
                                }
                        }
                
                    }
                }
                
            }
        }
       return temp;
    }
  Point distanceMaxY()
    {
        Point temp =new Point(0,-999);
       for(int i=0;i<piece.length;i++)
        {
          for(int j=0;j<piece[i].length;j++)
            {
                if(piece[i][j] == 1)
                {
                    for(int k=0;k<2;k++)
                    {
                            for(int G=0;G<2;G++)
                        {
                           double hyp=Math.sqrt((i+k)*taill_block*(i+k)*taill_block+(j+G)*taill_block*(j+G)*taill_block);
                           double calc=Math.sin(angle+Math.acos((i+k)*taill_block/hyp))*hyp;
                                if(calc >temp.y)
                                {
                                    temp.y=(int)calc;
                                    temp.x=(int)(Math.cos(angle+Math.acos((i+k)*taill_block/hyp))*hyp);
                                }
                        }
                
                    }
                }
                
            }
        }
       return temp;
    }
  
  double distanceMinY()
    {
        double temp =999;
       for(int i=0;i<piece.length;i++)
        {
          for(int j=0;j<piece[i].length;j++)
            {
                if(piece[i][j] == 1)
                {
                    for(int k=0;k<2;k++)
                    {
                            for(int G=0;G<2;G++)
                        {
                           double hyp=Math.sqrt((i+k)*taill_block*(i+k)*taill_block+(j+G)*taill_block*(j+G)*taill_block);
                           double calc=Math.sin(angle+Math.acos((i+k)*taill_block/hyp))*hyp;
                                if(calc <temp)
                                {
                                    temp=calc;
                                }
                        }
                
                    }
                }
                
            }
        }
       return temp;
    }
  int deplacementY(char[][] matrix)
  {
      double depalcement=this.coordonne.y+distanceMaxY().y;
      
      if(matrix[(int)depalcement/taill_block][this.coordonne.x/taill_block] == 1)
        return 0;
      return 2;
  }
    
  void placer(char[][] matrix)
  {
     if(Math.toRadians(-45) < angle && angle < Math.toRadians(45))
     {
         for(int i=0;i<piece.length;i++)
        {
          for(int j=0;j<piece[i].length;j++)
            {
                if(piece[i][j] == 1)
                {
                    matrix[j+coordonne.y/taill_block][i+coordonne.x/taill_block] =1;
                }
            }
        }
     }
     else if(Math.toRadians(45) < angle && angle < Math.toRadians(135))
     {
         
        for(int i=0;i<piece.length;i++)
        {
          for(int j=0;j<piece[i].length;j++)
            {
                if(piece[i][piece[i].length-j-1] == 1)
                {
                    matrix[i+coordonne.y/taill_block][-(piece[i].length-j-1)+coordonne.x/taill_block] =1;
                }
            }
        }

     }
     else if(Math.toRadians(135) < angle && angle < Math.toRadians(225))
     {
         
        for(int i=0;i<piece.length;i++)
        {
          for(int j=0;j<piece[i].length;j++)
            {
                if(piece[piece.length-i-1][piece[i].length-j-1] == 1)
                {
                    matrix[-(piece[i].length-j)+coordonne.y/taill_block][-(piece.length-i)+coordonne.x/taill_block] =1;
                }

            }
        }

     }
     else if(Math.toRadians(225) < angle && angle < Math.toRadians(315))
     {
         
        for(int i=0;i<piece.length;i++)
        {
          for(int j=0;j<piece[i].length;j++)
            {
                if(piece[piece.length-i-1][j] == 1)
                {
                    matrix[-(piece.length-i)+coordonne.y/taill_block][j+coordonne.x/taill_block] =1;
                }

            }
        }

     }
     
      
  }

}

