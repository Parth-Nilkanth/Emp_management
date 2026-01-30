package com.empmanagement.empbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmanagement.empbackend.dto.EmployeeDto;
import com.empmanagement.empbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

    // in this project it is useful in order to allow reacr project to call the rest apis of 
    // spring boot project
    // allows all the client to call the rest APIS
    @CrossOrigin("*")
    @AllArgsConstructor
    @RestController
    @RequestMapping("api/employees")
    public class EmployeeController {

        private EmployeeService employeeService;

    //    build add employee rest api
        @PostMapping
        public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
            EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }

        @GetMapping("{id}")
        public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
            EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
            return ResponseEntity.ok(employeeDto);
        }

        //rest api to get all the employees
        @GetMapping()
        public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
            List<EmployeeDto> employees =  employeeService.getAllEmployees();
            return ResponseEntity.ok(employees);

        }
        //  build update Employee REST API
        @PutMapping("{id}")
        public ResponseEntity<EmployeeDto> updateEmployee( @PathVariable("id") Long employeeId , 
        @RequestBody EmployeeDto updatedEmployee)
        {
            EmployeeDto employeeDto =employeeService.updateEmployee(employeeId, updatedEmployee);
            return ResponseEntity.ok(employeeDto);
        }
        
        // build delete employee REST API
        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
        {
            employeeService.deleteEmployee(employeeId);
            return ResponseEntity.ok("Employee Deleted Sucessfully");
        }

        
    }