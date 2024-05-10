package it.epicode.entities.travel_documents;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.Card;
import it.epicode.entities.constants.Tables;
import it.epicode.entities.transport.ValidateTicket;
import it.epicode.entities.travel_documents_managment.AuthorizedRetailer;
import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;
import it.epicode.entities.travel_documents_managment.VendingMachine;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.security.SecureRandomParameters;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.STRING)
@NamedQuery(
        name = "SEARCH_ALL_TRAVEL_DOCUMENTS_EMITTED_BY_TRAVEL_DOCUMENTS_MANAGER",
        query = "SELECT count(d) FROM TravelDocumento d " +
                "JOIN d.emittedBy m " +
                "WHERE m.id = :id AND d.insertedAt BETWEEN :startDate AND :endDate"
)



public abstract class TravelDocumento extends BaseEntity implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(TravelDocumento.class);


    @ManyToOne
    @JoinColumn(name = "TravelDocumentsManager_id")
    private TravelDocumentsManager emittedBy;

    @OneToOne(mappedBy = "TravelDocument")
    private ValidateTicket validateTicket;

    public TravelDocumento() {
    }

    public TravelDocumento(TravelDocumentsManager emittedBy){
        this.emittedBy = emittedBy;

    }


    public ValidateTicket getValidateTicket() {
        return validateTicket;
    }

    public void setValidateTicket(ValidateTicket validateTicket) {
        this.validateTicket = validateTicket;
    }

    public TravelDocumentsManager getEmittedBy() {
        return emittedBy;
    }

    public void setEmittedBy(TravelDocumentsManager emittedBy) {
        this.emittedBy = emittedBy;
    }

    @Override
    public String toString() {
        return "TravelDocument{" + super.toString() + '}';
    }
}

