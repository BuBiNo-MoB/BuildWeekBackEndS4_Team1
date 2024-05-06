package it.epicode.entities.travel_documents;

public class Ticket extends TravelDocument {

    public Ticket() {
        super();
    }

    @Override
    public String toString() {
        return "Ticket{" + super.toString() + " Valid=" + isValid() + "}";
    }
}
