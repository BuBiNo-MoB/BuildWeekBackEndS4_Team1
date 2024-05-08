package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.TravelDocumentManagerDao;
import it.epicode.entities.Card;
import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;
import it.epicode.enums.Frequency;

public class JpaTravelDocumentManagerDao extends JpaDao<TravelDocumentsManager> implements Dao<TravelDocumentsManager>, TravelDocumentManagerDao {
    public JpaTravelDocumentManagerDao() {super(TravelDocumentsManager.class);}

}
