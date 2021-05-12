package finalproject;

import java.sql.*;
import java.util.*;

/**
 *
 * @author maria
 */
public class Flight {

    private String flightN;
    private String name;
    private String origin;
    private String dest;
    private double duration;
    private int seats;
    private boolean available;
    private double amount;
    private final Connection conn = FlightDBConnection.getInstance();

    public Flight() {

    }

    public Flight(String flightN, String name, String origin, String dest,
            double duration, int seats, boolean available, double amount) {
        this.flightN = flightN;
        this.name = name;
        this.origin = origin;
        this.dest = dest;
        this.duration = duration;
        this.seats = seats;
        this.available = available;
        this.amount = amount;
    }

    /**
     * The method creates a new entry in the Flights table to add a new flight
     * to the board, sets “available” to the same value as “seats“. A true value
     * is returned by the method if the flight is successfully inserted.
     *
     * @param flight
     * @return
     */
    public boolean addFlight(Flight flight) {
        try (Statement stmt = conn.createStatement()) {
            if (available = true) {
                String sql = "INSERT INTO FLIGHTS (FLIGHTN, NAME, ORIGIN, DEST, "
                        + "DURATION, SEATS, AVAILABLE, AMOUNT) "
                        + "VALUES (" + flight.flightN + ", '" + flight.name + "',' "
                        + flight.origin + "',' " + flight.dest + "',' "
                        + flight.duration + "',' " + flight.seats + "',' "
                        + flight.available + "',' " + flight.amount + "');";
                stmt.execute(sql);
                return true;
            }
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
     * @return
     */
    public boolean removerFlight(String flightN) {
        try ( Statement stmt = conn.createStatement()) {

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
     * @return
     */
    public boolean updateFlightData(String flightN, String field, String newValue) {

        return false;
    }

    /**
     * To issue a ticket number or book a seat the availability of seats should
     * be checked. If a seat is available (the value of “available” is greater
     * than 0 in “Flights” table), the table should be updated and the value of
     * available should be decreased by one. A new entry in “ReservedFlights”
     * table is added. The two methods return true if the flight was
     * successfully booked.
     *
     * @param c
     * @return
     */
    public boolean issueTicket(Client c) {

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
     * @return
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
     * @return
     */
    public static Map<String, String> viewBoard() {

        return null;
    }

    public static Map<String, String> viewBookedFlights() {

        return null;
    }

    public String getFlightN() {
        return flightN;
    }

    public void setFlightN(String flightN) {
        this.flightN = flightN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
