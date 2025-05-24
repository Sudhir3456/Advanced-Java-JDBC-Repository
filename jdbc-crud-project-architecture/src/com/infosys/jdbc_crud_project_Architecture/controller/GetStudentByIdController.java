package com.infosys.jdbc_crud_project_Architecture.controller;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;

public class GetStudentByIdController {

	public static void main(String[] args) {


		StudentDao dao = new StudentDao();
		
		Student student = dao.displayStdentByIdDao(23456);
		
		
		if (student!=null) {
			System.out.println(student);

			
		} else {
			 
			System.out.println("Sothing wamt Wrong.....");


		}
		
 		
	}

}
