package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.CardDao;
import it.epicode.dao.interfaces.Dao;
import it.epicode.entities.Card;

public class JpaCardDao extends JpaDao<Card> implements Dao<Card>, CardDao {
    public JpaCardDao() {super(Card.class);}
}
