package com.infosys.jdbc_crud_project_Architecture.controller;

import java.time.LocalDate;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;
import com.infosys.jdbc_crud_project_Architecture.service.StudentService;

public class InsertStudentController {

	public static void main(String[] args) {
		

          StudentService service = new StudentService();
		
          Student student = new Student(237556566, "Rakesh", "rah@126885233gmail.com", LocalDate.parse("2003-08-17"), 697887965);

		service.saveStdentService(student);
		
		
		
		
/*
 * 
 * 		
  
		
		
        Student student = new Student(23456, "Akash", "aaksh@1265233gmail.com", LocalDate.parse("2003-08-17"), 677887965);
        Student student1 = new Student(23676, "Rakesh", "Rakesh@123gmail.com", LocalDate.parse("2002-08-19"), 647788765);
        Student student2= new Student(24556, "rahul", "rahul@123gmail.com", LocalDate.parse("2013-08-17"), 60780765);
        Student student3 = new Student(209456, "Akash", "Akash@12673gmail.com", LocalDate.parse("2004-08-17"), 67789765);
        Student student4 = new Student(289456, "Akashika", "Akashika@123gmail.com", LocalDate.parse("2003-08-16"), 98788765);
        Student student5 = new Student(230056, "sonu", "sonu@12673gmail.com", LocalDate.parse("2003-06-14"), 609788765);
        Student student6 = new Student(29056, "Sarvind", "Sarvind@12563gmail.com", LocalDate.parse("2000-08-11"), 678988765);
        Student student7 = new Student(29056, "Govind", "Govind@12893gmail.com", LocalDate.parse("2005-08-17"), 690785765);
        Student student8 = new Student(295656, "Ganesh", "Ganesh@12783gmail.com", LocalDate.parse("2000-08-17"), 787988765);
        Student student9 = new Student(88456, "Suraj", "Suraj@12123gmail.com", LocalDate.parse("2001-08-17"), 670988765);
        Student student10 = new Student(209456, "Anil", "Anil@12333gmail.com", LocalDate.parse("2003-08-10"), 624678765);

		
       // dao.saveStdentDao(student);
        
        dao.saveStdentDao(student1);
        dao.saveStdentDao(student2); 
        dao.saveStdentDao(student3);
        dao.saveStdentDao(student4);
        dao.saveStdentDao(student5);
        dao.saveStdentDao(student6);
        dao.saveStdentDao(student7);
        dao.saveStdentDao(student8);
        dao.saveStdentDao(student9);

		*/
		
	}

}
