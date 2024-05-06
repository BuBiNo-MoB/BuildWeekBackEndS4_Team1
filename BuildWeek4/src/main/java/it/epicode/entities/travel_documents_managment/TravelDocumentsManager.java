package it.epicode.entities.travel_documents_managment;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.Card;
import it.epicode.entities.travel_documents.Subscription;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.enums.Frequency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class TravelDocumentsManager extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(TravelDocumentsManager.class);
    private int issuedTickets;
    private int issuedSubscription;


    public void issueTickets() {
        Ticket ticket = new Ticket();
        issuedTickets++;
        log.info("Tickets succesfully issued. Actually issued Tickets {} ", this.getIssuedTickets() );
    }
    public void issueSubscription(Frequency frequency, Card card) {
        if (!card.getExpiration_date().isAfter(LocalDate.now())){
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
