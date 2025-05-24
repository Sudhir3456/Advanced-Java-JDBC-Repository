package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jspider.jdbc_simple_crud_operation.connection.CustomerConnection;

public class UpdateCoustomerController {

	public static void main(String[] args) {

		Connection connection = CustomerConnection.getCoustomerConnection();

		if (connection != null) {

			String updateCoustomerQuery = "update customer set name=(?) WHERE id=(?)";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(updateCoustomerQuery);

				preparedStatement.setString(1, "Rakesh");
				preparedStatement.setInt(2, 120);

				int satus = preparedStatement.executeUpdate();

				if (satus != 0) {

					System.out.println("data Updated From table");

				} else {
					System.out.println("data not Updated in table");

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
