package com.practice.employeemanagementsystem.controllers;

import com.practice.employeemanagementsystem.commands.EmployeeCommand;
import com.practice.employeemanagementsystem.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class EmployeeController {

    private static final String EMPLOYEE_FORM_URL = "employees/createupdateform";

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

    @GetMapping("/employees/new")
    public String createEmployee(Model model) {
        model.addAttribute("employeeCommand", new EmployeeCommand());
        model.addAttribute("action", "Add Employee");
        return EMPLOYEE_FORM_URL;
    }

    @PostMapping("/employees/handleform")
    //add @Valid annotation on model attribute
    public String handleCreateOrUpdate(@ModelAttribute EmployeeCommand employeeCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.debug("Error while Binding EmployeeCommand to Employee");
            return EMPLOYEE_FORM_URL;
        }
        EmployeeCommand savedEmployeeCommand = employeeService.saveEmployeeCommand(employeeCommand);
        return "redirect:/employees/" + savedEmployeeCommand.getId() + "/view";
    }

    @GetMapping("/employees/{id}/update")
    public String updateEmployee(@PathVariable String id, Model model) {
        model.addAttribute("employeeCommand", employeeService.findEmployeeCommandById(Long.valueOf(id)));
        model.addAttribute("action", "Update Employee");
        return EMPLOYEE_FORM_URL;
    }

}
