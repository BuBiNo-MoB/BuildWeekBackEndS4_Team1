package it.epicode.entities.travel_documents;

public class Ticket extends TravelDocument {

    //IL TICKET DOVREBBE APPARTENERE AD UN UTENTE
    public Ticket() {
        super();
    }

    @Override
    public String toString() {
        return "Ticket{" + super.toString() + "}";
    }
}
