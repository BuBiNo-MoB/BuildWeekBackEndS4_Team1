package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class JpaDao<T> implements Dao<T> {
    private static final Logger log = LoggerFactory.getLogger(JpaDao.class);
    // Nome della persistence unit nel file persistence.xml
    private static final String PERSISTENCE_UNIT = "transportManagment";

    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    // L'entity manager utilizzato in tutti i metodi della classe
    protected final EntityManager em = emf.createEntityManager();

    protected Class<?> type;

    public JpaDao(Class<T> type) {
        this.type = type;
        log.debug("Type is {}", type);
    }


    @Override
    public T save(T e) {
        try {
            var t = em.getTransaction();
            t.begin();
            em.persist(e);
            t.commit();
            return e;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            log.error("Exception in addItem()", ex);
            throw ex;
        }
    }

    @Override
    public void close() throws Exception {
        em.close();
        emf.close();
    }
}
