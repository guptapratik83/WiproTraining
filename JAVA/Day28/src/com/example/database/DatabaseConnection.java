package com.example.database;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    // Add your database connection variables here

    // Private constructor to prevent instantiation from outside
    private DatabaseConnection() {
        System.out.println("Creating DatabaseConnection instance...");
        // Initialize database connection here
    }

    // Public static method to get the instance of the singleton class
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Add your database connection methods here
}
