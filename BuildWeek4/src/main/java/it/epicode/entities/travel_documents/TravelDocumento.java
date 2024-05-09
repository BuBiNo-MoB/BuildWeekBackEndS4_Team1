package it.epicode.entities.travel_documents;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import it.epicode.entities.travel_documents_managment.AuthorizedRetailer;
import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;
import it.epicode.entities.travel_documents_managment.VendingMachine;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.security.SecureRandomParameters;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.STRING)
public abstract class TravelDocumento extends BaseEntity implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(TravelDocumento.class);

    @ManyToOne
    @JoinColumn(name = "TravelDocumentsManager_id")
    private TravelDocumentsManager emittedBy;


    public TravelDocumento() {
    }

    public TravelDocumento(TravelDocumentsManager emittedBy){
        if ((emittedBy instanceof VendingMachine && ((VendingMachine) emittedBy).isActive()) || emittedBy instanceof AuthorizedRetailer) {
            this.emittedBy = emittedBy;
        }else {
            throw new IllegalArgumentException("VendingMachine is not active, cannot issue TravelDocument");
        }

    }


    public TravelDocumentsManager getEmittedBy() {
        return emittedBy;
    }

    public void setEmittedBy(TravelDocumentsManager emittedBy) {
        this.emittedBy = emittedBy;
    }

    @Override
    public String toString() {
        return "TravelDocument{" + super.toString() + '}';
    }
}

