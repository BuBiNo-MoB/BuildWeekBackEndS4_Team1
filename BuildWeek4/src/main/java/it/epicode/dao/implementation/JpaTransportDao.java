package it.epicode.dao.implementation;

import it.epicode.Main;
import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.TransportDao;
import it.epicode.entities.transport.Period;
import it.epicode.entities.transport.Transport;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.enums.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class JpaTransportDao extends JpaDao<Transport> implements Dao<Transport>, TransportDao {
    public JpaTransportDao() {super(Transport.class);}
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String PERSISTENCE_UNIT = "transportManagment";
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    private final EntityManager em = emf.createEntityManager();

    @Override
    public void underMaintenanceStart(Transport transport) {
        try (var periodDao = new JpaPeriodDao())
        {
            Period period = new Period(transport.getInServiceSince(), LocalDateTime.now(), transport, Status.IN_SERVICE);
            periodDao.save(period);
        } catch (Exception e) {
            log.error("Exception in underMaintenanceStart()", e);
        }

        em.createQuery("UPDATE Transport t SET t.inServiceSince = NULL, t.underMaintenanceSince = CURRENT_DATE", Transport.class)
                .executeUpdate();

    }

    @Override
    public void underMaintenanceEnd(Transport transport) {
        try (var periodDao = new JpaPeriodDao())
        {
            Period period = new Period(transport.getUnderMaintenanceSince(), LocalDateTime.now(), transport, Status.UNDER_MAINTENANCE);
            periodDao.save(period);
        } catch (Exception e) {
            log.error("Exception in underMaintenanceEnd()", e);
        }

        em.createQuery("UPDATE Transport t SET t.inServiceSince = CURRENT_DATE, t.underMaintenanceSince = NULL", Transport.class)
                .executeUpdate();
    }
}
