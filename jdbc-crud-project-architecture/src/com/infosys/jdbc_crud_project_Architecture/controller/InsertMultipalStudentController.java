package com.infosys.jdbc_crud_project_Architecture.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;

public class InsertMultipalStudentController {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();

		Student student = new Student(45356, "Akashk", "aaksh@128965233gmail.com", LocalDate.parse("2003-08-17"),
				677887965);
		Student student1 = new Student(236896776, "Rakeshk", "Rakesh@12873gmail.com", LocalDate.parse("2002-08-19"),
				647788765);
		Student student2 = new Student(2489556, "rahulk", "rahul@16723gmail.com", LocalDate.parse("2013-08-17"),
				60780765);
		Student student3 = new Student(27809456, "Akashk", "Akash@1267783gmail.com", LocalDate.parse("2004-08-17"),
				67789765);

		List<Student> students = Arrays.asList(student, student1, student2, student3);

		dao.saveMultipalStdentDao(students);

	}

}
