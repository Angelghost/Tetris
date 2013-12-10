/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author Angelgosth
 */
public class lecteurSeq extends controleur{
    
    private savFile mySavFile;
    
    public lecteurSeq (model myModel,String name) {
        super(myModel,1);
        
        mySavFile=new savFile(name);
        savFile.setLecFile(name);
    }
    @Override
    public void gestionTouche(Object o){
  
        String str = savFile.getNextMove();

                String tab[]=str.split("/");

                if("Rotation".equals(tab[0]))
                {
                    myModel.rotationTetrominos(Integer.parseInt(tab[1]));
                }
                else if("translation".equals(tab[0]))
                {
                    myModel.deplacerTetrominos(Integer.parseInt(tab[1]),Integer.parseInt(tab[2]));
                }
                else if("incrementation".equals(tab[0]))
                {
                     myModel.deplacerTetrominosY(0,model.taill_block);
                }
                str = savFile.getNextMove();


    }
}
