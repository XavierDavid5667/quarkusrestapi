package com.restapi.controller;

import com.restapi.dto.EmployeeDto;
import com.restapi.entities.Employee;
import com.restapi.exception.EmployeeNotFoundException;
import com.restapi.service.EmployeeServcie;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api")
public class EmployeeController {

    private EmployeeServcie employeeServcie;

    @Inject
    public EmployeeController(EmployeeServcie employeeServcie) {
        this.employeeServcie = employeeServcie;
    }

    @Path("/getEmployees")
    @GET
    public List<Employee> getEmployees() {
        return employeeServcie.getAllEmployees();
    }

    @Path("/getEmployeeById/{id}")
    @GET
    public Employee getEmployeeById(@PathParam("id") int id) throws EmployeeNotFoundException {
        return employeeServcie.getEmployeeById(id);
    }

    @Path("/createEmployee")
    @POST
    public  Employee createEmployee( @Valid EmployeeDto employee) {
        return employeeServcie.saveEmployee(employee.toEmployee());
    }

    @PUT
    @Path("/updateEmployee/{id}")
    public  Employee updateEmployee(int id,@Valid EmployeeDto employeeDto) throws EmployeeNotFoundException {
        return  employeeServcie.updateEmployee(id,employeeDto.toEmployee());
    }

    @DELETE
    @Path("/deleteEmployee/{id}")
    public  void deleteEmployee(int id) throws EmployeeNotFoundException {
        employeeServcie.    deleteEmployee(id);
    }

}
