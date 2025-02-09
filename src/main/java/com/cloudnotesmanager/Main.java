package com.cloudnotesmanager; // This is a part of the Maven package which will help them use the file set up correctly.

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Some tests to make sure that I successfully connected to the RDS Database.
        // Connection conn = DatabaseConnector.getConnection();
        // if (conn != null) {
        //     System.out.println("Successfully connected to the database!");
        // } else {
        //     System.out.println("Failed to connect to the database.");
        // }

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        // Loop until the user chooses to exit.
        while (option != 3) {
            // Display the menu
            System.out.println("=================================");
            System.out.println("Welcome to CloudNotesManager!");
            System.out.println("Please select an option:");
            System.out.println("1. Simulate File Upload");
            System.out.println("2. View Cloud Database Data");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            // Get user input and handle invalid input gracefully
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                continue;
            }

            // Execute functionality based on user choice
            switch (option) {
                case 1:
                    simulateFileUpload();
                    break;
                case 2:
                    displayCloudDatabaseData();
                    break;
                case 3:
                    System.out.println("Exiting CloudNotesManager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // Blank line for readability
        }
        scanner.close();
    }

    // Simulate a file upload process
    private static void simulateFileUpload() {
        System.out.println("\nSimulating file upload...");
        // Simulate file upload logic here
        System.out.println("File uploaded successfully!");
    }

    // Display dummy cloud database data
    private static void displayCloudDatabaseData() {
        System.out.println("\nDisplaying data from the cloud database...");
        // Replace this with actual database access logic when ready
        System.out.println("User ID: 1 | File: notes.txt | Timestamp: 2025-01-28 14:30:00");
    }
}

