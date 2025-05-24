package com.infosys.jdbc_crud_project_Architecture.controller;

import java.util.List;

import com.infosys.jdbc_crud_project_Architecture.dto.Student;
import com.infosys.jdbc_crud_project_Architecture.service.StudentService;

public class GetStudentBasedOnAgeController {

	public static void main(String[] args) {


 		StudentService service = new StudentService();
		
		List<Student> allStudents = service.displayAllStdentByAgeLimit(20);
 
			 for (Student student : allStudents) {
				 System.out.println(student);    
				
			}
			 
			 
	 List<Student> allStudentOf18 = service.displayAllStdentByAgeLimit(18);
	 
	 allStudentOf18.forEach(System.out::println);

	 
	List<Student> allStudentOf15 = service.displayAllStdentByAgeLimit(15);

	allStudentOf15.forEach(System.out::println);

			
	List<Student> allStudentOf25 = service.displayAllStdentByAgeLimit(25);

	if (allStudentOf25.size()>0) 
	{
		allStudentOf25.forEach(System.out::println);
 
	} 
	else 
	{
          System.out.println("Age is not Older then"+25);
	}
 
 }

}
