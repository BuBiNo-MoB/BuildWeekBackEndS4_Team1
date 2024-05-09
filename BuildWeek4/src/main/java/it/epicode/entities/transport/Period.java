package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import it.epicode.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = Tables.Names.PERIOD)
public class Period extends BaseEntity {
    private LocalDateTime start_date;
    private LocalDateTime end_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Period(LocalDateTime start_date, LocalDateTime end_date, Transport transport, Status status) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.transport = transport;
        this.status = status;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Period{" + "start_date=" + start_date + ", end_date=" + end_date + '}';
    }
}
