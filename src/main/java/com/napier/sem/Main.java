package com.napier.sem;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        // Connect to the local MongoDB Docker container instance
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            System.out.println("Connecting to database...");

            // Get database (creates it if it doesn't exist)
            MongoDatabase database = mongoClient.getDatabase("test_db");

            System.out.println("Successfully linked to MongoDB container!");
        } catch (Exception e) {
            System.out.println("Failed to connect to MongoDB container.");
            e.printStackTrace();
        }
    }
}