package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.STRING)
public abstract class Transport extends BaseEntity {
    private int capacity;
    private LocalDateTime inServiceSince;
    protected LocalDateTime underMaintenanceSince;

    @ElementCollection
    List<Period> inServicePeriod = new ArrayList<>();
    @ElementCollection
    List<Period> underMaintenancePeriod  = new ArrayList<>();
    @ElementCollection
    List<ValidateTicket> ValidatedTicket  = new ArrayList<>();


    public Transport() {
    }

    public Transport(int capacity) {
        this.capacity = capacity;
        this.inServiceSince = LocalDateTime.now(); //VA BENE COSI OPPURE FARE LOCALEDATE SOLAMENTE?
        this.underMaintenanceSince = null;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
        return "Transport{" + super.toString() + " capacity:" + capacity + ", inServiceSince:" + inServiceSince + ", underMaintenanceSince:" + underMaintenanceSince + '}';
    }
}
