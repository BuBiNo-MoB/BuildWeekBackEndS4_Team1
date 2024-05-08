package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.TravelDocumentDao;
import it.epicode.entities.travel_documents.TravelDocumento;

public class JpaTravelDocumentDao extends JpaDao<TravelDocumento> implements Dao<TravelDocumento>, TravelDocumentDao {
    public JpaTravelDocumentDao() {super(TravelDocumento.class);}

}
