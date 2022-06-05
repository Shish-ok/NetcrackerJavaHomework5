package com.netcracker.service;

import com.netcracker.model.Employee;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    boolean saveEmployee(Employee employee);

    Employee searchEmployee(String surname, String name);
}