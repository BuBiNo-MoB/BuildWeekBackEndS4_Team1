package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.User;
import it.epicode.entities.constants.Tables;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.entities.travel_documents.TravelDocumento;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.STRING)
@NamedQuery(
        name = "SEARCH_ALL_VALIDATED_TICKETS",
        query = "SELECT count(d) FROM ValidateTicket d " +
                "WHERE d.transport.id = :id "
)

@NamedQuery(
        name = "SEARCH_ALL_VALIDATED_TICKETS_BY_DATE",
        query = "SELECT count(d) FROM ValidateTicket d " +
                "WHERE d.insertedAt BETWEEN :startDate AND :endDate"
)
public class ValidateTicket extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "travelDocumento_id" )
    private TravelDocumento TravelDocument;

    @OneToOne
    @JoinColumn(name = "transport_id" )
    private Transport transport;

    public ValidateTicket() {
    }

    public ValidateTicket(Transport transport, TravelDocumento travelDocument) {
        this.transport = transport;
        TravelDocument = travelDocument;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public TravelDocumento getTravelDocument() {
        return TravelDocument;
    }

    public void setTravelDocument(TravelDocumento travelDocument) {
        TravelDocument = travelDocument;
    }

    @Override
    public String toString() {
        return "ValidateTicket{" + "transport:" + transport + ", TravelDocument:" + TravelDocument + '}';
    }
}
