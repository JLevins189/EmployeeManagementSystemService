package com.employeemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String location;
    private LocalDate dateStarted;
    private String manager;
}
