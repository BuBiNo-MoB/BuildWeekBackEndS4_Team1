package it.epicode.entities.travel_documents_managment;

import it.epicode.entities.BaseEntity;

public class TravelDocumentsManager extends BaseEntity {
    private boolean active;

    public TravelDocumentsManager() {
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "TravelDocumentsManager{" + super.toString() + "active=" + active + '}';
    }
}
