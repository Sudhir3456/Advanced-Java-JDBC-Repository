package com.infosys.jdbc_crud_project_Architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infosys.jdbc_crud_project_Architecture.connection.StudentConnection;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;

public class StudentDao {

	Connection connection = StudentConnection.getStudentConnection();

	String insertStudentQuery = "insert into student1(id,name,email, dob, phone) values(?,?,?,?,?)";

	public Student saveStdentDao(Student student) {

		try {
			PreparedStatement ps = connection.prepareStatement(insertStudentQuery);

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

	// dISPLAY student===
	String displayStudentByIdQuery = "select * from student1 where id=?";

	public Student displayStdentByIdDao(int stuid) {

		try {
			PreparedStatement ps = connection.prepareStatement(displayStudentByIdQuery);

			ps.setInt(1, stuid);

			ResultSet set = ps.executeQuery();

			if (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				Long phone = set.getLong("phone");
				LocalDate dob = set.getDate("dob").toLocalDate();

				Student student = new Student();

				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setDob(dob);
				student.setPhone(phone);

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

	// Display All Student From databases

	String selectAllStudentQuery = "select * from student1";

	public List<Student> displayAllStdentDao() {

		try {
			PreparedStatement ps = connection.prepareStatement(selectAllStudentQuery);

			ResultSet set = ps.executeQuery();

			List<Student> students = new ArrayList<Student>();

			while (set.next()) {

				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				Long phone = set.getLong("phone");
				LocalDate dob = set.getDate("dob").toLocalDate();

				Student student = new Student();

				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setDob(dob);
				student.setPhone(phone);

				students.add(student);

			}

			return students;

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

	}

	// Deleate

	String delateStudentQuery = "DELETE FROM student1 WHERE id=?";

	public String delateStudentById(int stuid) {

		try {
			PreparedStatement ps = connection.prepareStatement(delateStudentQuery);

			ps.setInt(1, stuid);

			// ps.setInt(1,209456);

			int satus = ps.executeUpdate();

			if (satus != 0) {

				String msg = "data DELETED From the table";
				return msg;

			} else {
				System.out.println("data not DELETED From the table");
				return null;
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

	}

	// Updated

	String updateStudentQuery = "UPDATE student1 set phone=? WHERE id=?";
	String updateCoustomerQuery = "update student1 set name=(?) WHERE id=(?)";
	

	public String updateStudentById(int stuid, Long phone) {

		try {
			PreparedStatement ps = connection.prepareStatement(updateCoustomerQuery);

			ps.setLong(1, phone);
			ps.setInt(2, stuid);

			int satus = ps.executeUpdate();

			if (satus != 0) {

				String msg = "data Updated From the table";
				return msg;

			} else {
				System.out.println("data not Updated From the table");
				return null;
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

	}
	
	 
	

	// iNSERT MULTIPAL DATA AT TIME USING BATCH PROCING

	String insertStudentQuery1 = "insert into student1(id,name,email, dob, phone) values(?,?,?,?,?)";

	public List<Student> saveMultipalStdentDao(List<Student> students) {

		try {
			PreparedStatement ps = connection.prepareStatement(insertStudentQuery1);

			for (Student student : students) {

				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());

				ps.setString(3, student.getEmail());
				ps.setObject(4, student.getDob());
				ps.setLong(5, student.getPhone());
				ps.addBatch();

			}

			int a[] = ps.executeBatch();

			if (a.length != 0) {

				System.out.println("data inserted");
				return students;
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
