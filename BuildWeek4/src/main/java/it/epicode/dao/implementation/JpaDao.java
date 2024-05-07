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


    //SCRIVERE LA QUERY COSI: "SELECT t FROM Classe t WHERE t.id = :id"
    @Override
    public Optional<T> getById(String query, Class<T> entityType, long id) {
        try {
            TypedQuery<T> typedQuery = em.createQuery(query, entityType)
                    .setParameter("id", id);
            T result = typedQuery.getSingleResult();
            return Optional.ofNullable(result);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(String query, Class<T> entityType, long id) {
        try {
            var t = em.getTransaction();
            t.begin();
            var toRemove = this.getById( query, entityType, id);
            toRemove.ifPresentOrElse(
                    item -> {
                        try {
                            em.remove(toRemove.get());
                            t.commit();
                            } catch (NoSuchElementException ex) {
                            log.error("NoSuchElementException in deleteById():", ex);
                        }
                    },
                    () -> log.warn("Nessun elemento trovato con id: {}", id)
            );
        } catch (Exception ex){
            log.error("Exception in removeItemByISBN()", ex);
        }
    }

    @Override
    public void close() throws Exception {
        em.close();
        emf.close();
    }
}
