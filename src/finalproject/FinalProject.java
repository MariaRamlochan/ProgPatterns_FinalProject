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
       List<Flight> model= retrieveData();
       FlightView view = new FlightView();
       Controller controller = new Controller(model, view);
       Flight flight = new Flight();
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
       
       controller.createFlightsTable(SQL_CREATE_TABLE_FLIGHTS);
       System.out.println("TABLE FLIGHTS CREATED");
       controller.createClientsTable(SQL_CREATE_TABLE_CLIENTS);
       System.out.println("TABLE CLIENTS CREATED");
       controller.createReservedFlightsTable(SQL_CREATE_TABLE_RESERVEDFLIGHTS);
       System.out.println("TABLE RESERVEDFLIGHTS CREATED");
       
       System.out.println("\nView Board");
       model.forEach((fl) -> { flight.addFlight(fl); });
       controller.updateView(Flight.viewBoard());
       
       System.out.println("\nRevome Flight Number 1003");
       flight.removerFlight("1003");
       controller.updateView(Flight.viewBoard());
       
       System.out.println("\nUpdating Flight 1004 to go to Hawaii");
       flight.updateFlightData("1004", "DEST", "Hawaii");
       controller.updateView(Flight.viewBoard());
       
    }
    public static List<Flight> retrieveData()
    { 
     Flight[] listOfStudents = { 
         new Flight("1001", "Boeing 737 Max", "Montreal", "Amsterdam", 555, 204, 1115), 
         new Flight("1002", "Boeing 737", "Toronto", "London", 405, 130, 635),
         new Flight("1003", "Boeing 787 Breamliner", "Montreal", "Doha", 725, 248, 3093),
         new Flight("1004", "Boeing 800", "Toronto", "Guyana", 1200, 168, 721)};
        
     return new ArrayList(Arrays.asList(listOfStudents));  
    } 
}
