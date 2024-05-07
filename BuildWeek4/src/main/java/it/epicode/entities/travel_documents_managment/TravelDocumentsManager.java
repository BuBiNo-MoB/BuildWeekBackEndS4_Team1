package it.epicode.entities.travel_documents_managment;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.Card;
import it.epicode.entities.constants.Tables;
import it.epicode.entities.travel_documents.Subscription;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.enums.Frequency;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TravelDocumentsManager extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(TravelDocumentsManager.class);
    private int issuedTickets;
    private int issuedSubscription;

    public TravelDocumentsManager() {
        this.issuedTickets = 0;
        this.issuedSubscription = 0;
    }

    public void issueTickets() {
        Ticket ticket = new Ticket();
        issuedTickets++;
        log.info("Tickets succesfully issued. Actually issued Tickets {} ", this.getIssuedTickets() );
    }

    public void issueSubscription(Frequency frequency, Card card) {
        if (card.isValid()){
            Subscription subscription = new Subscription(frequency, card);
            issuedSubscription++;
            log.info("Subscription succesfully issued. Actually issued Subscription {} ", this.getIssuedSubscription() );
        }
            log.warn("Unfortunately your card is expired");
    }

    public int getIssuedTickets() {
        return issuedTickets;
    }

    public void setIssuedTickets(int issuedTickets) {
        this.issuedTickets = issuedTickets;
    }

    public int getIssuedSubscription() {
        return issuedSubscription;
    }

    public void setIssuedSubscription(int issuedSubscription) {
        this.issuedSubscription = issuedSubscription;
    }

    @Override
    public String toString() {
        return "TravelDocumentsManager{" + super.toString() + '}';
    }
}
