package com.infosys.jdbc_crud_project_Architecture.controller;

import java.util.List;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;

public class GetAllStudentsController {

	public static void main(String[] args) {

	StudentDao dao = new StudentDao();
		
	List<Student> allStudents = dao.displayAllStdentDao();
		
		 for (Student student : allStudents) {
			 System.out.println(student);
			
		}
		
		
	}

}
