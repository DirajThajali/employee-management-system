package com.practice.employeemanagementsystem.controllers;

import com.practice.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees/list";
    }

    @GetMapping("/employees/{id}/view")
    public String viewEmployeeDetail(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeService.findEmployeeById(Long.valueOf(id)));
        return "employees/detail";
    }
}
