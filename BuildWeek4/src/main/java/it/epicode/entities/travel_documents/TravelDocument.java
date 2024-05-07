package it.epicode.entities.travel_documents;

import it.epicode.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
