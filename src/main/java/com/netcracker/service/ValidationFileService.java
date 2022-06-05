package com.netcracker.service;

import com.netcracker.dto.EmployeeDto;
import org.springframework.web.multipart.MultipartFile;

public interface ValidationFileService {
    EmployeeDto validateFile(MultipartFile file, EmployeeDto employeeDto);
}