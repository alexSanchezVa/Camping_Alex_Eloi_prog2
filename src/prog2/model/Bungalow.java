package prog2.model;

public class Bungalow extends Casa{

    // Atributs
    private int placesParquing;
    private boolean terrassa;
    private boolean tele;
    private boolean aireFred;

    public Bungalow(String nom, String id, String mida, int habitacions, int persones, int placesParquing, boolean terrassa, boolean tele, boolean aireFred) {

        super(nom, id, mida, habitacions, persones, 4, 7);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tele = tele;
        this.aireFred = aireFred;
    }

    // Getters i Setters
    public int getPlacesParquing() {
        return placesParquing;
    }

    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }

    public boolean isTerrassa() {
        return terrassa;
    }

    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    public boolean isTele() {
        return tele;
    }

    public void setTele(boolean tele) {
        this.tele = tele;
    }

    public boolean isAireFred() {
        return aireFred;
    }

    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    // Funciona si hi ha aire fred
    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    // Afegeix la informació del Bungalow
    @Override
    public String toString() {
        return super.toString() + " Bungalow{placesParquing=" + placesParquing + ", terrassa=" + terrassa + ", televisio=" + tele + ", aireFred=" + aireFred + "}";
    }
}
