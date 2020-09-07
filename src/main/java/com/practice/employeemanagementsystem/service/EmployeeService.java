package com.practice.employeemanagementsystem.service;

import com.practice.employeemanagementsystem.model.Employee;

import java.util.Set;

public interface EmployeeService {

    public Set<Employee> getEmployees();

    public Employee findEmployeeById(Long id);
}
