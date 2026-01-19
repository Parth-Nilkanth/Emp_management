    package com.empmanagement.empbackend.controller;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.empmanagement.empbackend.dto.EmployeeDto;
    import com.empmanagement.empbackend.service.EmployeeService;

    import lombok.AllArgsConstructor;

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

        @GetMapping("/home")
        public String getHome()
        {
            return "Home page";
        }
    }