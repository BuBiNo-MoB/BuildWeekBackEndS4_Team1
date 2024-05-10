package it.epicode.entities.travel_documents;


import it.epicode.entities.constants.Tables;

import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;
import jakarta.persistence.*;

@Entity
@Table(name = Tables.Names.TICKET)
@DiscriminatorValue(Tables.Discriminators.TICKET)
@NamedQuery(
        name = "SEARCH_TICKET_EMITTED_BY_TRAVEL_DOCUMENTS_MANAGER",
        query = "SELECT count(t) FROM Ticket t " +
                "JOIN t.emittedBy m " +
                "WHERE m.id = :id AND t.insertedAt BETWEEN :startDate AND :endDate"
)
public class Ticket extends TravelDocumento {

    public Ticket() {
    }


    public Ticket(TravelDocumentsManager emittedBy) {
        super(emittedBy);
    }


    @Override
    public String toString() {
        return "Ticket{" + super.toString() + "}";
    }
}
