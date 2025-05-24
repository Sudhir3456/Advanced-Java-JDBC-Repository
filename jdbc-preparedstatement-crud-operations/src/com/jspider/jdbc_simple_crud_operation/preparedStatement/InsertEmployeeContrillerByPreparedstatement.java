package com.jspider.jdbc_simple_crud_operation.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployeeContrillerByPreparedstatement {
	
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
			
             String query = "insert into employees(id,name,age,salary,department) values(?,?,?,?,?)";
			
			// Step3- Create Statement 
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            
            //set the values to query
            preparedStatement.setInt(1, 44);
            preparedStatement.setString(2, "Shikha");
            preparedStatement.setInt(3, 23);
            preparedStatement.setDouble(4, 22000);
            preparedStatement.setString(5, "Manual Tester");
            
			// Step4- Execute Query
 
			int satus = preparedStatement.executeUpdate();

			if (satus != 0) {

				System.out.println("data inserted in table");

			} else {
				System.out.println("data not inserted in table");

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



