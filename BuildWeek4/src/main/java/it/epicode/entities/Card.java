package it.epicode.entities;

import it.epicode.entities.constants.Tables;
import it.epicode.entities.travel_documents.Subscription;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = Tables.Names.CARD)
public class Card extends BaseEntity {
    private LocalDate expiration_date;
    private boolean valid;


    @OneToOne
    @JoinColumn(name = "user_id" )
    private User user;

    @OneToOne(mappedBy = "card")
    private Subscription subscription;

    public Card(){}


    public Card(User user) {
        this.expiration_date = LocalDate.now().plusDays(365);
        this.user = user;
        this.subscription = null;
        this.valid = true;
    }


    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public boolean isValid() {
        this.setValid(!(this.getExpiration_date().isAfter(LocalDate.now())));
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
