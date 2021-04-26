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
    
    
    public boolean addFlight(Flight flight){
        
        return false;
    }
    
    public boolean removerFlight(String flightN){
        
        return false;
    }
    
    public boolean updateFlightData(String flightN, String field, String newValue){
        
        return false;
    }
    
    public boolean issueTicket(Client c){
        
        return false;
    }
    
    public boolean cancelFlight(int ticket, int passN){
        
        return false;
    }
    
    public static Map<String,String> viewBoard(){
        
        return null;
    }
    
    public static Map<String,String> viewBookedFlights(){
        
        return null;
    }   
}
