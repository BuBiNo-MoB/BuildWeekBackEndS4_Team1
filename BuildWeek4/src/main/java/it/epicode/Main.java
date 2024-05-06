package it.epicode;

import it.epicode.entities.Subscription;
import it.epicode.entities.Ticket;
import it.epicode.enums.Frequency;

public class Main {
    public static void main(String[] args) {
        Subscription subscription1 = new Subscription(Frequency.WEEKLY);

        System.out.println(subscription1);
    }
}