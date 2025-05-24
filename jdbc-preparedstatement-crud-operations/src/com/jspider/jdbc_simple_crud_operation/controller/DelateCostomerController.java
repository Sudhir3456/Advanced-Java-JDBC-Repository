package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jspider.jdbc_simple_crud_operation.connection.CustomerConnection;

public class DelateCostomerController {

	public static void main(String[] args) throws ClassNotFoundException {
 
		Connection connection = CustomerConnection.getCoustomerConnection();
         
		if (connection!=null) {
			
			String deleteCoustomerQuery="DELETE FROM customer WHERE id=?";

			try {
				PreparedStatement preparedStatement=connection.prepareStatement(deleteCoustomerQuery);
				
				preparedStatement.setInt(1, 123);

				int satus = preparedStatement.executeUpdate();

				if (satus != 0) {

					System.out.println("data DELETED From table");

				} else {
					System.out.println("data not DELETED in table");

				}

			} catch (SQLException e) {
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
}
