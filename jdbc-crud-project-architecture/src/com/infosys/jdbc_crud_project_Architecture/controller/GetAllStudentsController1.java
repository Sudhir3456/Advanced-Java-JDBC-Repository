package com.infosys.jdbc_crud_project_Architecture.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.infosys.jdbc_crud_project_Architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_Architecture.dto.Student;
 
public class GetAllStudentsController1 {
    
    // Method to calculate age based on date of birth
    public static int calculateAge(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    // Method to print students greater than a given age
    public static void printStudentsByAge(List<Student> students, int ageLimit) {
        System.out.println("\nStudents older than " + ageLimit + ":");
        for (Student student : students) {
            if (calculateAge(student.getDob()) > ageLimit) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {

        StudentDao dao = new StudentDao();

        // Fetch all students from the database
        List<Student> allStudents = dao.displayAllStdentDao();

        if (allStudents != null && !allStudents.isEmpty()) {
            // Print students based on different age conditions
            printStudentsByAge(allStudents, 20);
            printStudentsByAge(allStudents, 18);
            printStudentsByAge(allStudents, 15);
        } else {
            System.out.println("No students found in the database.");
        }
    }
}