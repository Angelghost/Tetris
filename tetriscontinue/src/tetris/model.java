package tetris;

import javax.swing.*;
import java.awt.*;
public class model {

    
    private int score = 0;
    private Tetrominos tetrominos;

    private Tetrominos nextTetrominos;
    // Tetris has a default size of 10x20 blocks
    private final int NUM_BLOCKS_X = 12;
    private final int NUM_BLOCKS_Y = 22;
    public static int taill_block = 20;
    public Timer timer1;
    private final carre[][] matrix = new carre[NUM_BLOCKS_Y][NUM_BLOCKS_X];
    public model () {
    }
    
  public Tetrominos getNextTetrominos () {
        return nextTetrominos;
    }

    public void setNextTetrominos (Tetrominos val) {
        this.nextTetrominos = val;
    }

    public int getScore () {
        return score;
    }
    public Timer getTimer () {
        return timer1;
    }
    public carre[][] getMatrix()
    {
        return this.matrix;
    }
    public void setScore (int val) {
        this.score = val;
    }

    public Tetrominos getTetrominos () {
        return tetrominos;
    }

    public void setTetrominos (Tetrominos val) {
        this.tetrominos = val;
    }
    
    public void start()
    {
        tetrominos=tetrominosFactory.creationTetrominos();
        clearMatrix();
    }
    
     synchronized void deplacerTetrominosX(int x){//regler les probleme
        if(x > this.NUM_BLOCKS_X*taill_block) return;
        Tetrominos temp = new Tetrominos(tetrominos);
        int diffBut = (int)temp.getCoordonne().getX();
        
        int sens  = x - diffBut;
        while(diffBut !=  x)
        {
            if(sens > 0) {
                diffBut++;
                temp.mettreAJourX(1);
            }
            else {
                diffBut--;
                 temp.mettreAJourX(-1);
            }
            temp.getCoordonne().x=diffBut;
            
            if(temp.testDeplacement(matrix)) tetrominos=temp;
            else break;
        }
    }
   synchronized public void deplacerTetrominosY(int y){//regler les probleme

        Tetrominos temp = new Tetrominos(tetrominos);
        temp.mettreAJourY(y);
        if(temp.testDeplacement(matrix)) tetrominos=temp;
        else
        {
            if(tetrominos.placer(matrix)){
            testFinLigne();    
            tetrominos=tetrominosFactory.creationTetrominos();
            }
            
        }
        
 
    }
    synchronized public void rotationTetrominos(int nbr){
        Tetrominos temp = new Tetrominos(tetrominos);
        temp.rotation(nbr,Math.toRadians(10));
        if(temp.testDeplacement(matrix)) tetrominos =temp;
    }
    // Clears the matrix
    private void clearMatrix() {
                for (int row=0;row<matrix.length;row++) {
                        for (int col=0;col<matrix[0].length;col++) {
                                matrix[row][col] = new carre(row*taill_block,col*taill_block,Color.WHITE,0,new Point(row*taill_block+taill_block/2,col*taill_block+taill_block/2));
                                if(col==0 || row ==0 ||col == matrix[0].length-1  || row ==matrix.length -1)
                                    matrix[row][col] = new carre(row*taill_block,col*taill_block,Color.WHITE,1,new Point(row*taill_block+taill_block/2,col*taill_block+taill_block/2));
                        }
                }
        }
    
    public void testFinLigne(){
        int continuer ;
        for (int row=matrix.length-2;row>0;row--) {
            continuer =1;            
            for (int col=matrix[0].length-1;col>-1;col--) {
                    if(matrix[row][col].getPlein() == 0)
                        continuer =0 ;
                }
                if(continuer == 1)
                {
                    UpMatrix(row);
                    row++;
                }
           }
    }
    
    public void UpMatrix(int rowI)
    {
        //changer laffectation des matrix
        for (int row=rowI;row>1;row--) {
                        for (int col=matrix[0].length-2;col>0;col--) {
                            matrix[row][col].changeCarre(matrix[row-1][col]);
                        }
            }

    }
}