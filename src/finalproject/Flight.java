package finalproject;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author maria
 */
public class Flight {

    //Data members
    private String flightN;
    private String name;
    private String origin;
    private String dest;
    private double duration;
    private int seats;
    private int available;
    private double amount;
    private static Connection flightConn = FlightDBConnection.getInstance();
    private static Connection reserveConn = ReserveDBConnection.getInstance();

    /**
     * Empty Constructor
     */
    public Flight() {
    }

    /**
     * Constructor with all data members as parameters
     *
     * @param flightN the flight number
     * @param name the flight's name
     * @param origin the flight's origin
     * @param dest the flight's destination
     * @param duration the flight's duration
     * @param seats the number of seats in the flight
     * @param amount the amount the flight cost
     */
    public Flight(String flightN, String name, String origin, String dest,
            double duration, int seats, double amount) {
        this.flightN = flightN;
        this.name = name;
        this.origin = origin;
        this.dest = dest;
        this.duration = duration;
        this.seats = seats;
        this.amount = amount;
    }

    /**
     * The method creates a new entry in the Flights table to add a new flight
     * to the board, sets “available” to the same value as “seats“. A true value
     * is returned by the method if the flight is successfully inserted.
     *
     * @param flight
     * @return true or false
     */
    public boolean addFlight(Flight flight) {
        flight.available = flight.seats;
        try (Statement stmt = flightConn.createStatement()) {
            String sql = "INSERT INTO FLIGHTS (FLIGHTN, NAME, ORIGIN, DEST, "
                    + "DURATION, SEATS, AVAILABLE, AMOUNT) "
                    + "VALUES (" + flight.flightN + ", '" + flight.name + "', '"
                    + flight.origin + "', '" + flight.dest + "', '"
                    + flight.duration + "', '" + flight.seats + "', '"
                    + flight.available + "', '" + flight.amount + "');";
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }

    /**
     * The record with the flight number given as parameter is removed from the
     * Flights table. A true value is returned by the method if the flight is
     * successfully removed.
     *
     * @param flightN
     * @return true or false
     */
    public boolean removerFlight(String flightN) {
        try (Statement stmt = flightConn.createStatement()) {
            String sql = "DELETE FROM FLIGHTS WHERE FLIGHTN=" + flightN + ";";
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }

    /**
     * Change the value of any attribute of a record with the same flight number
     * in the Flights table. This method allows the manager to change the value
     * of the flight origin, its destination, or duration. A true value is
     * returned by the method if the update was successful.
     *
     * @param flightN
     * @param field
     * @param newValue
     * @return true or false
     */
    public boolean updateFlightData(String flightN, String field, String newValue) {
        try (Statement stmt = flightConn.createStatement()) {
            String sql = "UPDATE FLIGHTS SET " + field + "= " + "'" + newValue + "'"
                    + " WHERE FLIGHTN= " + flightN + ";";
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }

    /**
     * To issue a ticket number or book a seat the availability of seats should
     * be checked.If a seat is available (the value of “available” is greater
     * than 0 in “Flights” table), the table should be updated and the value of
     * available should be decreased by one. A new entry in “ReservedFlights”
     * table is added. The two methods return true if the flight was
     * successfully booked.
     *
     * @param c
     * @param flight
     * @return true or false
     */
    public boolean issueTicket(Client c, String flight) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        
        try (Statement stmt = flightConn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM FLIGHTS "
                    + "WHERE FLIGHTN= " + flight + ";");

            while (rs.next()) {
                String flightNF = rs.getString("FLIGHTN");
                int availableF = rs.getInt("AVAILABLE");
                int amountF = rs.getInt("AMOUNT");
                
                if (availableF > 0) {
                    try (Statement stmt2 = reserveConn.createStatement()) {
                        String sql2 = "INSERT INTO RESERVEDFLIGHTS (FLIGHTN, "
                                + "PASSNUM, FLNAME, ISSUEDATE, CONTACT, AMOUNT) "
                                + "VALUES ('" +  flightNF + "', '"
                                + c.getPassNumber() + "',' " + c.getFullName() + "', '"
                                + dtf.format(LocalDateTime.now()) + "',' " + c.getContact()
                                + "', '" + amountF + "');";
                        stmt2.execute(sql2);
                        availableF--;
                        return true;
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        System.exit(0);
                    }
                }
            }
        }
        catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
         }

        return false;
    }

    /**
     * To cancel a flight, the ticket number and the client passport number
     * should be verified. If an entry in the ReservedFlights table with the
     * same ticket number and the same password number exists, then it should be
     * removed from the table, and the value of “available” in Flights table
     * will be increased by one. The two methods return true if the flight was
     * successfully cancelled.
     *
     * @param ticket
     * @param passN
     * @return true or false
     */
    public boolean cancelFlight(int ticket, int passN) {

        return false;
    }

    /**
     * the two methods return a map containing all data retrieved from the
     * Flights table. The key of the map is “flightN”. All flights should be
     * sorted by “flightN”. viewFlightBoard() displays only flights with
     * available seats.
     *
     * @return map
     */
    public static Map<String, String> viewBoard() {
        Map<String, String> map = new HashMap();

        try (Statement stmt = flightConn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM FLIGHTS;");

            while (rs.next()) {
                String name = rs.getString("NAME");
                String origin = rs.getString("ORIGIN");
                String dest = rs.getString("DEST");
                int duration = rs.getInt("DURATION");
                int seats = rs.getInt("SEATS");
                int available = rs.getInt("AVAILABLE");
                int amount = rs.getInt("AMOUNT");

                map.put(rs.getString("FLIGHTN"), " NAME: " + name + ", ORIGIN: "
                        + origin + ", DEST: " + dest + ", DURATION: " + duration
                        + ", SEATS: " + seats + ", AVAILABLE: " + available
                        + ", AMOUNT: " + amount + "\n");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return map;
    }

    /**
     * Retrieves all data from ReservedFlights table and returns them as a map.
     * The map is sorted by “flightN”.
     *
     * @return map
     */
    public static Map<String, String> viewBookedFlights() {
        Map<String, String> map = new HashMap();

        try (Statement stmt = reserveConn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVEDFLIGHTS;");

            while (rs.next()) {
                String flightN = rs.getString("FLIGHTN");
                String passNum = rs.getString("PASSNUM");
                String flName = rs.getString("FLNAME");
                int issueDate = rs.getInt("ISSUEDATE");
                int contact = rs.getInt("CONTACT");
                int amount = rs.getInt("AMOUNT");

                map.put(rs.getString("TICKETN"), " FLIGHTN: " + flightN
                        + ", PASSNUM: " + passNum + ", FLNAME: " + flName
                        + ", ISSUEDATE: " + issueDate + ", CONTACT: " + contact
                        + ", AMOUNT: " + amount + "\n");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return map;
    }

    /**
     * getter method for flightN
     * @return flightN
     */
    public String getFlightN() {
        return flightN;
    }

    /**
     * setter method for flightN
     * @param flightN 
     */
    public void setFlightN(String flightN) {
        this.flightN = flightN;
    }

    /**
     * getter method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for origin
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * setter method for origin
     * @param origin 
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * getter method for dest
     * @return dest
     */
    public String getDest() {
        return dest;
    }

    /**
     * setter method for dest
     * @param dest 
     */
    public void setDest(String dest) {
        this.dest = dest;
    }

    /**
     * getter method for duration
     * @return duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * setter method for duration
     * @param duration 
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * getter method for seats
     * @return seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * setter method for seats
     * @param seats 
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * getter method for available
     * @return available
     */
    public int getAvailable() {
        return available;
    }

    /**
     * setter method for available
     * @param available 
     */
    public void setAvailable(int available) {
        this.available = available;
    }

    /**
     * getter method for amount
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * setter method for amount
     * @param amount 
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * toString method
     * @return a string
     */
    @Override
    public String toString() {
        return flightN + ", "
                + name + ", "
                + origin + ", "
                + dest + ", "
                + duration + ", "
                + seats + ", "
                + amount;
    }
}
