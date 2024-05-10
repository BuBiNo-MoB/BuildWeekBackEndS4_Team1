package it.epicode;

import it.epicode.dao.implementation.*;
import it.epicode.entities.Card;
import it.epicode.entities.User;
import it.epicode.entities.transport.*;

import it.epicode.entities.travel_documents.Subscription;
import it.epicode.entities.travel_documents.Ticket;
import it.epicode.entities.travel_documents.TravelDocumento;
import it.epicode.entities.travel_documents_managment.AuthorizedRetailer;
import it.epicode.entities.travel_documents_managment.TravelDocumentsManager;
import it.epicode.entities.travel_documents_managment.VendingMachine;
import it.epicode.enums.Frequency;
import it.epicode.enums.Localities;
import jdk.swing.interop.SwingInterOpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.LongStream;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Random rnd = new Random(1234);

    private static List<User> randomUser(int count) {
        return LongStream.range(1, count + 1)
                .mapToObj(n -> new User(
                        String.format("First Name %d", n),
                        String.format("Last Name %d", n)
                ))
                .toList();
    }

    private static List<Card> randomCard(int count, List<User> userList) {
        List<User> usedUser = new ArrayList<>();
        return LongStream.range(1, count + 1)
                .mapToObj(n -> {
                    User randomUser;
                            do {
                                randomUser = userList.get(rnd.nextInt(userList.size())); // Scegli un utente casuale dalla lista
                            } while (usedUser.contains(randomUser));// Continua finché l'utente scelto è già stato assegnato
                    usedUser.add(randomUser);
                           return new Card(randomUser);
                })
                .toList();
    }

    private static List<Ticket> randomTicket(int count, List<TravelDocumentsManager> travelDocumentsManagerList) {
        return LongStream.range(1, count + 1)
                .mapToObj(n -> {
                    //VERIFICO CHE LA MACHINE O L AUTHOR SIA VALIDO
                    var travelDocumentManager = travelDocumentsManagerList.get(rnd.nextInt(travelDocumentsManagerList.size()));
                    if (travelDocumentManager instanceof VendingMachine && ((VendingMachine) travelDocumentManager).isActive() || travelDocumentManager instanceof  AuthorizedRetailer) {
                        return new Ticket(travelDocumentManager);
                    } else {
                        log.warn("Ticket cannot be issued to inactive vending machine");
                        return null; // Ritorno null per indicare che non viene creato alcun biglietto
                    }
                })
                .filter(Objects::nonNull) // Rimuove eventuali biglietti null dalla lista
                .toList(); // Converte lo stream in una lista
    }

    private static List<Subscription> randomSubscription(int count, List<TravelDocumentsManager> travelDocumentsManagerList, List<Card> cardList) {
        List<Card> usedCard = new ArrayList<>();
        return LongStream.range(1, count + 1)
                .mapToObj(n ->
                {
                    Card randomCard;
                    var travelDocumentManager = travelDocumentsManagerList.get(rnd.nextInt(travelDocumentsManagerList.size()));
                    do {
                        randomCard = cardList.get(rnd.nextInt(cardList.size()));
                    } while (usedCard.contains(randomCard) && randomCard.getExpiration_date().isAfter(LocalDate.now()));
                    usedCard.add(randomCard);
                    //VERIFICO CHE LA MACHINE O L AUTHOR SIA VALIDO
                    if (travelDocumentManager instanceof VendingMachine && ((VendingMachine) travelDocumentManager).isActive() || travelDocumentManager instanceof  AuthorizedRetailer) {
                        return new Subscription(Frequency.values()[rnd.nextInt(2)], randomCard, travelDocumentManager);
                    }else {
                        log.warn("Subscription cannot be issued to inactive vending machine");
                        return null; // Ritorno null per indicare che non viene creato alcuna subscription
                    }
                })
                .filter(Objects::nonNull)
                .toList();
    }

    private static List<VendingMachine> randomVendingMachine(int count){
        return LongStream.range(1, count + 1)
                .mapToObj(n -> new VendingMachine())
                .toList();
    }

    private static List<AuthorizedRetailer> randomAuthorizedRetailer(int count){
        return LongStream.range(1, count + 1)
                .mapToObj(n -> new AuthorizedRetailer() )
                .toList();
    }

    private static List<Bus> randomBus(int count){
        return LongStream.range(1, count + 1)
                .mapToObj(n -> new Bus() )
                .toList();
    }

    private static List<Tram> randomTram(int count){
        return LongStream.range(1, count + 1)
                .mapToObj(n -> new Tram() )
                .toList();
    }

    private static List<Journey> randomJourney(int count){
        return LongStream.range(1, count + 1)
                .mapToObj(n -> {
                    Localities start = Localities.values()[rnd.nextInt(19)];
                    Localities end;

                    do {
                        end = Localities.values()[rnd.nextInt(19)];
                    } while (end == start);
                    return new Journey(
                            start,
                            end,
                            LocalTime.of(rnd.nextInt(23), rnd.nextInt(59), rnd.nextInt(59))
                    );
                })
                .toList();
    }


    private static List<ValidateTicket> randomValidateTicket(int count, List<Transport> transportList, List<Ticket> ticketList){
        List<Ticket> usedTicket = new ArrayList<>();
        List<Transport> usedTransport = new ArrayList<>();
        return LongStream.range(1, count + 1)
                .mapToObj(n ->
                {
                    Ticket randomTicket;
                    Transport randomTransport;

                    do {
                        randomTicket = ticketList.get(rnd.nextInt(ticketList.size())); // Scegli un ticket casuale dalla lista
                    } while (usedTicket.contains(randomTicket)); // Continua finché il ticket scelto è già stato assegnato

                    do {
                        randomTransport = transportList.get(rnd.nextInt(transportList.size())); // Scegli un mezzo casuale dalla lista
                    } while (usedTransport.contains(randomTransport)); // Continua finché il mezzo scelto è già stato assegnato

                    usedTicket.add(randomTicket);
                    usedTransport.add(randomTransport);

                    return new ValidateTicket(randomTransport, randomTicket);
                })
                .toList();
    }

    private static List<Travel> randomTravel(int count, List<Transport> transportList, List<Journey> journeyList ){
        List<Ticket> usedTicket = new ArrayList<>();
        LocalDate now = LocalDate.now();
        return LongStream.range(1, count + 1)
                .mapToObj(n ->
                {
                    var randomJourney = journeyList.get(rnd.nextInt(journeyList.size()));
                    var randomValidTransport = transportList.get(rnd.nextInt(transportList.size()));
                    LocalTime time = randomJourney.getAverage_time().plusMinutes(30);
                    //SE LA DATA DI INIZIO MANUTENZIONE è NULL SIGNIFICA CHE è IN SERVIZIO
                    if (randomValidTransport.getUnderMaintenanceSince() == null) {
                        return new Travel(randomValidTransport, randomJourney, LocalDateTime.of(now, time));
                    }else {
                            log.warn("Travel cannot be issued due to transport under manteinance");
                            return null; // Ritorno null per indicare che non viene creato alcuna subscription
                        }
                    })
                .filter(Objects::nonNull)
                .toList();
    }

    public static void main(String[] args) {

        int count= 25;
        int count_TravelDocumentManager = 10;
        try (var travelDocumentDao = new JpaTravelDocumentDao();
             var travelDocumentsManagerDao = new JpaTravelDocumentManagerDao();
             var userDao = new JpaUserDao();
             var cardDao = new JpaCardDao();
             var transportDao = new JpaTransportDao();
             var journeyDao = new JpaJourneyDao();
             var validateTicketDao = new JpaValidateTicketDao();
             var travelDao = new JpaTravelDao();
             )

        {

            log.info("Creo {} vendingMachine a caso", count_TravelDocumentManager);
            //CREO UNA LISTA DI VENDING MACHINE
            List<VendingMachine> TravelDocumentManagerV = randomVendingMachine(count_TravelDocumentManager);
            //LE SALVO
            TravelDocumentManagerV.forEach(travelDocumentsManagerDao::save);

            var v1 = TravelDocumentManagerV.get(5);
            v1.setActive(false);
            travelDocumentsManagerDao.save(v1);

            log.info("Creo {} authorizedRetailer a caso", count_TravelDocumentManager);
            //CREO UNA LISTA DI AUTHORIZED RETAILER
            List<AuthorizedRetailer> TravelDocumentManagerA = randomAuthorizedRetailer(count_TravelDocumentManager);
            //LI SALVO
            TravelDocumentManagerA.forEach(travelDocumentsManagerDao::save);

            //CREO UNA LISTA COMUNE DI VENDING MACHINE E AUTHORIZED RETAILER
            List<TravelDocumentsManager> TravelDocumentsManagerList = new ArrayList<>();
            TravelDocumentsManagerList.addAll(TravelDocumentManagerV);
            TravelDocumentsManagerList.addAll(TravelDocumentManagerA);


            log.info("Creo {} ticket a caso", count);

            //CREO UNA LISTA DI BIGLIETTI EMESSI DA UNA VENDING MACHINE CASUALE
            List<Ticket> ticketListV = randomTicket(count, TravelDocumentsManagerList);
            //LA SALVO
            ticketListV.forEach(travelDocumentDao::save);



            log.info("Creo {} user a caso", count);
            //CREO UNA LISTA DI USER
            List<User> userList = randomUser(count);
            //LA SALVO
            userList.forEach(userDao::save);

            log.info("Creo {} card a caso", count);
            //CREO UNA LISTA DI CARD
            List<Card> cardList = randomCard(count, userList);
            //LA SALVO
            cardList.forEach(cardDao::save);


            log.info("Creo {} subscription a caso", count);
            //CREO UNA LISTA DI SUBSCRIPTION
            List<Subscription> subscriptionList = randomSubscription(count, TravelDocumentsManagerList, cardList);
            //LA SALVO
            subscriptionList.forEach(travelDocumentDao::save);

            log.info("Creo {} bus a caso", count);
            //CREO UNA LISTA DI BUS
            List<Bus> busList = randomBus(count);
            //LA SALVO
            busList.forEach(transportDao::save);

            log.info("Creo {} tram a caso", count);
            //CREO UNA LISTA DI TRAM
            List<Tram> tramList = randomTram(count);
            //LA SALVO
            tramList.forEach(transportDao::save);


            //CREO UNA LISTA COMUNE DI TRANSPORT MACHINE E AUTHORIZED RETAILER
            List<Transport> transportList = new ArrayList<>();
            transportList.addAll(busList);
            transportList.addAll(tramList);
            Optional<Transport> foundedElement = transportDao.getById(40);

            foundedElement.ifPresentOrElse(
                    item -> {
                        log.info("Questo è l'elemento trovato: {}", item);
                        transportDao.underMaintenanceStart(item);
                        log.info("questo è l'oggetto iniziata la manutenzione {}", item);

                        //transportDao.underMaintenanceEnd(item);
                        log.info("questo è l'oggetto finita la manutenzione {}", item);
                        log.info("Elimino l'oggetto");
                                transportDao.delete(item);
                        transportDao.getById(5).ifPresentOrElse(
                                i -> log.warn("L'elemento dovrebbe essere sttaoe liminato"),
                                () -> log.info("L'elemento non c'è perchè è stato eliminato")
                        );
                    },
                    () -> log.warn("L'elemento è stato eliminato")
            );

            log.info("Creo {} journey a caso", count);
            //CREO UNA LISTA DI JOURNEY
            List<Journey> journeyList = randomJourney(count);
            //LA SALVO
            journeyList.forEach(journeyDao::save);

            cardDao.renew(cardList.get(1));


            log.info("Creo {} validateTicket a caso", count);
            //CREO UNA LISTA DI VALIDATETICKET
            List<ValidateTicket> validateTicket = randomValidateTicket(count, transportList, ticketListV);
            //LA SALVO
            validateTicket.forEach(validateTicketDao::save);

            log.info("Creo {} Travel a caso", count);
            //CREO UNA LISTA DI TRAVEL
            List<Travel> travel = randomTravel(count, transportList,journeyList);
            //LA SALVO
            travel.forEach(travelDao::save);


            //TEST PER CAPIRE UN TARVELDOCUMENTMANAGER QUANTI BIGLIETTI E ABBONAMENTI HA EMESSO IN TOTALE
            System.out.println(travelDocumentDao.searchAllTravelDocumentsEmittedById(5, LocalDate.of(2019,10,2), LocalDate.of(2025,10,2)));
            //TEST PER CAPIRE UN TARVELDOCUMENTMANAGER QUANTI BIGLIETTI HA EMESSO IN TOTALE
            System.out.println(travelDocumentDao.searchTicketEmittedById(5, LocalDate.of(2019,10,2), LocalDate.of(2025,10,2)));
            //TEST PER CAPIRE UN TARVELDOCUMENTMANAGER QUANTI ABBONAMENTI HA EMESSO IN TOTALE
            System.out.println(travelDocumentDao.searchSubscriptionEmittedById(5, LocalDate.of(2019,10,2), LocalDate.of(2025,10,2)));



            //TEST PER VEDERE IL NUMERO DI BIGLIETTI VIDIMATI SU UN PARTICOLARE MEZZO
            System.out.println(validateTicketDao.searchValidateTicketByTransportId(1));
            System.out.println(validateTicketDao.searchValidateTicketByDate(LocalDate.of(2019,10,2), LocalDate.of(2025,10,2)));


            //TEST PER VERIFICARE QUANTE VOLTE è STATA PERCORSA UNA TRATTA DA UN MEZZO
            System.out.println(travelDao.searchAllJourneyByTransport(40,17));
        } catch (Exception e) {
            log.error("Exception in main()", e);
        }
    }
}