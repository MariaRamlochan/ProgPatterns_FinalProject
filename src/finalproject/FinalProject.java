package finalproject;

import java.util.*;

/**
 *
 * @author maria
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       List<Flight> model= retrieveData();
       FlightView view = new FlightView();
       FlightController controller = new FlightController(model, view);
       String SQL_CREATE_Table = "CREATE TABLE Students "
                    + "(STUDENTID INT PRIMARY KEY     NOT NULL,"
                    + " name                   TEXT   NOT NULL, "
                    + " address                Text   NOT NULL) ";
       
       controller.createFlightsTable(SQL_CREATE_Table);
       System.out.println("Table Flights created");
//       for(Flight st:model)
//       controller.addStudent(st);

       
        
    }
    public static List<Flight> retrieveData()
    { 
     Flight[] listOfStudents = { 
         new Flight("1001", "Boeing 737 Max", "Montreal", "Amsterdam", 555, 204, true, 1115), 
         new Flight("1002", "Boeing 737", "Toronto", "London", 405, 130, true, 635),
         new Flight("1003", "Boeing 787 Breamliner", "Montreal", "Doha", 725, 248, true, 3093),
         new Flight("1004", "Boeing 800", "Toronto", "Guyana", 1200, 168, true, 721)};
        
     return new ArrayList(Arrays.asList(listOfStudents));  
    }
    
}
