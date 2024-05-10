package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.CardDao;
import it.epicode.dao.interfaces.Dao;
import it.epicode.entities.Card;
import it.epicode.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class JpaCardDao extends JpaDao<Card> implements Dao<Card>, CardDao {
    private static final Logger log = LoggerFactory.getLogger(JpaCardDao.class);

    public JpaCardDao() {super(Card.class);}

    @Override
    public Card save(Card e) {
        try {
            var t = em.getTransaction();
            t.begin();
            em.persist(e);
            var u = e.getUser();
            if (u != null) {
                // Se l'utente ha un ID, ricarica completamente l'entità dalla base di dati
                u = em.find(User.class, u.getId());
                u.setCard(e);
                em.persist(u);
            }
            t.commit();
            return e;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            log.error("Exception in save()", ex);
            throw ex;
        }
    }


    @Override
    public void renew(Card card) {
        if (LocalDate.now().isAfter(card.getExpiration_date()))
        {
            var t = em.getTransaction();
            t.begin();
            card.setExpiration_date(LocalDate.now().plusDays(365));
            em.persist(card);
            t.commit();
            log.info("Your card has been renewed, expiration date:{}", card.getExpiration_date());
        }else{
            log.warn("Your card is still valid, expiration date:{}", card.getExpiration_date());
        }
    }
}
