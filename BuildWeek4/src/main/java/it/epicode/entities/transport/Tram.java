package it.epicode.entities.transport;

import it.epicode.entities.constants.Tables;

public class Tram extends Transport {

    //INSERIRE GESTIONE DEI PERIODI DI SERVIZIO O MANUTENZIONE
    //INSERIRE RELAZIONE CON IN BIGLIETTI

    public Tram() {
        super(Tables.Capacity.TRAM_CAPACITY);
    }

    @Override
    public String toString() {
        return "Tram{" + super.toString() + '}';
    }
}
