package prog2.model;

public class Parcela extends Allotjament{

    private float mida;
    private boolean connexioElectrica;

    public Parcela(String nom, String id, float mida, boolean connexioElectrica) {
        setNom(nom);
        setId(id);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida() {
        return mida;
    }

    public void setMida(float mida) {
        this.mida = mida;
    }

    public boolean isConnexioElectrica() {
        return connexioElectrica;
    }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    public boolean correcteFuncionament(){
        if(connexioElectrica){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString() {
        return "";
    }
}
