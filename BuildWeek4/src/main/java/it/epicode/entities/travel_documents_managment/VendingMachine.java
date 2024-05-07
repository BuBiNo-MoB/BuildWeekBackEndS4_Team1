package it.epicode.entities.travel_documents_managment;

import it.epicode.entities.Card;
import it.epicode.entities.constants.Tables;
import it.epicode.enums.Frequency;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = Tables.Names.VENDING_MACHINE)
public class VendingMachine extends TravelDocumentsManager {
    private static final Logger log = LoggerFactory.getLogger(TravelDocumentsManager.class);
    private boolean active;

    public VendingMachine() {
        this.active = true;
    }

    @Override
    public void issueTickets() {
        if (active) {
            super.issueTickets();
        }
        log.warn("TicketMachine is not active, cannot issue ticket");
    }
    @Override
    public void issueSubscription(Frequency frequency, Card card) {
        if (active) {
            super.issueSubscription(frequency, card);
        }
        log.warn("TicketMachine is not active, cannot issue subscription");
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
