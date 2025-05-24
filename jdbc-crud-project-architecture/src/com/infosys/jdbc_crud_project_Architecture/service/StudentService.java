package com.infosys.jdbc_crud_project_Architecture.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;

public class StudentService {

	StudentDao dao = new StudentDao();

	public Student saveStdentService(Student student) {

		int year = student.getDob().getYear();

		if (year > 2000) {

			return dao.saveStdentDao(student);

		} else {

			System.err.println("Age is not Eligiable'");

			return null;

		}
	}
	
	 // Method to calculate age based on date of birth
    public static int calculateAge(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    List<Student> updatedlist = new ArrayList<Student>();

	public List<Student> displayAllStdentByAgeLimit(int ageLimit) {
		
		   System.out.println("\nStudents older than " + ageLimit + ":");
		   
		   List<Student> students = dao.displayAllStdentDao();
		 
     return students.stream().filter(student -> calculateAge(student.getDob())>ageLimit ).collect(Collectors.toList());
	 

	}
 

    // Method to filter students by age
 /*   public List<Student> getStudentsByMinAge(int minAge) {
        List<Student> allStudents = dao.displayAllStdentDao();
        
        return allStudents.stream()
                          .filter(student1 -> calculateAge(student1.getDob()) > minAge).collect(Collectors.toList());
    }  */
}
	
	

