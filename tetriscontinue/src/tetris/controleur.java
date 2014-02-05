package tetris;



// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3CF0A97E-E3BB-5EEB-4518-C5D5D4F73313]
// </editor-fold> 
/**
 * Class abstract conteur qui permet d'implémenté les controleurs du tétris
 * @author Akmale
 */
public abstract class controleur {

    private model myModel;
    private savFile mySavFile;
    private int type;
    
    /**
     * Construteur de base de la classe controleur
     * @param myModel
     * @param type 
     */
    public controleur (model myModel,int type) {
        this.myModel=myModel;
        this.type=type;
        
    }
    /**
     * Getter type
     * @return 
     */
    public int getType()
    {
        return type;
    }
    /**
     * Setter type
     * @param i 
     */
    public void setType(int i)
    {
        type=i;
    }
    /**
     * Getter Model
     * @return 
     */
    public model getModel()
    {
        return myModel;
    }
    /**
     * Setter model
     * @param m 
     */
    public void setModel(model m)
    {
        myModel=m;
    }
    /**
     *  Setter du nom du fichier de sauvegarde des mouvements de jeu
     * @param name 
     */
    public void addSavFile(String name)
    {
        mySavFile=new savFile(name);
    }
    /**
     *  Getter de mySavFile
     * @return 
     */
    public savFile getSaveFile()
    {
        return mySavFile;
    }
    /**
     * Fonction à implémenter lors de l' héritage de cette classe permet
     * de gérer la gestion des touches.
     * @param o 
     */
    public abstract void gestionTouche(Object o);

}

