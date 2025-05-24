package com.jdbc_crud_project2_Architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.jdbc_crud_project2_Architecture.connection.EmployeeConnection;
import com.jdbc_crud_project2_Architecture.dto.Employee;

public class EmployeeDao {

	Connection connection = EmployeeConnection.getEmployeeConnection1();

	String insertStudentQuery = "insert into employee(id,name,email, dob, phone) values(?,?,?,?,?)";

	public Employee saveEmployeeDao(Employee employee) throws ClassNotFoundException {

		String insertStudentQuery = "insert into employee(id,name,email, dob, phone) values(?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(insertStudentQuery);

			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());

			ps.setString(3, employee.getEmail());
			ps.setObject(4, employee.getDob(null));
			ps.setLong(5, employee.getPhone());
			int status = ps.executeUpdate();

			if (status != 0) {

				System.out.println("data inserted");
				return employee;
			} else {

				System.out.println("data  not inserted");
				return null;

			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

	}

	// dISPLAY student===
	String displayEmployeeByIdQuery = "select * from employee where id=?";

	public Employee displayStdentByIdDao(int empid) {

		try {
			PreparedStatement ps = connection.prepareStatement(displayEmployeeByIdQuery);

			ps.setInt(1, empid);

			ResultSet set = ps.executeQuery();

			if (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				String phone = set.getString("phone");
				LocalDate dob = set.getDate("dob").toLocalDate();

				Employee employee = new Employee();

				employee.setId(id);
				employee.setName(name);
				employee.setEmail(email);
 				employee.setName(phone);

				return employee;

			} else {

				System.out.println("data  not inserted");
				return null;

			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

	}

	public void deleteEmployeeById() {
 		
	}

}
