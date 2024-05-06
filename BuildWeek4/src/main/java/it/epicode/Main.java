package it.epicode;

import it.epicode.entities.transport.Bus;

import it.epicode.entities.transport.Journey;
import it.epicode.entities.transport.Travel;
import it.epicode.entities.travel_documents.Subscription;
import it.epicode.entities.travel_documents_managment.TicketMachine;
import it.epicode.enums.Frequency;
import it.epicode.enums.Localities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random(1234);
        LocalDate date = LocalDate.now();
        //Subscription subscription1 = new Subscription(Frequency.WEEKLY);
        Bus bus1 = new Bus();

        Journey journey1 = new Journey(Localities.BARI, Localities.BRESCIA, LocalTime.of(rnd.nextInt(0,24), rnd.nextInt(0,59), 0 ));

        Travel travel = new Travel(bus1, journey1, LocalDateTime.of(date, journey1.getAverage_time().plusMinutes(20)) );

        TicketMachine ticketMachine1 = new TicketMachine();

        ticketMachine1.issueTickets();


        System.out.println(ticketMachine1.getIssuedTickets());
        System.out.println(ticketMachine1.getIssuedSubscription());


        System.out.println(bus1);
        //System.out.println(subscription1);
        System.out.println(journey1);
        System.out.println(travel);
    }
}