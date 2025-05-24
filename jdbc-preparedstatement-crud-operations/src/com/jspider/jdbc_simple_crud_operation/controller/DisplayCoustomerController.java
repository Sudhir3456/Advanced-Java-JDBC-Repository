package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.jdbc_simple_crud_operation.connection.CustomerConnection;

public class DisplayCoustomerController {

	public static void main(String[] args) throws ClassNotFoundException {

		Connection connection = CustomerConnection.getCoustomerConnection();

		try {

			String query = "select * from customer";

			// Step3- Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) { // here we take if block if column contain uniqe element

				int id = resultSet.getInt("id");
				String CoustomerName = resultSet.getString("name");
				Long phone = resultSet.getLong("phone");
				String address = resultSet.getString("address");
				String email = resultSet.getString("email");

				System.out.println(id); //
				System.out.println(CoustomerName);
				System.out.println(phone);
				System.out.println(address);
				System.out.println(email);

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
