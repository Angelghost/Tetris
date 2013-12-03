package tetris;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.*;
public class model {

    
    private int score = 0;
    private option myOption;
    private Tetrominos tetrominos=new Tetrominos();

    private Tetrominos nextTetrominos;
    // Tetris has a default size of 10x20 blocks
    private int NUM_BLOCKS_X = 12;
    private int NUM_BLOCKS_Y = 22;
    private int taill_block = 20;
    private Timer timer1;
    private carre[][] matrix = new carre[NUM_BLOCKS_Y][NUM_BLOCKS_X];
    
    private view myView;
    
    public model () {
    }
    
    public model(view myView2){
        
        this.myView=myView2;
        
        timer1=new Timer(500,new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        deplacerTetrominosY(0,taill_block);
                    }
                });
        timer1.start();
        
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
    public view getView()
    {
        return myView;
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
        clearMatrix();
        myView.afficher(matrix,tetrominos);
        
    }
    
     synchronized void deplacerTetrominos(int x,int y){//regler les probleme
        if(x > this.NUM_BLOCKS_X*taill_block) return;
        Tetrominos temp = new Tetrominos(tetrominos);
        temp.mettreAJour(x,y,taill_block);
        if(temp.testDeplacement(matrix)) tetrominos=temp;
        myView.afficher(matrix,tetrominos);
 
    }
   synchronized public void deplacerTetrominosY(int x,int y){//regler les probleme

        Tetrominos temp = new Tetrominos(tetrominos);
        temp.mettreAJourY(x,y,taill_block);
        if(temp.testDeplacement(matrix)) tetrominos=temp;
        else
        {
            if(tetrominos.placer(matrix,myView)){
            testFinLigne();    
            tetrominos=new Tetrominos();
            myView.afficher(matrix,temp);
            }
            
        }
        myView.afficher(matrix,tetrominos);
        
 
    }
    synchronized public void rotationTetrominos(int nbr){
        Tetrominos temp = new Tetrominos(tetrominos);
        temp.rotation(nbr,Math.toRadians(10));
        if(temp.testDeplacement(matrix)) tetrominos =temp;
        myView.afficher(matrix,tetrominos);
    }
    // Clears the matrix
    private void clearMatrix() {
                for (int row=0;row<matrix.length;row++) {
                        for (int col=0;col<matrix[0].length;col++) {
                                matrix[row][col] = new carre(row*taill_block,col*taill_block,taill_block,Color.WHITE,0,new Point(row*taill_block+taill_block/2,col*taill_block+taill_block/2));
                                if(col==0 || row ==0 ||col == matrix[0].length-1  || row ==matrix.length -1)
                                    matrix[row][col] = new carre(row*taill_block,col*taill_block,taill_block,Color.BLACK,1,new Point(row*taill_block+taill_block/2,col*taill_block+taill_block/2));
                        }
                }
        }
    
    public void testFinLigne(){
        int continuer =1;
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
                        for (int col=matrix[0].length-1;col>-1;col--) {
                            matrix[row][col]=matrix[row-1][col];
                        }
            }
        for (int col=matrix[0].length-2;col>0;col--) {
                            matrix[0][col]=new carre(1*taill_block,col*taill_block,taill_block,Color.BLACK,1,new Point(1*taill_block+taill_block/2,col*taill_block+taill_block/2));
                        }
    }
}
