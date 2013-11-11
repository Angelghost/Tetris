import java.awt.event.*;
import javax.swing.*;

public class model {

    
    private int score = 0;

    private Tetrominos tetrominos=new Tetrominos();

    private Tetrominos nextTetrominos;
    // Tetris has a default size of 10x20 blocks
    private int NUM_BLOCKS_X = 12;
    private int NUM_BLOCKS_Y = 22;
    private int taill_block = 20;
    private Timer timer1;
    
    private char[][] matrix = new char[NUM_BLOCKS_Y][NUM_BLOCKS_X];
    
    private view myView;
    
    public model () {
    }

    public model(view myView2){
        
        this.myView=myView2;
        timer1=new Timer(1000,new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Tetrominos temp=tetrominos;
                        temp.coordonne.y+=20;
                        if(temp.deplacementY(matrix)==1){
                            tetrominos=temp;
                        }
                        else
                        {
                            tetrominos.placer(matrix);
                           tetrominos=new Tetrominos(); 
                        }
                        myView.afficher(matrix, tetrominos);
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
    
    public void deplacerTetrominos(int x,int y){//regler les probleme
        int distanceMax = (int)(x+tetrominos.distanceMaxX().x)/taill_block;
        int distanceMin = (int)(x+tetrominos.distanceMinX().x)/taill_block;
        
        if(x>= taill_block*(this.NUM_BLOCKS_X) || y>= taill_block*(this.NUM_BLOCKS_Y) || x < 1  || distanceMin <1)
        {
            return;
        }
        
        int test =1;
        if( distanceMax >= this.NUM_BLOCKS_X ) return;
        if(matrix[(int)(y+tetrominos.distanceMaxX().y)/taill_block][distanceMax] ==1 || matrix[(int)(y+tetrominos.distanceMinX().y)/taill_block][distanceMin] == 1 )
        {
            test=0;
        }
        if(test == 1)
        {
            tetrominos.coordonne.x=x;
        }
        
        myView.afficher(matrix,tetrominos);
    }
    public void rotationTetrominos(int nbr){

        tetrominos.setAngle(tetrominos.getAngle()+Math.toRadians(nbr*10));
        myView.afficher(matrix,tetrominos);
    }
    // Clears the matrix
    private void clearMatrix() {
                for (int row=0;row<matrix.length;row++) {
                        for (int col=0;col<matrix[0].length;col++) {
                                matrix[row][col] = 0;
                                if(col==0 || row ==0 ||col == matrix[0].length-1  || row ==matrix.length -1)
                                    matrix[row][col] = 1;
                        }
                }
        }
}

