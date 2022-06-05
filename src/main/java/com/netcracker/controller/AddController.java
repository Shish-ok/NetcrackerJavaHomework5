package com.netcracker.controller;

import com.netcracker.dto.EmployeeDto;
import com.netcracker.model.Employee;
import com.netcracker.service.EmployeeService;
import com.netcracker.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {

    private final ValidationService validationService;

    private final EmployeeService employeeService;

    @Autowired
    public AddController(ValidationService validationService, EmployeeService employeeService) {
        this.validationService = validationService;
        this.employeeService = employeeService;
    }

    @GetMapping("/add-employee")
    public String addForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "add-employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute EmployeeDto employeeDto) {
        if (!validationService.validateEmployee(employeeDto)) {
            return "redirect:/add-error";
        }
        if (!employeeService.saveEmployee(new Employee(employeeDto))) {
            return "redirect:/exist-error";
        }

        return "redirect:/add-employee";
    }

    @GetMapping("/add-error")
    public String addError() {
        return "add-error";
    }

    @GetMapping("/exist-error")
    public String existError() {
        return "exist-error";
    }
}