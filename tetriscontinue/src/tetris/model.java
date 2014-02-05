package tetris;

import javax.swing.*;
import java.awt.*;
/**
 * Classe model de notre tétris gérant la partie et stockant 
 * les données du jeu.
 * @author Lucas
 */
public class model {

    
    private int score = 0;
    private Tetrominos tetrominos;
   
    // Tetris has a default size of 10x20 blocks
    private final int NUM_BLOCKS_X = 12;
    private final int NUM_BLOCKS_Y = 22;
    private final carre[][] matrix ;
    public static int taill_block = 20;
    
    private Timer timerAction;
   
    /**
     * Constructeur de base de la classe model
     */
    public model () {
        matrix = new carre[NUM_BLOCKS_Y][NUM_BLOCKS_X];
    }
    
    /**
     * Getter du score
     * @return 
     */
    public int getScore () {
        return score;
    }
    /**
     * Getter du timerAction
     * @return 
     */
    public Timer getTimer () {
        return timerAction;
    }
    /**
     * Setter du timerAction
     * @param timerA 
     */
    public void setTimer(Timer timerA)
    {
        timerAction=timerA;
    }
    /**
     * Getter de la matrix
     * @return 
     */
    public carre[][] getMatrix()
    {
        return this.matrix;
    }
    /**
     * Setter du score
     * @param val 
     */
    public void setScore (int val) {
        this.score = val;
    }
    /**
     * Getter du tetrominos
     * @return 
     */
    public Tetrominos getTetrominos () {
        return tetrominos;
    }
    /**
     * Setter du tetrominos
     * @param val 
     */
    public void setTetrominos (Tetrominos val) {
        this.tetrominos = val;
    }
    /**
     * Fonction start permettant de lancer le jeu.
     */
    public void start()
    {
        tetrominos=tetrominosFactory.creationTetrominos();
        clearMatrix();
    }
    /**
     * Fonction permettant de gérer les déplacements du tétrominos selon 
     * les X (droite et gauche)
     * @param x 
     */
     synchronized void deplacerTetrominosX(int x){
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
     /**
      * Fonction permettant de gérer les déplacements du tétrominos selon 
     * les Y (vers le bas) et de palcer le tétrominos dans le cas ou il touche 
     * le bas.
      * @param y 
      */
   synchronized public void deplacerTetrominosY(int y){

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
   /**
    * Fonction permettant de faire la rotation de notre pièce par rapport au parametre
    * donné à la focntion.
    * @param nbr 
    */
    synchronized public void rotationTetrominos(int nbr){
        Tetrominos temp = new Tetrominos(tetrominos);
        temp.rotation(nbr,Math.toRadians(10));
        if(temp.testDeplacement(matrix)) tetrominos =temp;
    }
   /**
    *  Vide le tableau matrix de la fonction et d'initialiser cela.
    */
    private void clearMatrix() {
                for (int row=0;row<matrix.length;row++) {
                        for (int col=0;col<matrix[0].length;col++) {
                                matrix[row][col] = new carre(row*taill_block,col*taill_block,Color.WHITE,0,new Point(row*taill_block+taill_block/2,col*taill_block+taill_block/2));
                                if(col==0 || row ==0 ||col == matrix[0].length-1  || row ==matrix.length -1)
                                    matrix[row][col] = new carre(row*taill_block,col*taill_block,Color.WHITE,1,new Point(row*taill_block+taill_block/2,col*taill_block+taill_block/2));
                        }
                }
        }
    /**
     * Test si il existe des lignes complètes 
     * et appel UpMatrix pour déplacer dans ce cas la
     */
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
    /**
     * Permet de déplacer ligne supérieur à la ligne suprimé.
     * @param rowI 
     */
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