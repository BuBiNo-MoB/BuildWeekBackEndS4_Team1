package it.epicode.dao.interfaces;

import it.epicode.entities.Card;

public interface CardDao extends Dao<Card>{
    public void renew(Card card);
}
