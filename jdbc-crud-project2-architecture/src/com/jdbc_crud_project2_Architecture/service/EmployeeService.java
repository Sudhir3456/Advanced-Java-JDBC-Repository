package com.jdbc_crud_project2_Architecture.service;

import java.util.Scanner;

import com.jdbc_crud_project2_Architecture.dao.EmployeeDao;
import com.jdbc_crud_project2_Architecture.dto.Employee;

public class EmployeeService {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void getService(Employee employee) {
		
		int choice ;
		EmployeeDao dao = new EmployeeDao();
 		
		do {
			
			System.out.println("\n*** Employee Management System ***");
			System.out.println("1. Insert Student");
			System.out.println("2. Delete Student by ID");
			System.out.println("3. Display Student by ID");
			System.out.println("4. Update Student by ID");
			System.out.println("5. Display All Students");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				dao.saveEmployeeDao(choice);
				break;
			case 2:
				dao.deleteEmployeeById();
				break;
			case 3:
				dao.displayStdentByIdDao(choice);
				break;
			case 4:
				EmployeeDao.updateEmployeeById();
				break;
			case 5:
				EmployeeDao.displayAllEmployees();
				break;
			case 6:
				System.out.println("Exiting... Thank you!");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		} while (choice != 6);
	}

}
