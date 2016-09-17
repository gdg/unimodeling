package info.sarihh.unimodeling.gui;

import info.sarihh.unimodeling.streamapi.StreamSource;
import info.sarihh.unimodeling.utility.DatabaseConnectionFactory;
import info.sarihh.unimodeling.utility.IPAddressFormatter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DocumentFilter;

/**
 * This class creates the internal frame for the RFID reader simulator.
 * Author: Sari Haj Hussein
 */
public class RFIDReaderSimulatorFrame extends javax.swing.JInternalFrame implements Runnable {

    /**
     * Creates new form RFIDReaderSimulatorFrame
     */
    public RFIDReaderSimulatorFrame(UniModelingGUI uniModelingGUI) {
        this.unModeingGUI = uniModelingGUI;
        initComponents();
        driversComboBox.setSelectedIndex(1);
        registerStreamDialog.pack();
        connectDatabaseDialog.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        registerStreamDialog = new javax.swing.JDialog();
        infoScrollPane = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        streamEncodingScrollPane = new javax.swing.JScrollPane();
        streamEncodingTextArea = new javax.swing.JTextArea();
        buttonPanel1 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        connectDatabaseDialog = new javax.swing.JDialog();
        driversLabel = new javax.swing.JLabel();
        driversComboBox = new javax.swing.JComboBox();
        urlLabel = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        buttonPanel2 = new javax.swing.JPanel();
        testButton = new javax.swing.JButton();
        buttonFiller5 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        okButton1 = new javax.swing.JButton();
        containerScrollPane = new javax.swing.JScrollPane();
        containerPanel = new javax.swing.JPanel();
        serverHostNameLabel = new javax.swing.JLabel();
        serverHostNameTextField = new javax.swing.JFormattedTextField(new IPAddressFormatter());
        serverPortNumberLabel = new javax.swing.JLabel();
        serverPortNumberTextField = new javax.swing.JFormattedTextField(new DefaultFormatter() {
            private DocumentFilter portNumberFormatter = new info.sarihh.unimodeling.utility.NumberFieldFormatter(5);
            protected DocumentFilter getDocumentFilter() {
                return portNumberFormatter;
            }
        });
        readRateLabel = new javax.swing.JLabel();
        readRateSpinner = new javax.swing.JSpinner();
        activityLogScrollPane = new javax.swing.JScrollPane();
        activityLogTextArea = new javax.swing.JTextArea();
        buttonPanel = new javax.swing.JPanel();
        registerStreamButton = new javax.swing.JButton();
        connectDatabaseButton = new javax.swing.JButton();
        connectServerButton = new javax.swing.JButton();
        disconnectServerButton = new javax.swing.JButton();
        startSimulationButton = new javax.swing.JButton();
        endSimulationButton = new javax.swing.JButton();
        clearLogButton = new javax.swing.JButton();

        registerStreamDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("info/sarihh/unimodeling/gui/RFIDReaderSimulatorFrame"); // NOI18N
        registerStreamDialog.setTitle(bundle.getString("RFIDReaderSimulatorFrame.registerStreamDialog.title")); // NOI18N
        registerStreamDialog.setModal(true);
        registerStreamDialog.setResizable(false);
        registerStreamDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        infoScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        infoTextArea.setBackground(new java.awt.Color(212, 208, 200));
        infoTextArea.setColumns(45);
        infoTextArea.setEditable(false);
        infoTextArea.setLineWrap(true);
        infoTextArea.setRows(10);
        infoTextArea.setText("Specify a string encoding of the stream information in the form:\nregister stream S (obj-id varchar#reader-id integer#time timestamp#...)\nwhere S is the stream name and obj-id, reader-id, and time are attributes of types varchar, integer, and timestamp respectively.\nThe attributes obj-id, reader-id, and time are mandatory.\nThe first two attributes are used for indexing the in-memory hash structure.\nThe last attribute is used to enforce chronological ordering on stream tuples if possible.\nAn arbitrary number of additional attributes can be specified, and there are no restrictions on their types provided that they are supported by the DBMS that will store their values."); // NOI18N
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setCaretPosition(0);
        infoScrollPane.setViewportView(infoTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        registerStreamDialog.getContentPane().add(infoScrollPane, gridBagConstraints);

        streamEncodingScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        streamEncodingTextArea.setColumns(45);
        streamEncodingTextArea.setFont(new java.awt.Font("Courier New", 0, 11));
        streamEncodingTextArea.setLineWrap(true);
        streamEncodingTextArea.setRows(6);
        streamEncodingTextArea.setText("register stream reading (license_plate varchar2(10 byte)#location_id number(20,0)#reading_ts timestamp(3))"); // NOI18N
        streamEncodingTextArea.setWrapStyleWord(true);
        streamEncodingScrollPane.setViewportView(streamEncodingTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        registerStreamDialog.getContentPane().add(streamEncodingScrollPane, gridBagConstraints);

        okButton.setText(bundle.getString("RFIDReaderSimulatorFrame.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel1.add(okButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        registerStreamDialog.getContentPane().add(buttonPanel1, gridBagConstraints);

        connectDatabaseDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        connectDatabaseDialog.setTitle(bundle.getString("RFIDReaderSimulatorFrame.connectDatabaseDialog.title")); // NOI18N
        connectDatabaseDialog.setModal(true);
        connectDatabaseDialog.setResizable(false);
        connectDatabaseDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        driversLabel.setText(bundle.getString("RFIDReaderSimulatorFrame.driversLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(driversLabel, gridBagConstraints);

        driversComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MySQL Driver", "Oracle Thin Driver", "PostgreSQL Driver" }));
        driversComboBox.setPreferredSize(new java.awt.Dimension(360, 22));
        driversComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driversComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(driversComboBox, gridBagConstraints);

        urlLabel.setText(bundle.getString("RFIDReaderSimulatorFrame.urlLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(urlLabel, gridBagConstraints);

        urlTextField.setText("jdbc:mysql://<hostname>[,<failoverhost>][<:3306>]/<dbname>"); // NOI18N
        urlTextField.setPreferredSize(new java.awt.Dimension(360, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(urlTextField, gridBagConstraints);

        userNameLabel.setText(bundle.getString("RFIDReaderSimulatorFrame.userNameLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(userNameLabel, gridBagConstraints);

        userNameTextField.setToolTipText(bundle.getString("RFIDReaderSimulatorFrame.userNameTextField.toolTipText")); // NOI18N
        userNameTextField.setPreferredSize(new java.awt.Dimension(360, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(userNameTextField, gridBagConstraints);

        passwordLabel.setText(bundle.getString("RFIDReaderSimulatorFrame.passwordLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(passwordLabel, gridBagConstraints);

        passwordTextField.setPreferredSize(new java.awt.Dimension(360, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(passwordTextField, gridBagConstraints);

        testButton.setText(bundle.getString("RFIDReaderSimulatorFrame.testButton.text")); // NOI18N
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });
        buttonPanel2.add(testButton);
        buttonPanel2.add(buttonFiller5);

        okButton1.setText(bundle.getString("RFIDReaderSimulatorFrame.okButton1.text")); // NOI18N
        okButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButton1ActionPerformed(evt);
            }
        });
        buttonPanel2.add(okButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        connectDatabaseDialog.getContentPane().add(buttonPanel2, gridBagConstraints);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(bundle.getString("RFIDReaderSimulatorFrame.title")); // NOI18N

        containerPanel.setLayout(new java.awt.GridBagLayout());

        serverHostNameLabel.setText(bundle.getString("RFIDReaderSimulatorFrame.serverHostNameLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        containerPanel.add(serverHostNameLabel, gridBagConstraints);

        serverHostNameTextField.setText("127.0.0.1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        containerPanel.add(serverHostNameTextField, gridBagConstraints);

        serverPortNumberLabel.setText(bundle.getString("RFIDReaderSimulatorFrame.serverPortNumberLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        containerPanel.add(serverPortNumberLabel, gridBagConstraints);

        serverPortNumberTextField.setText("12345"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        containerPanel.add(serverPortNumberTextField, gridBagConstraints);

        readRateLabel.setText(bundle.getString("RFIDReaderSimulatorFrame.readRateLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        containerPanel.add(readRateLabel, gridBagConstraints);

        readRateSpinner.setModel(new SpinnerNumberModel(1, 1, 60, 1));
        javax.swing.JSpinner.NumberEditor editor = new javax.swing.JSpinner.NumberEditor(readRateSpinner, "#");
        editor.getTextField().setHorizontalAlignment(javax.swing.JTextField.LEFT);
        readRateSpinner.setEditor(editor);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        containerPanel.add(readRateSpinner, gridBagConstraints);

        activityLogScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("RFIDReaderSimulatorFrame.activityLogScrollPane.border.title"))); // NOI18N
        activityLogScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        activityLogTextArea.setColumns(40);
        activityLogTextArea.setEditable(false);
        activityLogTextArea.setLineWrap(true);
        activityLogTextArea.setRows(12);
        activityLogTextArea.setWrapStyleWord(true);
        activityLogScrollPane.setViewportView(activityLogTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        containerPanel.add(activityLogScrollPane, gridBagConstraints);

        registerStreamButton.setText(bundle.getString("RFIDReaderSimulatorFrame.registerStreamButton.text")); // NOI18N
        registerStreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerStreamButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(registerStreamButton);

        connectDatabaseButton.setText(bundle.getString("RFIDReaderSimulatorFrame.connectDatabaseButton.text")); // NOI18N
        connectDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectDatabaseButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(connectDatabaseButton);

        connectServerButton.setText(bundle.getString("RFIDReaderSimulatorFrame.connectServerButton.text")); // NOI18N
        connectServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectServerButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(connectServerButton);

        disconnectServerButton.setText(bundle.getString("RFIDReaderSimulatorFrame.disconnectServerButton.text")); // NOI18N
        disconnectServerButton.setEnabled(false);
        disconnectServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectServerButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(disconnectServerButton);

        startSimulationButton.setText(bundle.getString("RFIDReaderSimulatorFrame.startSimulationButton.text")); // NOI18N
        startSimulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSimulationButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(startSimulationButton);

        endSimulationButton.setText(bundle.getString("RFIDReaderSimulatorFrame.endSimulationButton.text")); // NOI18N
        endSimulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endSimulationButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(endSimulationButton);

        clearLogButton.setText(bundle.getString("RFIDReaderSimulatorFrame.clearLogButton.text")); // NOI18N
        clearLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearLogButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(clearLogButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        containerPanel.add(buttonPanel, gridBagConstraints);

        containerScrollPane.setViewportView(containerPanel);

        getContentPane().add(containerScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void disconnectServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectServerButtonActionPerformed
    disconnect();
}//GEN-LAST:event_disconnectServerButtonActionPerformed

private void connectServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectServerButtonActionPerformed
    try {
        socket = new Socket(InetAddress.getByName(serverHostNameTextField.getText()),
                Integer.parseInt(serverPortNumberTextField.getText()));
        socketInput = new ObjectInputStream(socket.getInputStream());
        socketOutput = new ObjectOutputStream(socket.getOutputStream());
        appendLogText("A connection made with the server: "
                + serverHostNameTextField.getText() + " on port: "
                + serverPortNumberTextField.getText() + ".");
        new Thread(this).start();
        switchButtonState(disconnectServerButton, connectServerButton);
    } catch (Exception e) {
        appendLogText(e.toString().contains("SocketException") ? "" : e.toString());
        appendLogText("A connection failed with the server: "
                + serverHostNameTextField.getText() + " on port: "
                + serverPortNumberTextField.getText() + ".");
        switchButtonState(connectServerButton, disconnectServerButton);
    }
}//GEN-LAST:event_connectServerButtonActionPerformed

private void registerStreamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerStreamButtonActionPerformed
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            registerStreamDialog.setLocationRelativeTo(RFIDReaderSimulatorFrame.this);
            registerStreamDialog.setVisible(true);
        }
    });
}//GEN-LAST:event_registerStreamButtonActionPerformed

private void connectDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectDatabaseButtonActionPerformed
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            connectDatabaseDialog.setLocationRelativeTo(RFIDReaderSimulatorFrame.this);
            connectDatabaseDialog.setVisible(true);
        }
    });
}//GEN-LAST:event_connectDatabaseButtonActionPerformed

private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    String streamEncoding = streamEncodingTextArea.getText();
    streamSource.register(streamEncoding);
    registerStreamDialog.setVisible(false);
    appendLogText("The stream " + streamEncoding.substring(16) + " is registered.");
}//GEN-LAST:event_okButtonActionPerformed

private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
    conn = DatabaseConnectionFactory.getDatabaseConnection(
            driversComboBox.getSelectedItem().toString(), urlTextField.getText(),
            userNameTextField.getText(), new String(passwordTextField.getPassword()));
    if (conn != null) {
        JOptionPane.showMessageDialog(RFIDReaderSimulatorFrame.this,
                "Connection succeeded!",
                "UniModeling",
                JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(RFIDReaderSimulatorFrame.this,
                "Connection failed!",
                "UniModeling",
                JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_testButtonActionPerformed

private void okButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButton1ActionPerformed
    conn = DatabaseConnectionFactory.getDatabaseConnection(
            driversComboBox.getSelectedItem().toString(), urlTextField.getText(),
            userNameTextField.getText(), new String(passwordTextField.getPassword()));
    if (conn != null) {
        appendLogText("A connection made with the database: "
                + urlTextField.getText() + " using driver: "
                + driversComboBox.getSelectedItem() + ".");
    } else {
        appendLogText("A connection failed with the database: "
                + urlTextField.getText() + " using driver: "
                + driversComboBox.getSelectedItem() + ".");
    }
    connectDatabaseDialog.setVisible(false);
}//GEN-LAST:event_okButton1ActionPerformed

private void startSimulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSimulationButtonActionPerformed
    if (!socket.isClosed()) { // if the user tries to start the simulation before connecting with the RFID server
        simulationFlag = true;
        streamSource.start(conn);
        Thread simulationThread = new Thread() {

            @Override
            public void run() {
                try {
                    HashMap<String, String> reading = new HashMap<>();
                    switchButtonState(endSimulationButton, startSimulationButton);
                    int counter = 0;
                    while (streamSource.getNext(reading)) {
                        if (simulationFlag) {
                            counter++;
                            socketOutput.writeObject(reading);
                            socketOutput.flush();
                            appendLogText("Sending reading: " + reading + ".");
                            reading = new HashMap<>();
                            sleep(1000 * ((int) readRateSpinner.getValue()));
                        } else {
                            streamSource.end();
                            HashMap<String, String> endReading = new HashMap<>();
                            endReading.put("END", "END");
                            socketOutput.writeObject(endReading);
                            socketOutput.flush();
                            appendLogText("The simulation ended.");
                            switchButtonState(startSimulationButton, endSimulationButton);
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                    appendLogText(counter + " readings were sent.");
                } catch (Exception e) {
                    appendLogText(e.toString().contains("SocketException") ? "" : e.toString());
                    Thread.currentThread().interrupt();
                    switchButtonState(startSimulationButton, endSimulationButton);
                }
            }
        };
        simulationThread.start();
    } else {
        appendLogText("The simulator is disconnected.");
    }
}//GEN-LAST:event_startSimulationButtonActionPerformed

private void endSimulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endSimulationButtonActionPerformed
    simulationFlag = false;
}//GEN-LAST:event_endSimulationButtonActionPerformed

private void clearLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearLogButtonActionPerformed
    activityLogTextArea.setText("");
}//GEN-LAST:event_clearLogButtonActionPerformed

private void driversComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driversComboBoxActionPerformed
    switch (driversComboBox.getSelectedIndex()) {
        case 0:
            urlTextField.setText("jdbc:mysql://<hostname>[,<failoverhost>][<:3306>]/<dbname>");
            userNameTextField.setText("");
            passwordTextField.setText("");
            break;
        case 1:
            urlTextField.setText("jdbc:oracle:thin:@<server>[:<1521>]:<database_name>");
            break;
        case 2:
            urlTextField.setText("jdbc:postgresql:[<//host>[:<5432>/]]<database>");
            userNameTextField.setText("");
            passwordTextField.setText("");
            break;
        default:
            break;
    }
}//GEN-LAST:event_driversComboBoxActionPerformed

    public void appendLogText(final String text) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                if (!text.equals("")) {
                    activityLogTextArea.append(dateFormat.format(new Date()) + " -> " + text + "\n");
                    activityLogTextArea.setCaretPosition(activityLogTextArea.getText().length());
                }
            }
        });
    }

    public void disconnect() {
        try {
            HashMap<String, String> quitReading = new HashMap<>();
            quitReading.put("QUIT", "QUIT");
            socketOutput.writeObject(quitReading);
            socketOutput.flush();
            socket.close();
            appendLogText("The simulator is disconnected.");
            switchButtonState(connectServerButton, disconnectServerButton);
        } catch (Exception e) {
            appendLogText(e.toString().contains("SocketException") ? "" : e.toString());
            switchButtonState(disconnectServerButton, connectServerButton);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = (String) socketInput.readObject();
                if (message.equals("QUIT")) {
                    socket.close();
                    appendLogText("The server: "
                            + serverHostNameTextField.getText() + " on port: "
                            + serverPortNumberTextField.getText() + " is down.");
                    switchButtonState(connectServerButton, disconnectServerButton);
                    break;
                }
                appendLogText(message);
            }
        } catch (Exception e) {
            appendLogText(e.toString().contains("SocketException") ? "" : e.toString());
            Thread.currentThread().interrupt();
        }
    }

    private void switchButtonState(final JButton button1, final JButton button2) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                button1.setEnabled(true);
                button2.setEnabled(false);
            }
        });
    }
    private UniModelingGUI unModeingGUI = null;
    private static Connection conn = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Socket socket = null;
    private ObjectInputStream socketInput = null;
    private ObjectOutputStream socketOutput = null;
    private StreamSource streamSource = new StreamSource();
    private boolean simulationFlag = true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane activityLogScrollPane;
    private static javax.swing.JTextArea activityLogTextArea;
    private javax.swing.Box.Filler buttonFiller5;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel buttonPanel1;
    private javax.swing.JPanel buttonPanel2;
    private javax.swing.JButton clearLogButton;
    private javax.swing.JButton connectDatabaseButton;
    private javax.swing.JDialog connectDatabaseDialog;
    private javax.swing.JButton connectServerButton;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JScrollPane containerScrollPane;
    private javax.swing.JButton disconnectServerButton;
    private javax.swing.JComboBox driversComboBox;
    private javax.swing.JLabel driversLabel;
    private javax.swing.JButton endSimulationButton;
    private javax.swing.JScrollPane infoScrollPane;
    private static javax.swing.JTextArea infoTextArea;
    private javax.swing.JButton okButton;
    private javax.swing.JButton okButton1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel readRateLabel;
    private javax.swing.JSpinner readRateSpinner;
    private javax.swing.JButton registerStreamButton;
    private javax.swing.JDialog registerStreamDialog;
    private javax.swing.JLabel serverHostNameLabel;
    private javax.swing.JFormattedTextField serverHostNameTextField;
    private javax.swing.JLabel serverPortNumberLabel;
    private javax.swing.JFormattedTextField serverPortNumberTextField;
    private javax.swing.JButton startSimulationButton;
    private javax.swing.JScrollPane streamEncodingScrollPane;
    private static javax.swing.JTextArea streamEncodingTextArea;
    private javax.swing.JButton testButton;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}
