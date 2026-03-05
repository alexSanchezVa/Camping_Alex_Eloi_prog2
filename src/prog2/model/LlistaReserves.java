package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaReserves implements InLlistaReserves{
    private ArrayList<Reserva> reserves;

    //Es dona per soposat que la temporada es calcula amb la data de entrada
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        if(!isEstadaMinima(allotjament, dataEntrada, dataSortida)){
            throw new ExcepcioReserva("No es compleix amb l'estada mínima");
        }
        Iterator<Reserva> itr = reserves.iterator();
        Reserva reserva = null;
        while (itr.hasNext()){
            reserva = itr.next();
            if(reserva.getAllotjament_().equals(allotjament) &&
                    ChronoUnit.DAYS.between(reserva.getDataEntrada(), dataSortida) > 0 &&
                    ChronoUnit.DAYS.between(reserva.getDataSortida(), dataEntrada) < 0){
                throws new ExcepcioReserva("L'allotjament no esta disponible en aquest periode")
            }
        }
    }

    /**
     * Retorna el número de reserves de la llista.
     * @return el número de reserves.
     */
    public int getNumReserves(){
        return 0;
    }
}

public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
    int estadaMinima = allotjament.getEstadaMinima(Camping.getTemporada(dataEntrada);
    long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
    return estada >= estadaMinima;
}