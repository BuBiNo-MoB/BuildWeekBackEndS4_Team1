package it.epicode.entities.travel_documents;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("TravelDocument")
public abstract class TravelDocument extends BaseEntity {
    private boolean valid;

    public TravelDocument() {
        this.valid = true;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "TravelDocument{" + super.toString() +"valid:" + valid + '}';
    }
}
