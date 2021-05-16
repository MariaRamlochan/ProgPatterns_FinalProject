package finalproject;

import java.util.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author maria
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Flight> flightModel = retrieveFlightData();
        FlightView flightView = new FlightView();
        FlightController flightController = new FlightController(flightModel, flightView);
        Flight flight = new Flight();

        List<Client> clientModel = retrieveClientData();
        ClientView clientView = new ClientView();
        ClientController clientController = new ClientController(clientModel, clientView);
        Client client = new Client();

        Locale locale = new Locale("", "");
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose between these 2 Languages:\n"
                + "press '1' for english\n"
                + "press '2' for french\n");

        switch (sc.nextInt()) {
            case 1:
                locale = new Locale("en", "CA");
                break;
            case 2:
                locale = new Locale("fr", "CA");
                break;
            default:
                System.out.println("Invalid choice\nDefaulted to Canada, English\n");
        }

        ResourceBundle res = ResourceBundle.getBundle("finalproject/file", locale);

        String SQL_CREATE_TABLE_FLIGHTS = "CREATE TABLE FLIGHTS "
                + "(FLIGHTN TEXT PRIMARY KEY      NOT NULL,"
                + " NAME                     TEXT NOT NULL,"
                + " ORIGIN                   TEXT NOT NULL,"
                + " DEST                     TEXT NOT NULL,"
                + " DURATION                  INT NOT NULL,"
                + " SEATS                     INT NOT NULL,"
                + " AVAILABLE                 INT NOT NULL,"
                + " AMOUNT                    INT NOT NULL)";

        String SQL_CREATE_TABLE_CLIENTS = "CREATE TABLE CLIENTS "
                + "(PASSNUM INT PRIMARY KEY       NOT NULL,"
                + " FULLNAME                 TEXT NOT NULL,"
                + " CONTACT                   INT NOT NULL)";

        String SQL_CREATE_TABLE_RESERVEDFLIGHTS = "CREATE TABLE RESERVEDFLIGHTS "
                + "(TICKETN INT PRIMARY KEY       ,"
                + " FLIGHTN                  TEXT NOT NULL,"
                + " PASSNUM                   INT NOT NULL,"
                + " FLNAME                   TEXT NOT NULL,"
                + " ISSUEDATE                DATE NOT NULL,"
                + " CONTACT                   INT NOT NULL,"
                + " AMOUNT                    INT NOT NULL,"
                + " CONSTRAINT FK_RESERVE_FLIGHN FOREIGN KEY(FLIGHTN)"
                + " REFERENCES FLIGHTS(FLIGHTN),"
                + " CONSTRAINT FK_RESERVE_PASSNUM FOREIGN KEY(PASSNUM)"
                + " REFERENCES CLIENTS(PASSNUM))";

        flightController.createFlightsTable(SQL_CREATE_TABLE_FLIGHTS);
        System.out.println("\nTABLE RESERVEDFLIGHTS FLIGHTS");
        System.out.println("\n" + res.getString("key1"));
        clientController.createClientsTable(SQL_CREATE_TABLE_CLIENTS);
        System.out.println("\nTABLE RESERVEDFLIGHTS CLIENTS");
        System.out.println("\n" + res.getString("key2"));
        flightController.createReservedFlightsTable(SQL_CREATE_TABLE_RESERVEDFLIGHTS);
        System.out.println("\nTABLE RESERVEDFLIGHTS CREATED");
        System.out.println("\n" + res.getString("key3"));

        //view board
        System.out.println("\nView Board");
        System.out.println("\n" + res.getString("key4"));
        flightModel.forEach((fl) -> {
            flight.addFlight(fl);
        });
        flightController.updateView(Flight.viewBoard());

        //remove flight information
        System.out.println("\nremove flight number 1003");
        System.out.println("\n" + res.getString("key5") + " 1003");
        flight.removerFlight("1003");
        flightController.updateView(Flight.viewBoard());

        //updating flight information
        System.out.println("\nupdating flight to go to Hawaii");
        System.out.println("\n" + res.getString("key6") + " 1004 " + res.getString("key7") + " Hawaii");
        flight.updateFlightData("1004", "DEST", "Hawaii");
        flightController.updateView(Flight.viewBoard());

        //view the client table
        System.out.println("\nview the client table");
        System.out.println("\n" + res.getString("key8"));
        clientModel.forEach((cl) -> { client.addClient(cl); });
        clientController.updateView(Client.viewBoard());

        //issues ticket
        System.out.println("\nTrying to issue a ticket");
        System.out.println("\n" + res.getString("key9"));
        clientModel.forEach((cl) -> { if (cl.getPassNumber() == 5001) flight.issueTicket(cl, "1004"); });
        flightController.updateView(Flight.viewBookedFlights());
        
        //System.out.println("\n" + res.getString("key9"));
        clientModel.forEach((cl) -> { if (cl.getPassNumber() == 5002) flight.issueTicket(cl, "1002"); });
        flightController.updateView(Flight.viewBookedFlights());
        
        //Book a flight
        System.out.println("\nBooking a flight");
        clientModel.forEach((cl) -> { if (cl.getPassNumber() == 5003) client.bookASeat("1004"); });
        flightController.updateView(Flight.viewBookedFlights());
        
        //System.out.println("\n" + res.getString("key9"));
        clientModel.forEach((cl) -> { if (cl.getPassNumber() == 5004) client.bookASeat("1002"); });
        flightController.updateView(Flight.viewBookedFlights());
        
        //Cancel flight (Flight class)
        System.out.println("\nCancel flight");
        //System.out.println("\n" + res.getString("key5") + " 1003");
        flight.cancelFlight(1, 5003);
        flightController.updateView(Flight.viewBookedFlights());
        
        //Cancel Reservation (Client class)
        System.out.println("\nCancel Reservation");
        client.cancelResservation(2);
        clientController.updateView(Flight.viewBookedFlights());
        
        //searching by destination
        System.out.println("\n" + res.getString("key10"));
        client.searchFlightByDest("Hawaii").forEach(dest
                -> {
            System.out.println(dest.toString());
        });

        //searching by duration
        System.out.println("\n" + res.getString("key11"));
        client.searchFlightByDuration(405).forEach(dur
                -> {
            System.out.println(dur.toString());
        });

        //searching by origin
        System.out.println("\n" + res.getString("key12"));
        client.searchFlighByOrigin("Toronto").forEach(ori
                -> {
            System.out.println(ori.toString());
        });
        
        //view flight board
    }

    /**
     * this method retrieve the data of the flight
     *
     * @return an ArrayList
     */
    public static List<Flight> retrieveFlightData() {
        Flight[] listOfFlights = {
            new Flight("1001", "Boeing 737 Max", "Montreal", "Amsterdam", 555, 204, 1115),
            new Flight("1002", "Boeing 737", "Toronto", "London", 405, 130, 635),
            new Flight("1003", "Boeing 787 Breamliner", "Montreal", "Doha", 725, 248, 3093),
            new Flight("1004", "Boeing 800", "Toronto", "Guyana", 1200, 168, 721)};

        return new ArrayList(Arrays.asList(listOfFlights));
    }

    /**
     * this method retrieve the data of the clients
     *
     * @return an ArrayList
     */
    public static List<Client> retrieveClientData() {
        Client[] listOfClients = {
            new Client(5001, "Maria R", 911),
            new Client(5002, "Natsu B", 666),
            new Client(5003, "Damon S", 999),
            new Client(5004, "Mark I", 555)};

        return new ArrayList(Arrays.asList(listOfClients));
    }
}
