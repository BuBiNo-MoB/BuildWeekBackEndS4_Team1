package it.epicode.entities.travel_documents_managment;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.Card;
import it.epicode.entities.constants.Tables;
import it.epicode.entities.travel_documents.Subscription;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.enums.Frequency;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.STRING)
public abstract class TravelDocumentsManager extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(TravelDocumentsManager.class);

    @OneToMany(mappedBy = "emittedBy")
    private List<Ticket> tickets = new ArrayList<>();

    public TravelDocumentsManager() {
    }


    @Override
    public String toString() {
        return "TravelDocumentsManager{" + super.toString() + '}';
    }
}
