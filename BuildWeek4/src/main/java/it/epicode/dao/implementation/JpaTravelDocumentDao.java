package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.TravelDocumentDao;
import it.epicode.entities.travel_documents.TravelDocumento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class JpaTravelDocumentDao extends JpaDao<TravelDocumento> implements Dao<TravelDocumento>, TravelDocumentDao {
    private static final Logger log = LoggerFactory.getLogger(JpaTravelDocumentDao.class);

    public JpaTravelDocumentDao() {super(TravelDocumento.class);}

    public Long searchAllTravelDocumentsEmittedById(int id, LocalDate startDate, LocalDate endDate){
           var res = em.createNamedQuery("SEARCH_ALL_TRAVEL_DOCUMENTS_EMITTED_BY_TRAVEL_DOCUMENTS_MANAGER")
                .setParameter("id", id)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                 .getSingleResult();
        Long resultParsed = (Long) res;
        if (resultParsed == 0L){
            log.warn("This travelDocumentsManager with id {} emitted 0 travelDocument", id);
        }
        log.info("This travelDocumentsManager with id {} emitted {} travelDocuments between {} and {}", id, resultParsed, startDate, endDate);
        return (Long) res;
    }

    public Long searchTicketEmittedById(int id, LocalDate startDate, LocalDate endDate){
           var res = em.createNamedQuery("SEARCH_TICKET_EMITTED_BY_TRAVEL_DOCUMENTS_MANAGER")
                .setParameter("id", id)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getSingleResult();
        Long resultParsed = (Long) res;
        if (resultParsed == 0L){
            log.warn("This travelDocumentsManager with id {} emitted 0 Ticket", id);
        }
        log.info("This travelDocumentsManager with id {} emitted {} Tickets between {} and {}", id, resultParsed, startDate, endDate);
        return (Long) res;
    }

    public Long searchSubscriptionEmittedById(int id, LocalDate startDate, LocalDate endDate){
           var res = em.createNamedQuery("SEARCH_SUBSCRIPTION_EMITTED_BY_TRAVEL_DOCUMENTS_MANAGER")
                .setParameter("id", id)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getSingleResult();
        Long resultParsed = (Long) res;
           if (resultParsed == 0L){
               log.warn("This travelDocumentsManager with id {} emitted 0 Subscription", id);
           }
               log.info("This travelDocumentsManager with id {} emitted {} Subscriptions between {} and {}", id, resultParsed, startDate, endDate);
        return (Long) res;
    }
}
