package com.jspider.jdbc_simple_crud_operation.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployeecotrloer {

	private static final String url = "jdbc:mysql://localhost:3306/jdbc-m12";
	private static final String username = "root";
	private static final String password = "Sudhir@0108";

	static Connection connection = null;

	public static void main(String[] args) {

		try {
			// Step1- load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, username, password);

			System.out.println(connection);

			String query = "DELETE FROM employees WHERE id=?";

			// Step3- Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 44);

			int satus = preparedStatement.executeUpdate();

			if (satus != 0) {

				System.out.println("data DELETED From table");

			} else {
				System.out.println("data not DELETED in table");

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();

				System.out.println("Closed Connections");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
