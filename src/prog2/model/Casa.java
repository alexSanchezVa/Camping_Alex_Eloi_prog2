package prog2.model;

public abstract class Casa extends Allotjament{

    private String mida;
    private int habitacions;
    private int persones;

    public Casa(String nom, String id, String mida, int habitacions, int persones, long estadaMinimaALTA, long estadaMinimaBAIXA){
        super(nom, id, estadaMinimaALTA, estadaMinimaBAIXA);
        this.mida = mida;
        this.habitacions = habitacions;
        this.persones = persones;
    }

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

    @Override
    public String toString() {
        return super.toString() + "Mida " + mida + ", " + habitacions + " habitacions," + " per" + persones + "persones";
    }
}
