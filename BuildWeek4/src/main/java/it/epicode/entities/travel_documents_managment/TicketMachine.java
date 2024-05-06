package it.epicode.entities.travel_documents_managment;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.Card;
import it.epicode.entities.travel_documents.Subscription;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.enums.Frequency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketMachine extends TravelDocumentsManager {
    private static final Logger log = LoggerFactory.getLogger(TravelDocumentsManager.class);
    private boolean active;

    public TicketMachine() {
        this.active = true;
    }

    @Override
    public void issueTickets() {
        if (active) {
            super.issueTickets();
        }
    }
    @Override
    public void issueSubscription(Frequency frequency, Card card) {
        if (active) {
            super.issueSubscription(frequency, card);
        }
    }



    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "TicketMachine{" + super.toString() + " active=" + active + '}';
    }
}
