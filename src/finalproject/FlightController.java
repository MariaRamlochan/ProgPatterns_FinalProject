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
    private final Connection flightConn = FlightDBConnection.getInstance();
    private final Connection reserveConn = ReserveDBConnection.getInstance();

    public FlightController(List<Flight> model, FlightView view) {
        this.model = model;
        this.view = view;
    }

    public void createFlightsTable(String sqlStatement) {
        try (Statement stmt = flightConn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS FLIGHTS;");
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void createReservedFlightsTable(String sqlStatement) {
        try (Statement stmt = reserveConn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS RESERVEDFLIGHTS;");
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public String updateView(Map model) {
        return FlightView.printFlightDetails(model);
    }
}
