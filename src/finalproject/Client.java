package finalproject;

import java.sql.*;
import java.util.*;

/**
 * Class to create a Client
 * Client can Book a seat in a flight. 
 * Client can Cancel a flight. 
 * Client can Search flights by origin, destination, or duration.
 * Client can View the board of flights (all flights accepting reservation)
 * 
 * @author Maria and Nafees
 */
public class Client {

    //Data members
    private int passNumber;
    private String fullName; //full name of the client
    private int contact;    //contact number of the client
    
    //The Connections
    private static Connection clientConn = ClientDBConnection.getInstance();
    private static Connection flightConn = FlightDBConnection.getInstance();
    private static Connection reserveConn = ReserveDBConnection.getInstance();
    Flight flight = new Flight();

    /**
     * Empty constructor
     */
    public Client() {
    }

    /**
     * Constructor with all parameters
     * @param passNumber the passport number of the client
     * @param fullName the full name of the client
     * @param contact the contact of the client
     */
    public Client(int passNumber, String fullName, int contact) {
        this.passNumber = passNumber;
        this.fullName = fullName;
        this.contact = contact;
    }

    /**
     * The method creates a new entry in the Clients table to add a new client to 
     * the list. A true value is returned by the method if the client is 
     * successfully inserted. 
     * @param client a client
     * @return a Boolean value of either true or false
     */
    public boolean addClient(Client client) {
        try (Statement stmt = clientConn.createStatement()) {
            String sql = "INSERT INTO CLIENTS (PASSNUM, FULLNAME, CONTACT) "
                    + "VALUES (" + client.passNumber + ", '" + client.fullName
                    + "',' " + client.contact + "');";
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }

    /**
     * To book a seat  the availability of seats should be checked. If a seat is 
     * available (the value of “available” is greater than 0 in “Flights” table), 
     * the table should be updated and the value of available should be decreased 
     * by one. A new entry in “ReservedFlights” table is added. The method return's
     * true if the flight was successfully booked.
     * @param flightNum the flight number
     * @return a Boolean value of either true or false
     */
    public boolean bookASeat(String flightNum) {
    
          try (Statement stmt = flightConn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM FLIGHTS "
                    + "WHERE FLIGHTN= " + flightNum + ";");
            
            while (rs.next()) {
                int availableF = rs.getInt("AVAILABLE");
                
                if (availableF > 0) {
                    availableF--;
                } 
            }
            return true;  
        }
        catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
        }

        return false;
    }

    /**
     * To cancel a reservation, the ticket number should be verified. If an entry 
     * in the ReservedFlights table with the same ticket number exists, then it 
     * should be removed from the table, and the value of “available” in Flights 
     * table will be increased by one. The two methods return true if the flight 
     * was successfully cancelled.
     * @param ticket the ticket number
     * @return a Boolean value of either true or false
     */
    public boolean cancelResservation(int ticket) {
         try (Statement stmt = reserveConn.createStatement()) {
            String sql = "DELETE FROM RESERVEDFLIGHTS WHERE TICKETN=" + ticket + ";";
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }

    /**
     * this method retrieves all data that matches the "destination" and saves it
     * in a List.
     * 
     * @param dest the destination
     * @return a list of flights
     */
    public List<Flight> searchFlightByDest(String dest) {
        List<Flight> flightList = new ArrayList<>();
        Flight destFlight = null;

        try (Statement stmt = flightConn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM FLIGHTS");

            while (rs.next()) {
                String destination = rs.getString("DEST");
                String flightN = rs.getString("FLIGHTN");
                String name = rs.getString("NAME");
                String origin = rs.getString("ORIGIN");
                int duration = rs.getInt("DURATION");
                int amount = rs.getInt("AMOUNT");
                int seats = rs.getInt("SEATS");

                if (destination.equals(dest)) {
                    destFlight = new Flight(flightN, name, origin, destination,
                            duration, seats, amount);

                    flightList.add(destFlight);
                }
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return flightList;
    }

    /**
     * this method retrieves all data that matches the "duration" and saves it
     * in a List.
     * 
     * @param d the duration
     * @return a list of duration
     */
    public List<Flight> searchFlightByDuration(int d) {
        List<Flight> flightList = new ArrayList<>();
        Flight durList;

        try (Statement stmt = flightConn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM FLIGHTS");

            while (rs.next()) {
                String destination = rs.getString("DEST");
                String flightN = rs.getString("FLIGHTN");
                String name = rs.getString("NAME");
                String origin = rs.getString("ORIGIN");
                int duration = rs.getInt("DURATION");
                int amount = rs.getInt("AMOUNT");
                int seats = rs.getInt("SEATS");

                if (duration == d) {
                    durList = new Flight(flightN, name, origin, destination,
                            duration, seats, amount);

                    flightList.add(durList);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return flightList;
    }

    /**
     * this method retrieves all data that matches the "origin" and saves it
     * in a List.
     * 
     * @param ori the origin
     * @return a list of origin
     */
    public List<Flight> searchFlighByOrigin(String ori) {
        List<Flight> flightList = new ArrayList<>();
        Flight oriList;

        try (Statement stmt = flightConn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM FLIGHTS");

            while (rs.next()) {
                String destination = rs.getString("DEST");
                String flightN = rs.getString("FLIGHTN");
                String name = rs.getString("NAME");
                String origin = rs.getString("ORIGIN");
                int duration = rs.getInt("DURATION");
                int amount = rs.getInt("AMOUNT");
                int seats = rs.getInt("SEATS");

                if (origin.equals(ori)) {
                    oriList = new Flight(flightN, name, origin, destination,
                            duration, seats, amount);

                    flightList.add(oriList);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return flightList;
    }

    /**
     * Displays only flights with available seats.
     * @return map
     */
    public Map<String, String> viewFlightsBoard() {
        Map<String, String> map = new HashMap();

        try (Statement stmt = clientConn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVEDFLIGHTS;");

            while (rs.next()) {
                String flightN = rs.getString("FLIGHTN");
                String passNum = rs.getString("PASSNUM");
                String flName = rs.getString("FLNAME");
                int issueDate = rs.getInt("ISSUEDATE");
                int cont = rs.getInt("CONTACT");
                int amount = rs.getInt("AMOUNT");

                map.put(rs.getString("TICKETN"), " FLIGHTN: " + flightN
                        + ", PASSNUM: " + passNum + ", FLNAME: " + flName
                        + ", ISSUEDATE: " + issueDate + ", CONTACT: " + cont
                        + ", AMOUNT: " + amount + "\n");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return map;
    }

    /**
     * getter method for  fullName
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * setter method for fullName
     * @param fullName 
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * getter method for passNumber
     * @return passNumber
     */
    public int getPassNumber() {
        return passNumber;
    }

    /**
     * setter method for passNumber
     * @param passNumber 
     */
    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    /**
     * getter method for contact
     * @return 
     */
    public int getContact() {
        return contact;
    }

    /**
     * setter method for contact
     * @param contact 
     */
    public void setContact(int contact) {
        this.contact = contact;
    }
}
