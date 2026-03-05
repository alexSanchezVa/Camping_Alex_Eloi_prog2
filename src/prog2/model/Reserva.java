package prog2.model;
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

public class Reserva implements InReserva{

    // Atributs
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    // Constructor
    Reserva(Allotjament allotjament, Client client,  LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {

        if (dataSortida.isBefore(dataEntrada)) { // Si la data de sortida és abans que la d'entrada, llença l'excepció reserva
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    // Getters i Setters
    public Allotjament getAllotjament_(){
        return allotjament;
    }

    public Client getClient(){
        return client;
    }

    public LocalDate getDataEntrada(){
        return dataEntrada;
    }

    public LocalDate getDataSortida(){
        return dataSortida;
    }

    public void setAllotjament_(Allotjament allotjament_){
        allotjament = allotjament_;
    }

    public void setClient(Client client_){
        client = client_;
    }

    public void setDataEntrada(LocalDate dataEntrada_){
        dataEntrada = dataEntrada_;
    }

    public void setDataSortida(LocalDate dataSortida_){
        dataEntrada = dataSortida_;
    }
}