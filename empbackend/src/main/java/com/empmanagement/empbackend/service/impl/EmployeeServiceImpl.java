package com.empmanagement.empbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

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
        List<EmployeeDto> empList = new ArrayList<>();
        for(Employee e : employees)
        {
            empList.add(EmployeeMapper.mapToEmployeeDto(e));
        }
        return empList;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            ()->  new ResourceNotFoundException("Employee with the given id does not exist " +  employeeId)
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObject =employeeRepository.save(employee);
        EmployeeDto updatedEmployeeDto = EmployeeMapper.mapToEmployeeDto(updatedEmployeeObject);
        return updatedEmployeeDto;
    }

    @Override
    public void deleteEmployee(Long employeeId){
        Employee emp = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee with id not exist")
         );
        employeeRepository.deleteById(employeeId);
    }

}