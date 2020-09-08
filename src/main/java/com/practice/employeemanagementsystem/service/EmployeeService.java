package com.practice.employeemanagementsystem.service;

import com.practice.employeemanagementsystem.commands.EmployeeCommand;
import com.practice.employeemanagementsystem.model.Employee;

import java.util.Set;

public interface EmployeeService {

    Set<Employee> getEmployees();

    Employee findEmployeeById(Long id);

    EmployeeCommand saveEmployeeCommand(EmployeeCommand employeeCommand);
}
