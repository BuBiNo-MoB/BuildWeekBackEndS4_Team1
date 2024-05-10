package it.epicode.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private long id;
    private LocalDate insertedAt = LocalDate.now();

    public BaseEntity() {
    }

    public long getId() {
        return id;
    }

    public LocalDate getInsertedAt() {
        return insertedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInsertedAt(LocalDate insertedAt) {
        this.insertedAt = insertedAt;
    }

    @Override
    public String toString() {
        return "BaseEntity{" + "id:" + id + ", insertedAt:" + insertedAt + '}';
    }
}
