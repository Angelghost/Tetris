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
    
    public void setModel(model m)
    {
        myModel=m;
    }
    public void addSavFile(String name)
    {
        mySavFile=new savFile(name);
    }
    public savFile getSaveFile()
    {
        return mySavFile;
    }
    public abstract void gestionTouche(Object o);

}

