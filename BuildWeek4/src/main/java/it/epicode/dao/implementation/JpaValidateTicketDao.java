package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.ValidateTicketDao;
import it.epicode.entities.transport.ValidateTicket;


public class JpaValidateTicketDao extends JpaDao<ValidateTicket> implements Dao<ValidateTicket>, ValidateTicketDao {
    public JpaValidateTicketDao() {super(ValidateTicket.class);}

}
