/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OZT00106
 */
public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    
    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());

    private DBConnection() {
        try {
            // Registering the driver (optional, modern JDBC can auto-register)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/megacitycab?user=root&password=CBCINTERN&useSSL=false"
            );
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Error establishing database connection", e);
        }
    }

    // Singleton pattern to ensure a single instance
    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    // Returns the current database connection
    public Connection getConnection() {
        return connection;
    }

    // Closes the connection when done
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;  // Set to null to avoid re-use after closing
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error closing database connection", e);
            }
        }
    }
    
}
