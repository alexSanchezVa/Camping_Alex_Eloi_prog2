package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaReserves implements InLlistaReserves{
    private ArrayList<Reserva> reserves = new ArrayList<>();

    //Es dona per soposat que la temporada es calcula amb la data de entrada
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        if(!isEstadaMinima(allotjament, dataEntrada, dataSortida)){
            throw new ExcepcioReserva("No es compleix amb l'estada mínima");
        }
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)){
            throw new ExcepcioReserva("L'allotjament amb identificador "+allotjament.getId()+" no està disponible en la data demanada "+dataEntrada+" pel client "+client.getNom()+" amb DNI: "+client.getDni()+".");
        }
        reserves.add(new Reserva(allotjament, client, dataEntrada, dataSortida));

    }

    /**
     * Retorna el número de reserves de la llista.
     * @return el número de reserves.
     */
    public int getNumReserves(){
        return reserves.size();
    }


    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        long estadaMinima = allotjament.getEstadaMinima(Camping.getTemporada(dataEntrada));
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        return estada >= estadaMinima;
    }

    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        Iterator<Reserva> itr = reserves.iterator();
        Reserva reserva = null;
        while (itr.hasNext()){
            reserva = itr.next();
            //Per comprovar si hi ha un solapament en la reserva de l'allotjament despres de trobar una reserva feta en el mateix alotjament,
            //  donats el dos intervals (a, b) i (c, d) es comprova si b < c i a > d si aixo es cert significa que els intervals es solapen
            if(reserva.getAllotjament_().equals(allotjament) &&
                    reserva.getDataEntrada().isBefore(dataSortida) &&
                    !(reserva.getDataSortida().isBefore(dataEntrada))){
                    return false;
            }
        }
        return true;
    }
}