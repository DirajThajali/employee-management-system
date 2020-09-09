package com.practice.employeemanagementsystem.service;

import com.practice.employeemanagementsystem.commands.EmployeeCommand;
import com.practice.employeemanagementsystem.converter.EmployeeCommandToEmployeeConverter;
import com.practice.employeemanagementsystem.converter.EmployeeToEmployeeCommandConverter;
import com.practice.employeemanagementsystem.exceptions.NotFoundException;
import com.practice.employeemanagementsystem.model.Employee;
import com.practice.employeemanagementsystem.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeCommandToEmployeeConverter employeeCommandToEmployeeConverter;
    private final EmployeeToEmployeeCommandConverter employeeToEmployeeCommandConverter;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeCommandToEmployeeConverter employeeCommandToEmployeeConverter, EmployeeToEmployeeCommandConverter employeeToEmployeeCommandConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeCommandToEmployeeConverter = employeeCommandToEmployeeConverter;
        this.employeeToEmployeeCommandConverter = employeeToEmployeeCommandConverter;
    }

    @Override
    public Set<Employee> getEmployees() {
        return new HashSet<>(employeeRepository.findAll());
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new NotFoundException("Employee Not Found with ID :" + id);
        }
        return optionalEmployee.get();
    }

    @Override
    public EmployeeCommand findEmployeeCommandById(Long employeeCommandId) {
        return employeeToEmployeeCommandConverter.convert(findEmployeeById(employeeCommandId));
    }

    @Override
    public EmployeeCommand saveEmployeeCommand(EmployeeCommand employeeCommand) {
        Employee detachedEmployee = employeeCommandToEmployeeConverter.convert(employeeCommand);

        Employee savedEmployee = employeeRepository.save(detachedEmployee);
        log.debug("Employee Saved With ID: " + savedEmployee.getId());
        return employeeToEmployeeCommandConverter.convert(savedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
