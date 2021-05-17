package finalproject;

import java.sql.*;
import java.util.*;

/**
 * Class to control the flight through a controller
 * @author Maria and Nafees
 */
public class FlightController {

    //Data members
    private List<Flight> model;
    private FlightView view;
    
    //Flight and ReservedFlights connection
    private final Connection flightConn = FlightDBConnection.getInstance();
    private final Connection reserveConn = ReserveDBConnection.getInstance();

    public FlightController(List<Flight> model, FlightView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Create a table of flights
     * @param sqlStatement the sql statement
     */
    public void createFlightsTable(String sqlStatement) {
        try (Statement stmt = flightConn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS FLIGHTS;");
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Create a table of reserved flights
     * @param sqlStatement the sql statement 
     */
    public void createReservedFlightsTable(String sqlStatement) {
        try (Statement stmt = reserveConn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS RESERVEDFLIGHTS;");
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method to update the view of the flight
     * @param model a map of the flight's
     * @return a string of the printed flights from the map
     */
    public String updateView(Map model) {
        return FlightView.printFlightDetails(model);
    }
}
