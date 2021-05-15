package finalproject;

import java.sql.*;
import java.util.*;

/**
 *
 * @author maria
 */
public class Client {

    private int passNumber;
    private String fullName; //full name of the client
    private int contact;    //contact number of the client
    private static Connection clientConn = ClientDBConnection.getInstance();
    private static Connection flightConn = FlightDBConnection.getInstance();
    private static Connection reserveConn = ReserveDBConnection.getInstance();

    public Client() {
    }

    public Client(int passNumber, String fullName, int contact) {
        this.passNumber = passNumber;
        this.fullName = fullName;
        this.contact = contact;
    }

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

    public static Map<String, String> viewBoard() {
        Map<String, String> map = new HashMap();

        try (Statement stmt = clientConn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTS;");

            while (rs.next()) {
                String fullName = rs.getString("FULLNAME");
                int contact = rs.getInt("CONTACT");

                map.put(rs.getString("PASSNUM"), " FULLNAME: " + fullName + ", CONTACT: "
                        + contact + "\n");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return map;
    }

    /**
     *
     * @param flightNum
     * @return
     */
    public boolean bookASeat(String flightNum) {
        return false;
    }

    public boolean cancelResservation(int ticket) {

        return false;
    }

    /**
     * this method retrieves all data that matches the "destination" and saves it
     * in a List.
     * 
     * @param dest
     * @return flightList
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
     * @param dest
     * @return durList
     */
    public List<Flight> searchFlightByDuration(int d) {
        List<Flight> flightList = new ArrayList<>();
        Flight durList = null;

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
     * @param dest
     * @return oriList
     */
    public List<Flight> searchFlighByOrigin(String ori) {
        List<Flight> flightList = new ArrayList<>();
        Flight oriList = null;

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
