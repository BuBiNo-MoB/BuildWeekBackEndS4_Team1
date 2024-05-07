package it.epicode.entities.travel_documents;

import it.epicode.entities.constants.Tables;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = Tables.Names.TICKET)
@DiscriminatorValue(Tables.Discriminators.TICKET)
@NamedQuery(name="issuedTicketsInThisPeriod", query="SELECT t FROM Ticket t WHERE t.insertedAt BETWEEN :startDate AND :endDate")
public class Ticket extends TravelDocument {



    public Ticket() {
        super();
    }

    @Override
    public String toString() {
        return "Ticket{" + super.toString() + "}";
    }
}
