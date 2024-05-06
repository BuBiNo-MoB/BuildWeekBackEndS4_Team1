package it.epicode.entities.travel_documents;

import it.epicode.entities.Card;
import it.epicode.entities.User;
import it.epicode.enums.Frequency;

import java.time.LocalDate;

public class Subscription extends TravelDocument {
    private Frequency frequency;

    private LocalDate emission_date;

    private LocalDate expiration_date;

    //GESTIRE MEGLIO LE RELAZIONI TRA SUBSCRIPTION USER E CARD
    //ONE TO ONE
    private Card card;

    public Subscription() {}

    public Subscription(Frequency frequency, Card card) {
        super();
        this.emission_date = LocalDate.now();
        this.frequency = frequency;
        if (frequency == Frequency.MONTHLY) {
        this.expiration_date = this.emission_date.plusDays(30);
        }else {
        this.expiration_date = this.emission_date.plusDays(7);
        }
        this.card = card;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }


    @Override
    public boolean isValid() {
        //CONTROLLARE SE FUNZIONA PER DAVVERO
        super.setValid(!(this.expiration_date.isAfter(this.emission_date)));
        return super.isValid();
    }

    @Override
    public String toString() {
        return "Subscription{" + super.toString() + " Frequency:" + frequency +"}";
    }
}
