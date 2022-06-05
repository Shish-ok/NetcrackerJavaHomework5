package com.netcracker.controller;

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
public class SearchController {

    private final ValidationService validationService;

    private final EmployeeService employeeService;

    @Autowired
    public SearchController(ValidationService validationService, EmployeeService employeeService) {
        this.validationService = validationService;
        this.employeeService = employeeService;
    }

    @GetMapping("/search-employee")
    public String searchForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "search-employee";
    }

    @PostMapping ("/search-employee")
    public String searchEmployee(@ModelAttribute Employee employee) {
        if (!validationService.validateFIO(employee.getSurname()) || !validationService.validateFIO(employee.getName())) {
            return "redirect:/search-error";
        }
        Employee employeeSearch = employeeService.searchEmployee(employee.getSurname(), employee.getName());
        if (employeeSearch != null) {
            employee.setSurname(employeeSearch.getSurname());
            employee.setName(employeeSearch.getName());
            employee.setLastname(employeeSearch.getLastname());
            employee.setAge(employeeSearch.getAge());
            employee.setSalary(employeeSearch.getSalary());
            employee.setEmail(employeeSearch.getEmail());
            employee.setCompany(employeeSearch.getCompany());
            return "search-result";
        }
        return "redirect:/search-notfound";
    }

    @GetMapping("/search-error")
    public String errSearch() {
        return "search-error";
    }
}
