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
                switch (tab[0]) {
                    case "Rotation":
                        this.getModel().rotationTetrominos(Integer.parseInt(tab[1]));
                        break;
                    case "translation":
                       this.getModel().deplacerTetrominosX(Integer.parseInt(tab[1]));
                        break;
                    case "incrementation":
                        this.getModel().deplacerTetrominosY(model.taill_block);
                        break;
                }
    }
}
