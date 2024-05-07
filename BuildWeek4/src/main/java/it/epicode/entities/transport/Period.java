package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class Period {
    private LocalDateTime start_date;
    private LocalDateTime end_date;

    public Period(LocalDateTime start_date, LocalDateTime end_date) {
        this.start_date = start_date;
        this.end_date = end_date;
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

    @Override
    public String toString() {
        return "Period{" + "start_date=" + start_date + ", end_date=" + end_date + '}';
    }
}
