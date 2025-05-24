package com.jspider.jdbc_simple_crud_operation.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD_op {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc-m12";
    private static final String USER = "root";
    private static final String PASSWORD = "Sudhir@0108";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Step 1: Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");

            // Step 2: Create the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");

            // Perform CRUD operations
            // CREATE
            String insertQuery = "INSERT INTO employees (name, age, salary, department) VALUES (?, ?, ?, ?)";
            executeUpdate(connection, insertQuery, "Alice", 25, 30000, "Finance");

            String insertQuery2 = "INSERT INTO employees (name, age, salary, department) VALUES (?, ?, ?, ?)";
            executeUpdate(connection, insertQuery2, "Bob", 30, 34000, "Marketing");

            // READ
            String selectQuery = "SELECT * FROM employees";
            executeQuery(connection, selectQuery);

            // UPDATE
            String updateQuery = "UPDATE employees SET name = ?, age = ?, department = ? WHERE id = ?";
            executeUpdate(connection, updateQuery, "Alice Updated", 26, "Finance", 1);

            // DELETE
            String deleteQuery = "DELETE FROM employees WHERE id = ?";
            executeUpdate(connection, deleteQuery, 2);

            // Final READ to confirm changes
            executeQuery(connection, selectQuery);

        } catch (ClassNotFoundException e) {
            System.err.println("Error loading driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } finally {
            // Step 3: Close the connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // Method to execute UPDATE queries (Insert, Update, Delete)
    private static void executeUpdate(Connection connection, String query, Object... params) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        }
    }

    // Method to execute SELECT query (Read)
    private static void executeQuery(Connection connection, String query) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("\nEmployee Details:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Double salary = resultSet.getDouble("salary");
                String department = resultSet.getString("department");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department);
            }
        }
    }
}