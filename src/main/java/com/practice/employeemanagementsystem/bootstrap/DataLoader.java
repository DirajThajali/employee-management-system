package com.practice.employeemanagementsystem.bootstrap;

import com.practice.employeemanagementsystem.model.Employee;
import com.practice.employeemanagementsystem.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = Employee.builder().firstName("Diraj")
                .lastName("Thajali").email("thajalidiraj@gmail.com").build();
        Employee employee2 = Employee.builder().firstName("Dipika")
                .lastName("Thajali").email("dipikathajali@gmail.com").build();

        Employee savedEmployee1 = employeeRepository.save(employee1);
        Employee savedEmployee2 = employeeRepository.save(employee2);

        log.debug("Employee loaded with ID: " + savedEmployee1.getId());
        log.debug("Employee loaded with ID: " + savedEmployee2.getId());

    }
}
