package it.epicode.entities.transport;


import it.epicode.entities.constants.Tables;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = Tables.Names.BUS)
public class Bus extends Transport {

    public Bus() {
        super(Tables.Capacity.BUS_CAPACITY);
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() + '}';
    }
}
