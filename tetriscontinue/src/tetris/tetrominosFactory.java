/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * classe avec les fonctions de création de tétrominos et de sauvegarde de séquence
 * @author Akmale
 */
public class tetrominosFactory {
    
    public static String fileName;
    public static FileWriter ecrivain;
    public static String seqName;
    public static BufferedReader buffSeq;
    private static int modeCreation=1;
    
    /**
     * setter du mode de creation
     * @param mode 
     */
    public static void setModCreation(int mode)
    {
        modeCreation=mode;
    }
   /**
    * Créer un tétrominos par rapport à son mode de création.
    * @return 
    */
    public static Tetrominos creationTetrominos()
    {
        switch(modeCreation)
        {
            case 1:return randTetrominos();
            case 2:return seqTetrominos();
        }   
        
        return null;
    }
    /**
     * Setter pour le nom du fichier de sauvegarde du fichier de séquence.
     * @param name 
     */
    public static void setNameFileSav(String name)
    {
        fileName=name;
        try{
            ecrivain =  new  FileWriter(fileName, true);
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    
    /** Setter pour nom fichier de lecture pour rejouer une partie.
     * @param name nom du fichier
     */
    public static void setNameFileSeq(String name)
    {
        seqName=name;
        try{
             buffSeq = new BufferedReader(new FileReader(seqName));
        }
        catch(FileNotFoundException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    
    /** 
     *  Crée un tétrominos de facon aléatoire.
     * @return 
     */
    public static Tetrominos randTetrominos()
    {      
        Random generator = new Random(); 
        int random =generator.nextInt(6)+ 1;
        savTetrominos(random);
        return tetrominosFactory.setTetrominos(random);
    }
    /**
     *  sauvegarde le type de tétrominos passé en paramètre
     *  dans le fichier pour pouvoir le relire 
     * @param type 
     */

    public static void savTetrominos(int type)
    {
        try{
            BufferedWriter output = new BufferedWriter(ecrivain);
            output.write(type+"\r\n");
            output.flush();
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        } 
    }
    /**
     * renvoie le prochain tétrominos de la seq
     * @return Tétrominos
     */
    public static Tetrominos seqTetrominos()
    {      
        try{
            String str ;
            if((str =  buffSeq.readLine()) != null){
                    return tetrominosFactory.setTetrominos(Integer.parseInt(str));
                }
             }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        } 
        return null;
    }
    /**
     * créer un tétrominos par rapport au type envoyée et le renvoie
     * @param type
     * @return le tétrominos
     */
    public static Tetrominos setTetrominos(int type)
    {
        Tetrominos temp = new Tetrominos();
        Color tempColor;
        Point coordonne =temp.getCoordonne();
        int taill_block=model.taill_block;
        switch(type)
        {
            case 1 :
              tempColor=Color.BLUE;
              temp.getVecCarre().add(new carre(coordonne.y+0,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));         
              temp.getVecCarre().add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+3*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+3*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));

                break;
           case 2 :
              tempColor=Color.MAGENTA;
              temp.getVecCarre().add(new carre(coordonne.y+0,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));

                   break;
            case 3 :
              tempColor=Color.GREEN;
              temp.getVecCarre().add(new carre(coordonne.y+0,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+2*taill_block,coordonne.x+0*taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));


                break;
            case 4 :
              tempColor=Color.LIGHT_GRAY;
              temp.getVecCarre().add(new carre(coordonne.y+0*taill_block,coordonne.x+0*taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+0*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));

                break;
              case 5 :
              tempColor=Color.YELLOW;
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+2*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+2*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+2*taill_block,coordonne.x+2*taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+2*taill_block+taill_block/2)));

              break; 
            default:
              tempColor=Color.RED;
              temp.getVecCarre().add(new carre(coordonne.y+0,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+0*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+1*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+1*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+2*taill_block,coordonne.x+1*taill_block,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+1*taill_block+taill_block/2)));
              temp.getVecCarre().add(new carre(coordonne.y+2*taill_block,coordonne.x+0,tempColor,1,new Point(coordonne.x+2*taill_block+taill_block/2,coordonne.y+0*taill_block+taill_block/2)));
                break;


        }
        
        
        return temp;
        
    }
}
