package it.epicode.entities;

import it.epicode.entities.travel_documents.Subscription;

import java.time.LocalDate;

public class Card extends BaseEntity {
    private LocalDate expiration_date;
    //POTREMMO METTERE UN BOOLEAN VALID PE RSEMPLIFICARCI IL CONTORLLO PERCHE NEL IS VALID METTIAMO IL CONFORNTO E POI NELLE ALTRE CLASSI NON FACIMAO IL CONFORNOT MA PRENDIAMO SOLAMENTE IL MRISULTATO DEL METODO
    //onetoone mappedby
    User user;
    //One to ONE mapped by
    private Subscription subscription;

    public Card(){}

    //PUOI AVERE UNA TESSERA SENZA ABBONAMENTI?
    public Card(User user) {
        this.expiration_date = LocalDate.now().plusDays(365);
        this.subscription = null;
    }

    public Card(User user, Subscription subscription) {
        this.expiration_date = LocalDate.now().plusDays(365);
        this.subscription = subscription;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date() {
        this.expiration_date = getExpiration_date().plusDays(365);
    }
}
