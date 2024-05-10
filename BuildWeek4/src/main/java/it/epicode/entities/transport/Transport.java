package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.STRING)
public abstract class Transport extends BaseEntity implements Serializable {
    private int capacity;
    private LocalDateTime inServiceSince;
    protected LocalDateTime underMaintenanceSince;

    @OneToOne(mappedBy = "transport")
    private ValidateTicket validateTicket;

    public Transport() {
    }

    public Transport(int capacity) {
        this.capacity = capacity;
        this.inServiceSince = LocalDateTime.now();
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
