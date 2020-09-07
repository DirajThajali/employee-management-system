package com.practice.employeemanagementsystem.service;

import com.practice.employeemanagementsystem.model.Employee;
import com.practice.employeemanagementsystem.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Set<Employee> getEmployees() {
        return new HashSet<>(employeeRepository.findAll());
    }
}
