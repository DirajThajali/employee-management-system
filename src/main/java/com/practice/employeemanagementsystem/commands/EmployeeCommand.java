package com.practice.employeemanagementsystem.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCommand {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
