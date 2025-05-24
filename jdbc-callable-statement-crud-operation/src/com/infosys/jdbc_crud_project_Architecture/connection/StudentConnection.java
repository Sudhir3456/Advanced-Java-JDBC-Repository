package com.infosys.jdbc_crud_project_Architecture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class StudentConnection {
	
	
	private static final String url = "jdbc:mysql://localhost:3306/jdbc-m12";
	private static final String username = "root";
	private static final String password = "Sudhir@0108";

	public static Connection getStudentConnection() {
 
		try {

			// Step 1- load/register driver
			// Create the object of Driver(com.mysql.cj.jdbc) vlass to register

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// step 2- Create Connection

			Connection connection = DriverManager.getConnection(url, username, password);

			return connection;

		} catch (SQLException e) {
 			e.printStackTrace();

			return null;

		}

	}


}
