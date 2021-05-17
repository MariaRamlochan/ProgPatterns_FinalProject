package finalproject;

import java.sql.*;
import java.util.*;

/**
 * Class to control the client through a controller
 * @author maria and nafees
 */
public class ClientController {
    //Data members
    private List<Client> model;
    private ClientView view;
    
    //Client connection
    private final Connection clientConn = ClientDBConnection.getInstance();

    /**
     * COnstructor with all parameters
     * @param model the list of clients
     * @param view the view to view the clients
     */
    public ClientController(List<Client> model, ClientView view) {
        this.model = model;
        this.view = view;
    }
 
    /**
     * Create a table of clients
     * @param sqlStatement the sql statement
     */
    public void createClientsTable(String sqlStatement) {
        try (Statement stmt = clientConn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS CLIENTS;");
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * Method to update the view of the client
     * @param model a map of the client
     * @return a string of the printed clients from the map
     */
    public String updateView(Map model) {
        return ClientView.printClientDetails(model);
    }
}
