package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.JourneyDao;
import it.epicode.entities.transport.Journey;

public class JpaJourneyDao extends JpaDao<Journey> implements Dao<Journey>, JourneyDao {
    public JpaJourneyDao() {super(Journey.class);}
}
