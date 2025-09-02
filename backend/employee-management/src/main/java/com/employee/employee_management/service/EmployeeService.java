package com.employee.employee_management.service;


import com.employee.employee_management.model.Employee;
import com.employee.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        if (employee.getName() == null || employee.getEmail() == null || employee.getDepartment() == null) {
            throw new IllegalArgumentException("All fields are mandatory!");
        }
        employeeRepository.save(employee);

        return employeeRepository.save(employee);
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}