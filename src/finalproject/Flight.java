package finalproject;

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
    
    public boolean addFlight(Flight flight){
        
        return false;
    }
    
    public boolean removerFlight(String flightn){
        
        return false;
    }
    
    public boolean updateFlightData(String flightn, String field, String newValue){
        
        return false;
    }
    
    public boolean issueTicket(Client c){
        
        return false;
    }
    
    public boolean cancelFlight(int ticket, int passN){
        
        return false;
    }
    
    public Map<String,String> viewBookedFlights(){
        
        return null;
    }
    
}
