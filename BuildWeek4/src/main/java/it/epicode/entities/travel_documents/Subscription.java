package it.epicode.entities.travel_documents;

import it.epicode.entities.Card;
import it.epicode.entities.User;
import it.epicode.enums.Frequency;

public class Subscription extends TravelDocument {
    Frequency frequency;

    //OneToMany
    private User user;

    //ManyToOne
    private Card card;

    public Subscription() {}

    public Subscription(Frequency frequency) {
        super();
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Subscription{" + "Id:"+ getId() + " Created At:" + getInsertedAt() + " Valid:" + isValid() + " Frequency:" + frequency +"}";
    }
}
