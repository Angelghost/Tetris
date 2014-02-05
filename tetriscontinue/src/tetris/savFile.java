/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Classe savFile permettant de gérer la liaison entre les fichiers
 * de sauvegarde pour la lecture et l'écriture
 * @author Angelgosth
 */
public class savFile {
    
    public static String fileName;
    public static FileWriter ecrivain;
    public static String lectName;
    public static BufferedReader buffMov;
    public static long firstTime;
    
    /**
     * Constructeur par défaut de la classe savFile
     */
    public savFile()
    {
        
    }
    /**
     * Constructeur en mettant la valeur fileName
     * @param fileName 
     */
    public  savFile(String fileName)
    {
        firstTime=System.currentTimeMillis();
        savFile.fileName =fileName;
        try{
            ecrivain =  new  FileWriter(fileName, true);
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    /**
     * Setter du fichier de lecture
     * @param fileName 
     */
    public static void setLecFile(String fileName)
    {
        lectName =fileName;
        try{
             buffMov = new BufferedReader(new FileReader(lectName));
        }
        catch(FileNotFoundException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    /**
     * Fonction permettant d'écrire une rotation à notre fichier
     * @param sens 
     */
    public static void addRotation(int sens)
    {
          try{
            BufferedWriter output = new BufferedWriter(ecrivain);
            output.write((System.currentTimeMillis()-firstTime)+"/Rotation/" + sens+"\r\n");
             output.flush();
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }

    }
    /**
     * Fonction permettant d'écrire un déplacement horizontale dans notre fichier
     * @param x
     * @param y 
     */
    public static void addMove(int x,int y)
    {
            try{
            BufferedWriter output = new BufferedWriter(ecrivain);
            output.write((System.currentTimeMillis()-firstTime)+"/translation/" + x+ "/" +y + "\r\n");
             output.flush();
           
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    /**
     * Focntion permettant d'écrire un déplacement verticale dans notre fichier
     * @param x
     * @param y 
     */
    public static void addDesc(int x,int y)
    {
            try{
            BufferedWriter output = new BufferedWriter(ecrivain);
            output.write((System.currentTimeMillis()-firstTime)+"/incrementation/" + x+ "/" +y +"\r\n");

             output.flush();

           
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    
    /**
     * Getter pour la prochaine fonction écrite dans le fichier
     * de lecture.
     * @return 
     */
    public static String getNextMove()
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
