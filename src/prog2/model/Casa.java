package prog2.model;

public abstract class Casa extends Allotjament{

    // Atributs
    private String mida;
    private int habitacions;
    private int persones;

    // Constructor
    public Casa(String nom, String id, String mida, int habitacions, int persones, long estadaMinimaBAIXA, long estadaMinimaALTA){
        super(nom, id, estadaMinimaALTA, estadaMinimaBAIXA);
        this.mida = mida;
        this.habitacions = habitacions;
        this.persones = persones;
    }

    // Getters i Setters
    public String getMida() {
        return mida;
    }

    public void setMida(String mida) {
        this.mida = mida;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public int getPersones() {
        return persones;
    }

    public void setPersones(int placesPersones) {
        this.persones = placesPersones;
    }

    // Afegeix la informació de la Casa
    @Override
    public String toString() {
        return super.toString() + " Casa{mida=" + mida + ", habitacions=" + habitacions + ", placesPersones=" + persones + "}";    }
}
