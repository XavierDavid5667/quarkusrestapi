package com.restapi.dto;

import com.restapi.entities.Employee;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {

    @NotBlank
    private String empName;
    @NotBlank
    private String empAddress;

    public Employee toEmployee(){
        Employee employee = new Employee();
        employee.setEmpName(this.getEmpName());
        employee.setEmpAddress(this.empAddress);
        return employee;
    }
}
