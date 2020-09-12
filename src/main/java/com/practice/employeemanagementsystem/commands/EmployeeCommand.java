package com.practice.employeemanagementsystem.commands;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Getter
@Setter
public class EmployeeCommand {

    private Long id;

    @Size(min = 3, max = 30)
    @NotEmpty
    private String firstName;

    @Size(min = 3, max = 30)
    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty
    private String email;
}
