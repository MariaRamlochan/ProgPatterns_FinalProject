package finalproject;

import java.sql.*;
import java.util.*;

/**
 *
 * @author maria
 */
public class ClientController {
    private List<Client> model;
    private ClientView view;
    private final Connection clientConn = ClientDBConnection.getInstance();

    public ClientController(List<Client> model, ClientView view) {
        this.model = model;
        this.view = view;
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
    
    public String updateView(Map model) {
        return ClientView.printClientDetails(model);
    }
}
