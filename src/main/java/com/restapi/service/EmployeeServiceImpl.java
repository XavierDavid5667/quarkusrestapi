package com.restapi.service;

import com.restapi.entities.Employee;
import com.restapi.exception.EmployeeNotFoundException;
import com.restapi.repostory.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EmployeeServiceImpl implements  EmployeeServcie{

    private EmployeeRepository employeeRepository;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        return employeeRepository.findByIdOptional((long) id).orElseThrow(()->new EmployeeNotFoundException("Employee with given id "+id+" not found!"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.listAll();
    }

    @Transactional
    @Override
    public Employee updateEmployee(int id, Employee employee) throws EmployeeNotFoundException {
        Employee employeeById = getEmployeeById(id);
        employeeById.setEmpName(employee.getEmpName());
        employeeById.setEmpAddress(employee.getEmpAddress());
        employeeRepository.persist(employeeById);
        return employeeById;
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        employeeRepository.persistAndFlush(employee);
        return employee;
    }
    @Transactional
    @Override
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
      employeeRepository.delete(getEmployeeById(id));
    }
}
