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
    public boolean bookASeat(String flightNum){
        return false;
    }
    
    public boolean cancelResservation(int ticket){
        
        return false;
    }
    
    public List<Flight> searchFlightByDest(String dest){
        
        return null;
    }
    
    public List<Flight> searchFlightByDuration(int d){
        
        return null;
    }
    
    public List<Flight> searchFlighByOrigin(String origin){
        
        return null;
    }
    
    public Map<String,String> viewFlightsBoard(){
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
