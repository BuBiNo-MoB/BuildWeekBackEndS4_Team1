package it.epicode.entities.transport;

import it.epicode.entities.constants.Tables;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = Tables.Names.TRAM)
public class Tram extends Transport {

    public Tram() {
        super(Tables.Capacity.TRAM_CAPACITY);
    }

    @Override
    public String toString() {
        return "Tram{" + super.toString() + '}';
    }
}
