package finalproject;

import java.sql.*;
import java.util.*;

/**
 *
 * @author maria
 */
public class Controller {

    private List<Flight> model;
    private FlightView view;
    private final Connection flightConn = FlightDBConnection.getInstance();
    private final Connection clientConn = ClientDBConnection.getInstance();
    private final Connection reserveConn = ReserveDBConnection.getInstance();

    public Controller(List<Flight> model, FlightView view) {
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

    public void createClientsTable(String sqlStatement) {
        try (Statement stmt = clientConn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS CLIENTS;");
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

    public void updateView(Map model) {
        FlightView.printFlightDetails(model);
    }
}
