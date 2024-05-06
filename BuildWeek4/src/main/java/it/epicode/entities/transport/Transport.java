package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;

import java.time.LocalDateTime;

public abstract class Transport extends BaseEntity {
    private int capacity;
    private boolean inService;
    private LocalDateTime inServiceSince;
    protected LocalDateTime underMaintenanceSince;

    public Transport(int capacity) {
        this.capacity = capacity;
        this.inService = true;
        this.inServiceSince = LocalDateTime.now(); //VA BENE COSI OPPURE FARE LOCALEDATE SOLAMENTE?
        this.underMaintenanceSince = null;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    public LocalDateTime getInServiceSince() {
        return inServiceSince;
    }

    public void setInServiceSince(LocalDateTime inServiceSince) {
        this.inServiceSince = inServiceSince;
    }

    public LocalDateTime getUnderMaintenanceSince() {
        return underMaintenanceSince;
    }

    public void setUnderMaintenanceSince(LocalDateTime underMaintenanceSince) {
        this.underMaintenanceSince = underMaintenanceSince;
    }

    @Override
    public String toString() {
        return "Transport{" + super.toString() + " capacity:" + capacity + ", inService:" + inService + ", inServiceSince:" + inServiceSince + ", underMaintenanceSince:" + underMaintenanceSince + '}';
    }
}
