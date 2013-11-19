/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author Angelgosth
 */
public class IA extends controleur{
    
    private savFile mySavFile;
    
    public IA (model myModel,String name) {
        super(myModel);
        
        mySavFile=new savFile(name);
    }
    @Override
    public void gestionTouche(Object o){

    }
}
