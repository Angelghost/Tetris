/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 * Class hérittant de controleur permettant de lire une sequence déjà joué
 * @author Angelgosth
 */
public class lecteurSeq extends controleur{
    
    private long currentTime;
    
    public lecteurSeq (model myModel,String name) {
        super(myModel,1);
        savFile.setLecFile(name);
        currentTime =0;
    }
    
    /**
     * Gestion des entrées du fichier sequence 
     * @param o 
     */
    @Override
    public void gestionTouche(Object o){
  
        currentTime+=5;
        String str = savFile.getNextMove();
        String tab[]=str.split("/");

         System.out.println(Integer.parseInt(tab[0]) +"-"+currentTime);
                switch (tab[1]) {
                    case "Rotation":
                        this.getModel().rotationTetrominos(Integer.parseInt(tab[2]));
                        break;
                    case "translation":
                       this.getModel().deplacerTetrominosX(Integer.parseInt(tab[2]));
                        break;
                    case "incrementation":
                        this.getModel().deplacerTetrominosY(1);
                        break;
                }

    }
}
