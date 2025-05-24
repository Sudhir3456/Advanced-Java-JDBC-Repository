package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jspider.jdbc_simple_crud_operation.connection.CustomerConnection;

public class InsertCoustomerController {

	public static void main(String[] args) {

		
 		
		Connection connection =CustomerConnection.getCoustomerConnection();
         
		if (connection!=null) {
			
			String insertCoustomerQuery="insert into customer(id,name,email, phone, address) values(?,?,?,?,?)";

			try {
				PreparedStatement preparedStatement=connection.prepareStatement(insertCoustomerQuery);
				
				preparedStatement.setInt(1, 140);
				preparedStatement.setString(2, "Rajesh");
				
				preparedStatement.setString(3, "Rajesh@12.gmail.com");
				preparedStatement.setLong(4, 7878906545l);
				preparedStatement.setString(5, "agra");
				
				int status =preparedStatement.executeUpdate();
				
 				if (status!=0) {
					
 					
 					System.out.println("data inserted");
				} else {

 					System.out.println("data  not inserted");

				}
				
				
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

			
		} else {
			
			System.err.println("Check ypur connection Class");

		}
		
	 
		
	}

}
