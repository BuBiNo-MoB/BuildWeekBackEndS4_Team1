package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.TransportDao;
import it.epicode.entities.transport.Transport;

public class JpaTransportDao extends JpaDao<Transport> implements Dao<Transport>, TransportDao {
    public JpaTransportDao() {super(Transport.class);}
}
