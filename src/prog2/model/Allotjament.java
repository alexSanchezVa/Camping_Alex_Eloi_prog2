package prog2.model;

public abstract class Allotjament implements InAllotjament{

    // Atributs
    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    // Constructor
    public Allotjament(String nom, String id, long estadaMinimaBAIXA, long estadaMinimaALTA) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
    }

    // Getters i Setters
    /**
     * Obté el nom de l'allotjament.
     * @return el nom de l'allotjament.
     */
    public String getNom(){
        return nom;
    }

    /**
     * Estableix el nom de l'allotjament.
     * @param nom el nom a assignar.
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Obté l'identificador únic de l'allotjament.
     * @return l'identificador únic de l'allotjament.
     */
    public String getId(){
        return id;
    }

    /**
     * Estableix l'identificador únic de l'allotjament.
     * @param id l'identificador a assignar.
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Obté l'estada mínima segons la temporada.
     * @param temp la temporada (ALTA o BAIXA).
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
    public long getEstadaMinima(Temp temp){
        if (temp == Temp.ALTA) {
            return estadaMinimaALTA;
        } else {
            return estadaMinimaBAIXA;
        }
    }

    /**
     * Estableix l'estada mínima per a cada temporada.
     * @param estadaMinimaALTA_ l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        estadaMinimaALTA = estadaMinimaALTA_;
        estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    // Mètode abstracte que s'implementa en les subclasses
    /**
     * Comprova si l'allotjament funciona correctament.
     * La implementació dependrà dels criteris específics de cada tipus d'allotjament.
     * @return true si l'allotjament funciona correctament, false altrament.
     */
    public abstract boolean correcteFuncionament();

    // Mostra la informació de l'allotjament
    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaALTA + ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }
}