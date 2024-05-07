package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.entities.transport.Period;

public class JpaPeriodDao extends JpaDao<Period> implements Dao<Period> {
    public JpaPeriodDao() {super(Period.class);}
}