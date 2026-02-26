package prog2.model;

public class BungalowPremium extends Bungalow{

    private boolean serveisExtra;
    private String codiWifi;

    public BungalowPremium(String nom, String id, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, id, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

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

    @Override
    public boolean correcteFuncionament() {
        if (super.correcteFuncionament() && codiWifi != null && codiWifi.length() >= 8 && codiWifi.length() <= 16) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", serveisExtra = " + serveisExtra + ", codiWifi = " + codiWifi;
    }
}
