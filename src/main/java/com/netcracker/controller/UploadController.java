package com.netcracker.controller;

import com.netcracker.dto.EmployeeDto;
import com.netcracker.model.Employee;
import com.netcracker.service.EmployeeService;
import com.netcracker.service.ValidationFileService;
import com.netcracker.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    private final ValidationService validationService;

    private final ValidationFileService validationFileService;

    private final EmployeeService employeeService;

    public UploadController(ValidationService validationService, ValidationFileService validationFileService, EmployeeService employeeService) {
        this.validationService = validationService;
        this.validationFileService = validationFileService;
        this.employeeService = employeeService;
    }

    @GetMapping("/upload-employee")
    public String uploadForm() {
        return "upload-employee";
    }

    @PostMapping("/upload-employee")
    public String uploadEmployee(@RequestParam MultipartFile file) {
        if (file.isEmpty()) {
            return "redirect:/upload-error";
        }
        EmployeeDto employeeDto = validationFileService.validateFile(file, new EmployeeDto());
        if (employeeDto == null || !validationService.validateEmployee(employeeDto)) {
            return "redirect:/add-error";
        }
        if (!employeeService.saveEmployee(new Employee(employeeDto))) {
            return "redirect:/exist-error";
        }

        return "redirect:/upload-employee";
    }
}
