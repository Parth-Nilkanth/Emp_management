package com.empmanagement.empbackend.mapper;

import com.empmanagement.empbackend.dto.EmployeeDto;
import com.empmanagement.empbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee emp){
        return new EmployeeDto(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                 emp.getEmail()

        );
    }

    public static Employee maptoEmployee(EmployeeDto empDto){
        return new Employee(
                empDto.getId(),
                empDto.getFirstName(),
                empDto.getLastName(),
                empDto.getEmail()
        );
    }

}