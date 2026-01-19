package com.empmanagement.empbackend.entity;

import org.springframework.data.jpa.repository.JpaRepository;
               //pass the table name and then the data type of the primary key of the table
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
