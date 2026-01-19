package com.empmanagement.empbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//when we use DTO class we exchange the data between client and server
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
