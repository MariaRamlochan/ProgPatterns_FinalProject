package finalproject;

import java.sql.*;
import java.util.*;

/**
 *
 * @author maria
 */
public class Client {
    private String fullName; //full name of the client
    private int passNumber;
    private int contact;    //contact number of the client
    private final Connection clientConn = ClientDBConnection.getInstance();

    public Client(String fullName, int passNumber, int contact) {
        this.fullName = fullName;
        this.passNumber = passNumber;
        this.contact = contact;
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
        
        return null;
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
