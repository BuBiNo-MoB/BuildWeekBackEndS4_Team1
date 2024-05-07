package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.entities.transport.Travel;

public class JpaTravelDao extends JpaDao<Travel> implements Dao<Travel> {
    public JpaTravelDao() {super(Travel.class);}
}
