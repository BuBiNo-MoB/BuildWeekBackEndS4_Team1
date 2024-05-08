package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import it.epicode.entities.travel_documents.TravelDocumento;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.STRING)
public class ValidateTicket extends BaseEntity {

    private Transport transport;
    private TravelDocumento TravelDocument;

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
