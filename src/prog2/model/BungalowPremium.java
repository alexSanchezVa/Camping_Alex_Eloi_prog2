package prog2.model;

public class BungalowPremium extends Bungalow{

    // Atributs
    private boolean serveisExtra;
    private String codiWifi;

    // Constructor
    public BungalowPremium(String nom, String id, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, id, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    // Getters i Setters
    public boolean isServeisExtra() {
        return serveisExtra;
    }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    // Funciona si té aire fred i un codi wifi vàlid
    @Override
    public boolean correcteFuncionament() {
        if (super.correcteFuncionament() && codiWifi != null && codiWifi.length() >= 8 && codiWifi.length() <= 16) {
            return true;
        }
        else{
            return false;
        }
    }

    // Afegeix la informació del Bungalow Premium
    @Override
    public String toString() {
        return super.toString() + " BungalowPremium{serveisExtra=" + serveisExtra + ", codiWifi=" + codiWifi + "}";
    }
}
