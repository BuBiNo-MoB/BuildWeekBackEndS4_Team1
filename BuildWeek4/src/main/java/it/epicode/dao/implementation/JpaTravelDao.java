package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.TravelDao;
import it.epicode.entities.transport.Travel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class JpaTravelDao extends JpaDao<Travel> implements Dao<Travel>, TravelDao {
    private static final Logger log = LoggerFactory.getLogger(JpaTravelDocumentDao.class);
    public JpaTravelDao() {super(Travel.class);}

    public Long searchAllJourneyByTransport(long id_t, long id_j){
        var res = em.createNamedQuery("SEARCH_ALL_JOURNEY_BY_TRANSPORT")
                .setParameter("id_t", id_t)
                .setParameter("id_j", id_j)
                .getSingleResult();
        Long resultParsed = (Long) res;
        if (resultParsed == 0L){
            log.warn("Journey with id {} was not travelled by transport {}", id_j, id_t);
        }else{
        log.info("Journey with id {} was travelled by transport {}, {} times", id_j, id_t, resultParsed);
        }

        return (Long) res;
    }
}
