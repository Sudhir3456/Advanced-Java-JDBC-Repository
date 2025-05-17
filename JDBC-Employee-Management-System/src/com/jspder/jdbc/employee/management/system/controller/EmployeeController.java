package com.jspder.jdbc.employee.management.system.controller;


import java.util.Scanner;

import com.jspder.jdbc.employee.management.system.entity.Employee;
import com.jspder.jdbc.employee.management.system.services.EmployeeService;

public class EmployeeController {
    private static EmployeeService service = new EmployeeService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Employee\n2. View Employee\n3. View All Employees\n4. Update Employee\n5. Delete Employee\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter DOB: ");
                    String dob = sc.nextLine();

                    Employee emp = new Employee(0, name, email, phone, dob);
                    System.out.println(service.addEmployee(emp) ? "Employee Added!" : "Failed!");
                    break;
                
                case 6:
                    System.exit(0);
            }
        }
    }
}