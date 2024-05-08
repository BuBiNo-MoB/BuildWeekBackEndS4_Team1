package it.epicode.entities.travel_documents;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;
import it.epicode.entities.travel_documents_managment.VendingMachine;
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.STRING)
public abstract class TravelDocumento extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "TravelDocumentsManager_id")
    private TravelDocumentsManager emittedBy;


    public TravelDocumento() {
    }

    public TravelDocumento(TravelDocumentsManager emittedBy){
        if (emittedBy instanceof VendingMachine && ((VendingMachine) emittedBy).isActive()) {
            throw new IllegalArgumentException("VendingMachine is not active, cannot issue TravelDocument");
        }
        this.emittedBy = emittedBy;

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

