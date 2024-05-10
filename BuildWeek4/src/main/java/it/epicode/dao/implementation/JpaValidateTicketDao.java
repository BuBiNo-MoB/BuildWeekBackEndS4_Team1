package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.ValidateTicketDao;
import it.epicode.entities.Card;
import it.epicode.entities.User;
import it.epicode.entities.transport.ValidateTicket;
import it.epicode.entities.travel_documents.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;


public class JpaValidateTicketDao extends JpaDao<ValidateTicket> implements Dao<ValidateTicket>, ValidateTicketDao {
    private static final Logger log = LoggerFactory.getLogger(JpaTravelDocumentDao.class);
    public JpaValidateTicketDao() {
        super(ValidateTicket.class);
    }
    public Long searchValidateTicketByTransportId(int id){
        var res = em.createNamedQuery("SEARCH_ALL_VALIDATED_TICKETS")
                .setParameter("id", id)
                .getSingleResult();
        Long resultParsed = (Long) res;
        if (resultParsed == 0L){
            log.warn("This transport with id {} emitted 0 Subscription", id);
        }
        log.info("This transport with id {} emitted {}", id, resultParsed);
        return (Long) res;
    }
    public Long searchValidateTicketByDate(LocalDate startDate, LocalDate endDate){
        var res = em.createNamedQuery("SEARCH_ALL_VALIDATED_TICKETS_BY_DATE")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getSingleResult();
        Long resultParsed = (Long) res;
        if (resultParsed == 0L){
            log.warn("No Ticket were emitted in this period");
        }
        log.info(" Ticket emitted between {} and {} were", startDate, endDate, resultParsed);
        return (Long) res;
    }
}

