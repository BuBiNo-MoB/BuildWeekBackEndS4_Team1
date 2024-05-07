package it.epicode.dao.implementation;

import it.epicode.dao.interfaces.Dao;
import it.epicode.dao.interfaces.TravelDocumentDao;
import it.epicode.entities.travel_documents.TravelDocument;
import jakarta.persistence.NoResultException;

import java.util.Optional;

public class JpaTravelDocumentDao extends JpaDao<TravelDocument> implements Dao<TravelDocument> {
    public JpaTravelDocumentDao() {super(TravelDocument.class);}

}
