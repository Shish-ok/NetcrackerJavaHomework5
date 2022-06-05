package com.netcracker.service;

import com.netcracker.dto.EmployeeDto;

public interface ValidationService {
    boolean validateEmployee(EmployeeDto employeeDto);
    boolean validateFIO(String partFIO);
    boolean validateEmail(String email);
}