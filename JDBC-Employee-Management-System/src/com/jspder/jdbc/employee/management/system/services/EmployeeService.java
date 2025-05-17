package com.jspder.jdbc.employee.management.system.services;
 
import java.util.List;

import com.jspder.jdbc.employee.management.system.dao.EmployeeDAO;
import com.jspder.jdbc.employee.management.system.entity.Employee;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public boolean addEmployee(Employee emp) {
        return employeeDAO.insertEmployee(emp);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public boolean updateEmployee(Employee emp) {
        return employeeDAO.updateEmployee(emp);
    }

    public boolean deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}