package it.epicode.entities.constants;

public class Tables {
    public static class Names {
        public static final String USER = "user";
        public static final String CARD = "card";
        public static final String TRAVEL_DOCUMENT_MANAGER = "travel_document_manager";
        public static final String VENDING_MACHINE = "vending_machine";
        public static final String AUTHORIZED_RETAILER = "authorized_retailer";
        public static final String SUBSCRIPTION = "subscription";
        public static final String TICKET = "ticket";
        public static final String TRAVEL_DOCUMENT = "travel_document";
        public static final String TRANSPORT = "transport";
        public static final String BUS = "bus";
        public static final String TRAM = "tram";
        public static final String PERIOD = "period";
        public static final String JOURNEY = "journey";
        public static final String TRAVEL = "travel";
    }

    public static class Columns {
        public static final String DISCRIMINATOR = "data_type";
    }

    public static class Discriminators {
        public static final String TICKET = "T";
        public static final String SUBSCRIPTION = "S";
        public static final String AUTHORIZED_RETAILER = "A";
        public static final String VENDING_MACHINE = "V";
        public static final String BUS = "B";
        public static final String TRAM = "T";
    }

    public static class Capacity {
        public static final int BUS_CAPACITY = 55;
        public static final int TRAM_CAPACITY = 70;
    }
}
