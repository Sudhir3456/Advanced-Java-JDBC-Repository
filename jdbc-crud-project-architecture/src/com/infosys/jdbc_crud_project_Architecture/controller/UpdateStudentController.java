package com.infosys.jdbc_crud_project_Architecture.controller;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;

public class UpdateStudentController {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();

		String msg = dao.updateStudentById(24556,787888887l);

		if (msg != null) {
			System.out.println(msg);

		} else {

			System.out.println("Sothing wamt Wrong.....");

		}
		 
		
	}

}



//Create  a Employee Class wuth attribute id name dob email 