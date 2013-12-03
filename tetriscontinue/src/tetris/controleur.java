package tetris;



// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3CF0A97E-E3BB-5EEB-4518-C5D5D4F73313]
// </editor-fold> 
public abstract class controleur {

    public model myModel;
    private savFile mySavFile;
    private int scale =2;
    
    public controleur (model myModel) {
        this.myModel=myModel;
        
        
    }
    public int getScale()
    {
        return scale;
    }
    public void addSavFile(String name)
    {
        mySavFile=new savFile(name);
    }
    public abstract void gestionTouche(Object o);

}

