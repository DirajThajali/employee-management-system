package com.practice.employeemanagementsystem.converter;

import com.practice.employeemanagementsystem.commands.EmployeeCommand;
import com.practice.employeemanagementsystem.model.Employee;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCommandToEmployeeConverter implements Converter<EmployeeCommand, Employee> {

    @Synchronized
    @Nullable
    @Override
    public Employee convert(EmployeeCommand source) {
        if (source != null) {
            Employee employee = new Employee();
            employee.setId(source.getId());
            employee.setFirstName(source.getFirstName());
            employee.setLastName(source.getLastName());
            employee.setEmail(source.getEmail());
            return employee;
        }
        return null;
    }
}
