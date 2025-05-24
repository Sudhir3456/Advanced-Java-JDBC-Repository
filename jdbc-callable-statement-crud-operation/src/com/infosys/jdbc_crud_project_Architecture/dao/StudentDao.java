package com.infosys.jdbc_crud_project_Architecture.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.infosys.jdbc_crud_project_Architecture.connection.StudentConnection;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;

public class StudentDao {

	Connection connection = StudentConnection.getStudentConnection();

	public boolean deleteStudentByIdDao(int id) {

		try {

			CallableStatement callableStatement = connection.prepareCall("call deleteStudentById(?)");

			callableStatement.setInt(1, id);

			int a = callableStatement.executeUpdate();

			if (a != 0) {

				System.out.println("Student Deleted");
				return true;
			} else {
				System.out.println("Student Not Deleted");
				return false;

			}

		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}
	
	
	public Student saveStdentDao(Student student) {

		try {
			
            CallableStatement ps = connection.prepareCall("call insertStudent(?,?,?,?,?)") ;
			
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());

			ps.setString(3, student.getEmail());
			ps.setObject(4, student.getDob());
			ps.setLong(5, student.getPhone());

			int status = ps.executeUpdate();

			if (status != 0) {

				System.out.println("data inserted");
				return student;
			} else {

				System.out.println("data  not inserted");
				return null;

			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

	}
	
	

}
