package prog2.model;

public class Parcela extends Allotjament {

    // Atributs
    private float mida;
    private boolean connexioElectrica;

    // Constructor
    public Parcela(String nom, String id, float mida, boolean connexioElectrica) {
        super(nom, id, 2, 4);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    // Getters i Setters
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

    @Override
    public boolean correcteFuncionament() {
        if (connexioElectrica) {
            return true;
        } else {
            return false;
        }
    }

    // Afegeix la informació de la Parcela
    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + mida + ", connexioElectrica=" + connexioElectrica + "}";
    }
}
