package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.PeriodDao;
import it.epicode.entities.transport.Period;

public class JpaPeriodDao extends JpaDao<Period> implements Dao<Period>, PeriodDao {
    public JpaPeriodDao() {super(Period.class);}
}