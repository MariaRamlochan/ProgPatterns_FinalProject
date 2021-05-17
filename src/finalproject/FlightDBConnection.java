package finalproject;

import java.sql.*;

/**
 *
 * @author maria and nafees
 */
public class FlightDBConnection {
    private static Connection connect;
    public static Connection getInstance() {
        if (connect == null) {
            connect = createConnection();
        }
        return connect;
    }
  
    /**
     * this method creates the connection to the database
     * @return c
     */
    public static Connection createConnection() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:\\SQLite\\db\\flight.db");
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
