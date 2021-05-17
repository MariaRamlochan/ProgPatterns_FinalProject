package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to create a database connection for the client
 * @author Maria and Nafees
 */
public class ClientDBConnection {
    
    //Data members
    private static Connection connect;

    /**
     * Method to get the instance of the connection
     * @return a connection
     */
    public static Connection getInstance() {
        if (connect == null) {
            connect = createConnection();
        }
        return connect;
    }

    /**
     * Method to create a connection
     * @return a connection
     */
    public static Connection createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:\\SQLite\\db\\client.db");
            return c;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
