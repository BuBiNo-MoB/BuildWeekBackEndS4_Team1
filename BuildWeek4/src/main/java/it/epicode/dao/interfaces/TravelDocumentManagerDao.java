package it.epicode.dao.interfaces;

import it.epicode.entities.Card;
import it.epicode.entities.travel_documents.Subscription;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;
import it.epicode.enums.Frequency;

public interface TravelDocumentManagerDao extends Dao<TravelDocumentsManager>{

    public void issueTickets();
//    {
//        Ticket ticket = new Ticket();
//        log.info("Tickets succesfully issued. Actually issued Tickets" );
//    }

    public void issueSubscription(Frequency frequency, Card card, TravelDocumentsManager emittedBy);
//    {
//        if (card.isValid()){
//            Subscription subscription = new Subscription(frequency, card);
//            log.info("Subscription succesfully issued. Actually issued Subscription ");
//        }
//        log.warn("Unfortunately your card is expired");
//    }
}
