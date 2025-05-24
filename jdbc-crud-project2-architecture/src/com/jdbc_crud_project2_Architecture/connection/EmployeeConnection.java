package com.jdbc_crud_project2_Architecture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConnection {

	private static final String url = "jdbc:mysql://localhost:3306/jdbc-m12";
	private static final String username = "root";
	private static final String password = "Sudhir@0108";

	public static Connection getEmployeeConnection1()   {

		
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2- create connection
			// Connection connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m12",
			// "root","Sudhir@0108");

			connection = DriverManager.getConnection(url, username, password);
			
			return connection;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

			return null;

		}

	}

}	 