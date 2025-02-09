package com.cloudnotesmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DOCUMENTATION:
// This class is needed to provide the information to hook into AWS. This uses the AWS endpoints to connect to my database on their and access the database. 
// That way I can make create file methods and etc. 
public class DatabaseConnector {
    // Connection details based on your RDS instance settings
    private static final String ENDPOINT = "cloudnotesmanager-db.c1asqmky2w1g.us-east-2.rds.amazonaws.com";
    private static final String PORT = "3306";
    private static final String DATABASE = "cloudnotesmanager-db";
    
    // Remember to replace these placeholder values with your actual credentials when I have access to them
    private static final String USERNAME = "admin"; 
    private static final String PASSWORD = "UydeFL3RNmo6B9UiG2Gc"; 

    // This builds the link.
    public static Connection getConnection() {
        // Build the JDBC URL. The additional parameters disable SSL (if you're not using it)
        // and set the server's timezone. Adjust these if needed.
        String jdbcUrl = "jdbc:mysql://" + ENDPOINT + ":" + PORT + "/" + DATABASE +
                        "?useSSL=false&serverTimezone=UTC";
        
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, USERNAME, PASSWORD);
            System.out.println("Connected to Amazon RDS successfully!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Error connecting to the Amazon RDS database:");
            e.printStackTrace();
            return null;
        }
    }
}


// This is the only time you can view this password. Copy and save the password for your reference. If you lose the password, you must modify your database to change it. You can use a SQL client application or utility to connect to your database.
// Learn about connecting to your database 
// Master username
// admin
// Master password
// UydeFL3RNmo6B9UiG2Gc
// Endpoint
// cloudnotesmanager-db.c1asqmky2w1g.us-east-2.rds.amazonaws.com