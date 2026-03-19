package prog2.model;

public class MobilHome extends Casa {

    // Atributs
    private boolean terrassaBarbacoa;

    // Constructor
    public MobilHome(String nom, String id, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, id, mida, habitacions, placesPersones, 3, 5);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Getters i Setters
    public boolean isTerrassaBarbacoa() {
        return terrassaBarbacoa;
    }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

    // Afegeix la informació del MobileHome
    @Override
    public String toString() {
        return super.toString() + " MobilHome{terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }
}
