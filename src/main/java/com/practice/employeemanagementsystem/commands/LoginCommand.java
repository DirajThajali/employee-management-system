package com.practice.employeemanagementsystem.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCommand {

    private Long id;

    private String userName;

    private String password;
}
