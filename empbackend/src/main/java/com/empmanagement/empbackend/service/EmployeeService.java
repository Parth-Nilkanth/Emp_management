package com.empmanagement.empbackend.service;

import java.util.List;

import com.empmanagement.empbackend.dto.EmployeeDto;
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();
}
