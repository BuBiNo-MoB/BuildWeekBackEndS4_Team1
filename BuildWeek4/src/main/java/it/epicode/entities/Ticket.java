package it.epicode.entities;

public class Ticket extends TravelDocument{

    public Ticket() {
        super();
    }

    @Override
    public String toString() {
        return "Ticket{" + "Id:"+ getId() + " Created At:" + getInsertedAt() + " Valid=" + isValid() + "}";
    }
}
