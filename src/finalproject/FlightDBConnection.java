package finalproject;

import java.sql.*;

/**
 *
 * @author maria
 */
public class FlightDBConnection {
    private static Connection connect;
    public static Connection getInstance() {
        if (connect == null) {
            connect = createConnection();
        }
        return connect;
    }
  
    public static Connection createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:\\SQLite\\db\\flight.db");
            return c;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
