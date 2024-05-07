package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.entities.travel_documents.TravelDocument;
import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;

public class JpaTravelDocumentManagerDao extends JpaDao<TravelDocumentsManager> implements Dao<TravelDocumentsManager>{
    public JpaTravelDocumentManagerDao() {super(TravelDocumentsManager.class);}
}
