package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping{
    private String nom;
    private ArrayList<Allotjament> allotjaments;
    private ArrayList<Client> clients;
    private LlistaReserves reserves;



    public String getNom() {
        return nom;
    }

    public LlistaReserves getLlistaReserves() {
        return reserves;
    }

    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return allotjaments;
    }

    public ArrayList<Client> getLlistaClients() {
        return clients;
    }

    public int getNumAllotjaments() {
        return allotjaments.size();
    }

    public int getNumReserves() {
        return reserves.getNumReserves();
    }

    public int getNumClients() {
        return clients.size();
    }

    public void afegirClient(String nom_, String dni_) {
        clients.add(new Client(nom_,dni_));
    }

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        allotjaments.add(new Parcela(nom_,idAllotjament_, metres, connexioElectrica));
    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        allotjaments.add(new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred));
    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        allotjaments.add(new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi));
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        allotjaments.add(new Gampling(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota));
    }

    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        allotjaments.add(new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa));
    }

    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Iterator<Allotjament> itr = allotjaments.iterator();
        Allotjament allotjament;
        boolean error = true;
        while (itr.hasNext()) {
            if(itr.next().getId().equals(id_)){
                allotjament = itr.next();
                error = false;
            }
        }
        if(error){
            throw new ExcepcioReserva("No existeix aquest allotjament");
        }
        Iterator<Client> itra = clients.iterator();
        Client client;
        error = true;
        while (itra.hasNext()) {
            if(itra.next().getDni().equals(dni_)){
                client = itra.next();
                error = false;
            }
        }
        if(error){
            throw new ExcepcioReserva("No existeix aquest client");
        }
        reserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    public int calculAllotjamentsOperatius() {
        Iterator<Allotjament> itr = allotjaments.iterator();
        int result = 0;
        while (itr.hasNext()) {
            if(itr.next().correcteFuncionament()) {
                result++;
            }
        }
        return result;
    }

    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        Iterator<Allotjament> itr = allotjaments.iterator();
        Allotjament allotjament;
        long min = Long.MAX_VALUE;
        while (itr.hasNext()) {
            if(itr.next().getEstadaMinima(temp) < min) {
                allotjament = itr.next();
                min = allotjament.getEstadaMinima(temp);
            }

        }
        return allotjament;
    }
}