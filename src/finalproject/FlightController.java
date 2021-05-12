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
    private final Connection clientConn = ClientDBConnection.getInstance();
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

    public Map<String, String> getAllFlights() {
        Map<String, String> map = new HashMap();

        try (Statement stmt = flightConn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM FLIGHTS;");

            while (rs.next()) {
                String name = rs.getString("NAME");
                String origin = rs.getString("ORIGIN");
                String dest = rs.getString("DEST");
                int duration = rs.getInt("DURATION");
                int seats = rs.getInt("SEATS");
                int available = rs.getInt("AVAILABLE");
                int amount = rs.getInt("AMOUNT");

                map.put(rs.getString("FLIGHTN"), " NAME: " + name + ", ORIGIN: " 
                        + origin + ", DEST: " + dest + ", DURATION: " + duration 
                        + ", SEATS: " + seats + ", AVAILABLE: " + available 
                        + ", AMOUNT: " + amount + "\n");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return map;
    }

    public void updateView(Map model) {
        FlightView.printFlightDetails(model);
    }
}
