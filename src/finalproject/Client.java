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
}
