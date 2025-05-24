package com.infosys.jdbc_crud_project_Architecture.controller;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;

public class DeleteStudentById {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();

		String msg = dao.delateStudentById(289456);

		if (msg != null) {
			System.out.println(msg);

		} else {

			System.out.println("Sothing wamt Wrong.....");

		}

	}

}
