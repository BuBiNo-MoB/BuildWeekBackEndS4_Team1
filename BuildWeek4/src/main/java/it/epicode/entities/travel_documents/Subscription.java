package it.epicode.entities.travel_documents;

import it.epicode.entities.Card;
import it.epicode.entities.constants.Tables;
import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;
import it.epicode.enums.Frequency;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = Tables.Names.SUBSCRIPTION)
@DiscriminatorValue(Tables.Discriminators.SUBSCRIPTION)
//@NamedQuery(name="issuedSusbscriptionInThisPeriod", query="SELECT s FROM Subscription s WHERE s.insertedAt BETWEEN :startDate AND :endDate")
public class Subscription extends TravelDocumento {
    @Enumerated(EnumType.STRING)
    private Frequency frequency;
    private LocalDate emission_date;
    private LocalDate expiration_date;

    @OneToOne
    @JoinColumn(name = "card_id" )
    private Card card;

    public Subscription() {}

    public Subscription(Frequency frequency, Card card, TravelDocumentsManager emittedBy) {
        super(emittedBy);
        this.emission_date = LocalDate.now();
        this.frequency = frequency;
        if (frequency == Frequency.MONTHLY) {
        this.expiration_date = this.emission_date.plusDays(30);
        }else {
        this.expiration_date = this.emission_date.plusDays(7);
        }
        this.card = card;
    }

    public LocalDate getEmission_date() {
        return emission_date;
    }

    public void setEmission_date(LocalDate emission_date) {
        this.emission_date = emission_date;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }


    @Override
    public String toString() {
        return "Subscription{" + super.toString() + " Frequency:" + frequency +"}";
    }
}
