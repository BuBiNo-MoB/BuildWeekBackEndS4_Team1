package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import it.epicode.enums.Localities;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = Tables.Names.JOURNEY)
public class Journey extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Localities departure;

    @Enumerated(EnumType.STRING)
    private Localities arrival;

    private LocalTime average_time;


    public Journey(){}

    public Journey(Localities departure, Localities arrival, LocalTime average_time) {
        this.departure = departure;
        this.arrival = arrival;
        this.average_time = average_time;
    }

    public Localities getDeparture() {
        return departure;
    }

    public void setDeparture(Localities departure) {
        this.departure = departure;
    }

    public Localities getArrival() {
        return arrival;
    }

    public void setArrival(Localities arrival) {
        this.arrival = arrival;
    }

    public LocalTime getAverage_time() {
        return average_time;
    }

    public void setAverage_time(LocalTime average_time) {
        this.average_time = average_time;
    }

    @Override
    public String toString() {
        return "Journey{" + super.toString() + "departure=" + departure + ", arrival=" + arrival + ", average_time=" + average_time + '}';
    }
}
