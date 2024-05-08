package it.epicode;

import it.epicode.dao.implementation.JpaTravelDocumentDao;
import it.epicode.entities.User;
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
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Random rnd = new Random(1234);

    private static List<Ticket> randomTicket(int count){
        return LongStream.range(1, count + 1)
                .mapToObj(n -> new Ticket(
                        ))
                .toList();
    }
    public static void main(String[] args) {



        int count= 50;
        try (var travelDocument = new JpaTravelDocumentDao(); // dao per gli eventi
            ) // dao per le locations
        {
            log.info("Creo {} ticket a caso", count);
            List<Ticket> ticketList = randomTicket(count);
            ticketList.forEach(travelDocument::save);
            //var founded = ticket.getById("SELECT t FROM Ticket t WHERE t.id = :id", Ticket.class, 1);
            //log.info("founded element: {}", founded);
            //ticket.deleteById("SELECT t FROM Ticket t WHERE t.id = :id", Ticket.class, 1);
        } catch (Exception e) {
            log.error("Exception in main()", e);
        }
    }
}