package it.epicode.entities.transport;

import it.epicode.entities.BaseEntity;
import it.epicode.entities.constants.Tables;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = Tables.Names.TRAVEL)
public class Travel extends BaseEntity {
    // UN VIAGGIO è FATTO DA UN MEZZO SU UNA TRATTA SPECIFICA
    // UN MEZZO PUO FARE TANTI VIAGGI QUINDI TANTI VIAGGI POSSONO ESSERE FATTI DA UN MEZZO
        @ManyToOne
        @JoinColumn(name = "transport_id")
        private Transport transport;
    // PIU VIAGGI POSSONO ESSERE FATTI SULLA STESSA TRATTA INVECE UNA TRATTA PUO AVERE PIU VIAGGI
        @ManyToOne
        @JoinColumn(name = "journey_id")
        private Journey journey;
        //DATA DI INIZIO TRATTA CHE VIENE MESSA A NOW NELL'ISTANZA
        private LocalDateTime departure;

        //DATA ARRIVO è DATA DALLA MEDIA DI PERCORRENZA PIU O MENO UN NUMERO CASUALE
        private LocalDateTime arrival;

        public Travel(){}

        public Travel(Transport transport, Journey journey, LocalDateTime arrival) {
            this.transport = transport;
            this.journey = journey;
            this.departure = LocalDateTime.now();
            this.arrival = arrival;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }


    @Override
    public String toString() {
        return "Travel{" + super.toString() + "transport=" + transport + ", journey=" + journey + ", departure=" + departure + ", arrival=" + arrival + '}';
    }
}
