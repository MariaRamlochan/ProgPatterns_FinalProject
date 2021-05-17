package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to create a database connection for the reserved flight
 * @author Maria and Nafees
 */
public class ReserveDBConnection {

    //Data members
    private static Connection connect;

    public static Connection getInstance() {
        if (connect == null) {
            connect = createConnection();
        }
        return connect;
    }

    /**
     * create the connection to the database
     * @return c or null
     */
    public static Connection createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:\\SQLite\\db\\reserved.db");
            return c;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
