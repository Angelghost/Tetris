/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static tetris.tetrominosFactory.buffSeq;
import static tetris.tetrominosFactory.seqName;
/**
 *
 * @author Angelgosth
 */
public class savFile {
    
    public static String fileName;
    public static FileWriter ecrivain;
    public static String lectName;
    public static BufferedReader buffMov;
    
    
    public savFile()
    {
        
    }
    public  savFile(String fileName)
    {
        this.fileName =fileName;
        try{
            ecrivain =  new  FileWriter(fileName, true);
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    
    public static void setLecFile(String fileName)
    {
        lectName =fileName;
        try{
             buffMov = new BufferedReader(new FileReader(lectName));
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    
    public static void addRotation(int sens)
    {
          try{
            BufferedWriter output = new BufferedWriter(ecrivain);
            output.write("Rotation/" + sens+ "\r\n");

             output.flush();

           
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }

    }
    
    public static void addMove(int x,int y)
    {
            try{
            BufferedWriter output = new BufferedWriter(ecrivain);
            output.write("translation/" + x+ "/" +y +"\r\n");

             output.flush();

           
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    public static void addDesc(int x,int y)
    {
            try{
            BufferedWriter output = new BufferedWriter(ecrivain);
            output.write("incrementation/" + x+ "/" +y +"\r\n");

             output.flush();

           
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    public static String getNextMove() // renvoie si rotation ou deplacement voir si besoin de creation de classe pour avoir toute les donnée
    {
        try{
            String str = null;
            if((str =  buffMov.readLine()) != null){
                    return str;
                }
            
             }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        } 
        return null;
    }
}
