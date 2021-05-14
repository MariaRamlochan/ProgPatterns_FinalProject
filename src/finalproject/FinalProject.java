package finalproject;

import java.util.*;

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
                    + "(TICKETN INT PRIMARY KEY       NOT NULL,"
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
       System.out.println("TABLE FLIGHTS CREATED");
       clientController.createClientsTable(SQL_CREATE_TABLE_CLIENTS);
       System.out.println("TABLE CLIENTS CREATED");
       flightController.createReservedFlightsTable(SQL_CREATE_TABLE_RESERVEDFLIGHTS);
       System.out.println("TABLE RESERVEDFLIGHTS CREATED");
       
       System.out.println("\nView Board");
       flightModel.forEach((fl) -> { flight.addFlight(fl); });
       flightController.updateView(Flight.viewBoard());
       
       System.out.println("\nRevome Flight Number 1003");
       flight.removerFlight("1003");
       flightController.updateView(Flight.viewBoard());
       
       System.out.println("\nUpdating Flight 1004 to go to Hawaii");
       flight.updateFlightData("1004", "DEST", "Hawaii");
       flightController.updateView(Flight.viewBoard());
       
       System.out.println("\nView Client table");
       clientModel.forEach((cl) -> { client.addClient(cl); });
       clientController.updateView(Client.viewBoard());
       
       System.out.println("\nTrying to issue a ticket");
       clientModel.forEach((cl) -> { flight.issueTicket(cl, "1001"); });
       flightController.updateView(Flight.viewBookedFlights());
       
    }
    public static List<Flight> retrieveFlightData()
    { 
     Flight[] listOfFlights = { 
         new Flight("1001", "Boeing 737 Max", "Montreal", "Amsterdam", 555, 204, 1115), 
         new Flight("1002", "Boeing 737", "Toronto", "London", 405, 130, 635),
         new Flight("1003", "Boeing 787 Breamliner", "Montreal", "Doha", 725, 248, 3093),
         new Flight("1004", "Boeing 800", "Toronto", "Guyana", 1200, 168, 721)};
        
     return new ArrayList(Arrays.asList(listOfFlights));  
    } 
    
    public static List<Client> retrieveClientData()
    { 
     Client[] listOfClients = { 
         new Client(5001, "Maria R", 911), 
         new Client(5002, "Natsu B", 666),
         new Client(5003, "Damon S", 999),
         new Client(5004, "Mark I", 555)};
        
     return new ArrayList(Arrays.asList(listOfClients));  
    }
}
