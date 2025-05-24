package com.infosys.jdbc_crud_project_Architecture.controller;

import java.time.LocalDate;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;

public class InsertStudentsController {

	public static void main(String[] args) {

        StudentDao dao = new StudentDao();
        
      //  dao.deleteStudentByIdDao(23456);
        
        Student student = new Student(2666, "insha", "isha@126833gmail.com", LocalDate.parse("2003-08-17"), 677887965);

		
        dao.saveStdentDao(student);
		
		
	}

}
