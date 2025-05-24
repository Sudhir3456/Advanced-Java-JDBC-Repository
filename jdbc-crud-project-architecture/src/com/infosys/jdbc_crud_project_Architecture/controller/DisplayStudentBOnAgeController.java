 package com.infosys.jdbc_crud_project_Architecture.controller;

import com.infosys.jdbc_crud_project_Architecture.dto.Student;
import com.infosys.jdbc_crud_project_Architecture.service.StudentService;
import java.util.List;

public class DisplayStudentBOnAgeController {
	
    public static void main(String[] args) {
    	
        StudentService studentService = new StudentService();

         List<Student> studentsAbove20 = studentService.displayAllStdentByAgeLimit(20);
         studentsAbove20.forEach(System.out::println);

         List<Student> studentsAbove18 = studentService.displayAllStdentByAgeLimit(18);
         studentsAbove18.forEach(System.out::println);

         List<Student> studentsAbove15 = studentService.displayAllStdentByAgeLimit(15);
         studentsAbove15.forEach(System.out::println);
         

         List<Student> studentsAbove5 = studentService.displayAllStdentByAgeLimit(75);
         studentsAbove15.forEach(System.out::println);
    }
}