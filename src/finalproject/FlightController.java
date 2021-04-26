package finalproject;

import java.sql.*;
import java.util.*;

/**
 *
 * @author maria
 */
public class FlightController {
    private List<Flight> model;
    private FlightView view;
    
    private final Connection conn = FlightDBConnection.getInstance();
    
    public void createFlightsTable(String sqlStatement) {
        try(Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXIST Flights;");
            stmt.executeUpdate(sqlStatement); 
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void createClientsTable(String sqlStatement) {
        try(Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXIST Clients;");
            stmt.executeUpdate(sqlStatement); 
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void createReservedFlightsTable(String sqlStatement) {
        try(Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXIST ReservedFlights;");
            stmt.executeUpdate(sqlStatement); 
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void updateView(Map model) {
        FlightView.printFlightDetails(model);
    }
}
