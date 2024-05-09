package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.TransportDao;
import it.epicode.entities.transport.Period;
import it.epicode.entities.transport.Transport;
import it.epicode.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class JpaTransportDao extends JpaDao<Transport> implements Dao<Transport>, TransportDao {
    public JpaTransportDao() {super(Transport.class);}
    private static final Logger log = LoggerFactory.getLogger(JpaTransportDao.class);

    @Override
    public void underMaintenanceStart(Transport transport) {
        try
        {
            log.info("transport= {}", transport);

            Period period = new Period(transport.getInServiceSince(), LocalDateTime.now(), transport, Status.IN_SERVICE);
            em.persist(period);

        } catch (Exception e) {
            log.error("Exception in underMaintenanceStart()", e);
        }
            //SE LA PRIMA NON VA A BUON FINE LA SECONDA VEINEE ESGUIOTA COMUNQUE
        try {
            var t = em.getTransaction();
            t.begin();
            transport.setInServiceSince(null);
            transport.setUnderMaintenanceSince(LocalDateTime.now());
            em.persist(transport);
            t.commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            log.error("Exception in underMaintenanceStart()", ex);
            throw ex;
        }



    }

    @Override
    public void underMaintenanceEnd(Transport transport) {
        try
        {
            Period period = new Period(transport.getUnderMaintenanceSince(), LocalDateTime.now(), transport, Status.UNDER_MAINTENANCE);
            em.persist(period);
        } catch (Exception e) {
            log.error("Exception in underMaintenanceEnd()", e);
        }
        try {
            var t = em.getTransaction();
            t.begin();
            transport.setInServiceSince(LocalDateTime.now());
            transport.setUnderMaintenanceSince(null);
            em.persist(transport);
            t.commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            log.error("Exception in underMaintenanceEnd()", ex);
            throw ex;
        }
    }

}
