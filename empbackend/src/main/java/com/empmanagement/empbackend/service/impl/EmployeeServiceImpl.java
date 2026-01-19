package com.empmanagement.empbackend.service.impl;

import org.springframework.stereotype.Service;

import com.empmanagement.empbackend.dto.EmployeeDto;
import com.empmanagement.empbackend.entity.Employee;
import com.empmanagement.empbackend.entity.EmployeeRepository;
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
        return EmployeeMapper.mapToEmplyeeDto(savedEmployee);
    }

    // @Override
    // public EmployeeDto getEmployeeById(Long employeeId)
    // {
    //     employeeRepository.findById(employeeId).orElseThrow() -> new ResourceNotFoundException("Employee not exists with given id :" + employeeId);
    //     return null;
    // }

}