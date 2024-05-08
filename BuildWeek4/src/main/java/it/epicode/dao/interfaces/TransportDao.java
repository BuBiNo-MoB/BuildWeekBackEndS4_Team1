package it.epicode.dao.interfaces;

import it.epicode.entities.transport.Transport;

public interface TransportDao extends Dao<Transport>{

    public void underMaintenanceStart(Transport transport);
    public void underMaintenanceEnd(Transport transport);
}
