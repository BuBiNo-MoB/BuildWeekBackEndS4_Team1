package it.epicode.entities;

import it.epicode.entities.travel_documents.Subscription;

import java.time.LocalDate;

public class Card extends BaseEntity {
    private LocalDate expiration_date;
    //onetoone mappedby
    User user;
    //One to many mapped by
    private Subscription subscription;
    public Card() {
        this.expiration_date = LocalDate.now().plusDays(365);
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date() {
        this.expiration_date = getExpiration_date().plusDays(365);
    }
}
