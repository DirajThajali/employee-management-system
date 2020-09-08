package com.practice.employeemanagementsystem.converter;

import com.practice.employeemanagementsystem.commands.EmployeeCommand;
import com.practice.employeemanagementsystem.model.Employee;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class EmployeeToEmployeeCommandConverter implements Converter<Employee, EmployeeCommand> {

    @Synchronized
    @Nullable
    @Override
    public EmployeeCommand convert(Employee source) {
        if (source != null) {
            EmployeeCommand employeeCommand = new EmployeeCommand();
            employeeCommand.setId(source.getId());
            employeeCommand.setFirstName(source.getFirstName());
            employeeCommand.setLastName(source.getLastName());
            employeeCommand.setEmail(source.getEmail());
            return employeeCommand;
        }
        return null;
    }
}
