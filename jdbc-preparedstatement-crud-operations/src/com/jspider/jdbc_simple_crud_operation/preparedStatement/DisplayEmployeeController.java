package com.jspider.jdbc_simple_crud_operation.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayEmployeeController {

	private static final String url = "jdbc:mysql://localhost:3306/jdbc-m12";
	private static final String username = "root";
	private static final String password = "Sudhir@0108";

	public static void main(String[] args) {

		Connection connection = null;

		try {
			// Step1- load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2- create connection

			connection = DriverManager.getConnection(url, username, password);

			System.out.println(connection);

			String query = "select * from employees";

			// Step3- Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {                      //here we take if block if column contain uniqe element 

				int id = set.getInt("id");
				String employeeName = set.getString("name");
				int age = set.getInt("age");
				double salary = set.getDouble("salary");
				String department = set.getString("department");
 
				System.out.println(id); //
				System.out.println(employeeName);
				System.out.println(age);
				System.out.println(salary);
				System.out.println(department);


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