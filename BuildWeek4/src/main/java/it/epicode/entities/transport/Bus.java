package it.epicode.entities.transport;


import it.epicode.entities.constants.Tables;

public class Bus extends Transport {

    //INSERIRE GESTIONE DEI PERIODI DI SERVIZIO O MANUTENZIONE
    //INSERIRE RELAZIONE CON IN BIGLIETTI

    public Bus() {
        super(Tables.Capacity.BUS_CAPACITY);
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() + '}';
    }
}
