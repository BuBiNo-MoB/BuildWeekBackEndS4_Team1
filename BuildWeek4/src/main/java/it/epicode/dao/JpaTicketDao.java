package it.epicode.dao;

import it.epicode.entities.travel_documents.Ticket;

public class JpaTicketDao extends JpaDao<Ticket> implements TicketDao {

    public JpaTicketDao() {
        super(Ticket.class);
    }
}
