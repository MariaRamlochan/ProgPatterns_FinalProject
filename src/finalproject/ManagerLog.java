/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.FinalProject.retrieveClientData;
import static finalproject.FinalProject.retrieveFlightData;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Natsu
 */
public class ManagerLog extends javax.swing.JFrame {
    Client client = new Client();
    List<Client> clientModel = retrieveClientData();
    ClientView clientView = new ClientView();
    ClientController clientController = new ClientController(clientModel, clientView);

    List<Flight> flightModel = retrieveFlightData();
    FlightView flightView = new FlightView();
    FlightController flightController = new FlightController(flightModel, flightView);
    Flight flight = new Flight();
    
    ResourceBundle res;
    
    public ManagerLog() {
        initComponents();
        englishButton.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        displayTextArea = new javax.swing.JTextArea();
        displayBoardButton = new javax.swing.JButton();
        englishButton = new javax.swing.JButton();
        frenchButton = new javax.swing.JButton();
        viewReservedButton = new javax.swing.JButton();
        ticketNumTextField = new javax.swing.JTextField();
        clientTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        issueTicketButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayTextArea.setColumns(20);
        displayTextArea.setRows(5);
        jScrollPane1.setViewportView(displayTextArea);

        displayBoardButton.setText("View Board");
        displayBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBoardButtonActionPerformed(evt);
            }
        });

        englishButton.setText("English");
        englishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishButtonActionPerformed(evt);
            }
        });

        frenchButton.setText("French");
        frenchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frenchButtonActionPerformed(evt);
            }
        });

        viewReservedButton.setText("View Reserved");
        viewReservedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReservedButtonActionPerformed(evt);
            }
        });

        ticketNumTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        clientTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Ticket Number: ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Client: ");

        issueTicketButton.setText("Issue Ticket");
        issueTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueTicketButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Issue a Ticket");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(englishButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frenchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ticketNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(issueTicketButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 545, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayBoardButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewReservedButton))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(englishButton)
                            .addComponent(frenchButton))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ticketNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(issueTicketButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayBoardButton)
                    .addComponent(viewReservedButton))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void englishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishButtonActionPerformed
        displayTextArea.setText("");
        Locale locale = new Locale("en", "CA");
        res = ResourceBundle.getBundle("finalproject/file", locale);
    }//GEN-LAST:event_englishButtonActionPerformed

    private void frenchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frenchButtonActionPerformed
        displayTextArea.setText("");
        Locale locale = new Locale("fr", "CA");
        res = ResourceBundle.getBundle("finalproject/file", locale);
    }//GEN-LAST:event_frenchButtonActionPerformed

    private void displayBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBoardButtonActionPerformed
        displayTextArea.setText("");

        String str = "";

        str += res.getString("key4") + "\n";
        str += flightController.updateView(Flight.viewBoard());

        displayTextArea.setText(str);
    }//GEN-LAST:event_displayBoardButtonActionPerformed

    private void viewReservedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReservedButtonActionPerformed
        displayTextArea.setText("");

        String str = "";

        str += res.getString("key4") + "\n";
        str += flightController.updateView(Flight.viewBookedFlights());

        displayTextArea.setText(str);
    }//GEN-LAST:event_viewReservedButtonActionPerformed

    private void issueTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueTicketButtonActionPerformed
        displayTextArea.setText("");
        
        clientModel.forEach((cl) -> { if (cl.getPassNumber() == 
                Integer.parseInt(clientTextField.getText())) 
                flight.issueTicket(cl, ticketNumTextField.getText()); });
        
        String str = "";
        
        str += "\n" + res.getString("key9");
        str += flightController.updateView(Flight.viewBookedFlights());
        
        displayTextArea.setText(str);
    }//GEN-LAST:event_issueTicketButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerLog().setVisible(true);
                
                List<Flight> flightModel = retrieveFlightData();
                FlightView flightView = new FlightView();
                FlightController flightController = new FlightController(flightModel, flightView);
                Flight flight = new Flight();

                List<Client> clientModel = retrieveClientData();
                ClientView clientView = new ClientView();
                ClientController clientController = new ClientController(clientModel, clientView);
                Client client = new Client();

                String SQL_CREATE_TABLE_FLIGHTS = "CREATE TABLE FLIGHTS "
                        + "(FLIGHTN TEXT PRIMARY KEY      NOT NULL,"
                        + " NAME                     TEXT NOT NULL,"
                        + " ORIGIN                   TEXT NOT NULL,"
                        + " DEST                     TEXT NOT NULL,"
                        + " DURATION                  INT NOT NULL,"
                        + " SEATS                     INT NOT NULL,"
                        + " AVAILABLE                 INT NOT NULL,"
                        + " AMOUNT                    INT NOT NULL)";

                String SQL_CREATE_TABLE_CLIENTS = "CREATE TABLE CLIENTS "
                        + "(PASSNUM INT PRIMARY KEY       NOT NULL,"
                        + " FULLNAME                 TEXT NOT NULL,"
                        + " CONTACT                   INT NOT NULL)";

                String SQL_CREATE_TABLE_RESERVEDFLIGHTS = "CREATE TABLE RESERVEDFLIGHTS "
                        + "(TICKETN INT PRIMARY KEY       ,"
                        + " FLIGHTN                  TEXT NOT NULL,"
                        + " PASSNUM                   INT NOT NULL,"
                        + " FLNAME                   TEXT NOT NULL,"
                        + " ISSUEDATE                DATE NOT NULL,"
                        + " CONTACT                   INT NOT NULL,"
                        + " AMOUNT                    INT NOT NULL,"
                        + " CONSTRAINT FK_RESERVE_FLIGHN FOREIGN KEY(FLIGHTN)"
                        + " REFERENCES FLIGHTS(FLIGHTN),"
                        + " CONSTRAINT FK_RESERVE_PASSNUM FOREIGN KEY(PASSNUM)"
                        + " REFERENCES CLIENTS(PASSNUM))";
                
                flightController.createFlightsTable(SQL_CREATE_TABLE_FLIGHTS);
                //System.out.println("\nTABLE RESERVEDFLIGHTS FLIGHTS");
                //System.out.println("\n" + res.getString("key1"));
                clientController.createClientsTable(SQL_CREATE_TABLE_CLIENTS);
                //System.out.println("\nTABLE RESERVEDFLIGHTS CLIENTS");
                //System.out.println("\n" + res.getString("key2"));
                flightController.createReservedFlightsTable(SQL_CREATE_TABLE_RESERVEDFLIGHTS);
                //System.out.println("\nTABLE RESERVEDFLIGHTS CREATED");
                // System.out.println("\n" + res.getString("key3"));
                
                flightModel.forEach((fl) -> {
                    flight.addFlight(fl);
                });
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clientTextField;
    private javax.swing.JButton displayBoardButton;
    private javax.swing.JTextArea displayTextArea;
    private javax.swing.JButton englishButton;
    private javax.swing.JButton frenchButton;
    private javax.swing.JButton issueTicketButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ticketNumTextField;
    private javax.swing.JButton viewReservedButton;
    // End of variables declaration//GEN-END:variables
}
