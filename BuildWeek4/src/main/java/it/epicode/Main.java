package it.epicode;

import it.epicode.dao.JpaTicketDao;
import it.epicode.entities.transport.Bus;

import it.epicode.entities.transport.Journey;
import it.epicode.entities.transport.Travel;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.entities.travel_documents_managment.AuthorizedRetailer;
import it.epicode.entities.travel_documents_managment.VendingMachine;
import it.epicode.enums.Localities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Random rnd = new Random(1234);
        LocalDate date = LocalDate.now();
        //Subscription subscription1 = new Subscription(Frequency.WEEKLY);
        Bus bus1 = new Bus();

        Journey journey1 = new Journey(Localities.BARI, Localities.BRESCIA, LocalTime.of(rnd.nextInt(0,24), rnd.nextInt(0,59), 0 ));

        Travel travel = new Travel(bus1, journey1, LocalDateTime.of(date, journey1.getAverage_time().plusMinutes(20)) );

        VendingMachine ticketMachine1 = new VendingMachine();

        AuthorizedRetailer authorizedRetailer1 = new AuthorizedRetailer();

        ticketMachine1.issueTickets();


        System.out.println(ticketMachine1.getIssuedTickets());
        System.out.println(ticketMachine1.getIssuedSubscription());
        System.out.println(authorizedRetailer1.getIssuedTickets());


        System.out.println(bus1);
        //System.out.println(subscription1);
        System.out.println(journey1);
        System.out.println(travel);

        try (var ticket = new JpaTicketDao(); // dao per gli eventi
            ) // dao per le locations
        {
            Ticket ticket1  = new Ticket();
            ticket.save(ticket1);
        } catch (Exception e) {
            log.error("Exception in main()", e);
        }
    }
}