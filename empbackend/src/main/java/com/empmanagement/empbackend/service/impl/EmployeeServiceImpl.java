package com.empmanagement.empbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.empmanagement.empbackend.dto.EmployeeDto;
import com.empmanagement.empbackend.entity.Employee;
import com.empmanagement.empbackend.entity.EmployeeRepository;
import com.empmanagement.empbackend.exception.ResourceNotFoundException;
import com.empmanagement.empbackend.mapper.EmployeeMapper;
import com.empmanagement.empbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId)
    {
        Employee emp = employeeRepository.findById(employeeId).
        orElseThrow(() -> new ResourceNotFoundException("Employee not exists with given id :" + employeeId));

        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmployees()
    {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map( (employee) -> EmployeeMapper.maptoEmployeeDto(employee)).collect(Collectors.toList());
    }

}