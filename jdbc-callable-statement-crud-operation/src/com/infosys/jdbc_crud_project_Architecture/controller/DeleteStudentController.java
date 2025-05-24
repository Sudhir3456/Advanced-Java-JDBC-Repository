package com.infosys.jdbc_crud_project_Architecture.controller;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;

public class DeleteStudentController {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();

		dao.deleteStudentByIdDao(2666);

	}

}
