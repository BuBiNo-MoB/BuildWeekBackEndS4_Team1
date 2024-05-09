package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.CardDao;
import it.epicode.dao.interfaces.Dao;
import it.epicode.entities.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class JpaCardDao extends JpaDao<Card> implements Dao<Card>, CardDao {
    private static final Logger log = LoggerFactory.getLogger(JpaCardDao.class);

    public JpaCardDao() {super(Card.class);}

    @Override
    public void renew(Card card) {
        if (LocalDate.now().isAfter(card.getExpiration_date()))
        {
            var t = em.getTransaction();
            t.begin();
            card.setExpiration_date();
            em.persist(card);
            t.commit();
            log.info("Your card has been renewed, expiration date:{}", card.getExpiration_date());
        }else{
            log.warn("Your card is still valid, expiration date:{}", card.getExpiration_date());
        }
    }
}
