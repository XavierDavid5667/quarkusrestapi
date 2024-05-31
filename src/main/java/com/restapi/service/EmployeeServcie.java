package com.restapi.service;

import com.restapi.entities.Employee;
import com.restapi.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeServcie {
    Employee getEmployeeById(int id) throws EmployeeNotFoundException;

    List<Employee> getAllEmployees();

    Employee updateEmployee(int id,Employee employee) throws EmployeeNotFoundException;

    Employee saveEmployee(Employee employee);

    void deleteEmployee(int id) throws EmployeeNotFoundException;
}
