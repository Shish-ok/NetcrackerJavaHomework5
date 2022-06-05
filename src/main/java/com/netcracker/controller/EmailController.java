package com.netcracker.controller;

import com.netcracker.dto.MessageDto;
import com.netcracker.model.Employee;
import com.netcracker.service.EmailService;
import com.netcracker.service.EmployeeService;
import com.netcracker.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmailController {

    private final EmailService emailService;

    private final ValidationService validationService;

    private final EmployeeService employeeService;

    @Autowired
    public EmailController(EmailService emailService, ValidationService validationService, EmployeeService employeeService) {
        this.emailService = emailService;
        this.validationService = validationService;
        this.employeeService = employeeService;
    }

    @GetMapping("/send-email")
    public String emailForm(Model model) {
        model.addAttribute("messageDto", new MessageDto());
        return "send-email";
    }

    @PostMapping("/send-email")
    public String sendEmail(@ModelAttribute MessageDto messageDto) {
        if (!validationService.validateFIO(messageDto.getSurname()) || !validationService.validateFIO(messageDto.getName())) {
            return "redirect:/email-error";
        }

        Employee employeeSearch = employeeService.searchEmployee(messageDto.getSurname(), messageDto.getName());
        if (employeeSearch == null) {
            return "redirect:/search-notfound";
        }

        emailService.sendMessage(employeeSearch.getEmail(), "Mail Test!", messageDto.getMessage());

        return "redirect:/send-email";
    }

}