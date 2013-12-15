package tetris;



// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3CF0A97E-E3BB-5EEB-4518-C5D5D4F73313]
// </editor-fold> 
public abstract class controleur {

    public model myModel;
    private savFile mySavFile;
    public int type;
    public controleur (model myModel,int type) {
        this.myModel=myModel;
        this.type=type;
        
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

