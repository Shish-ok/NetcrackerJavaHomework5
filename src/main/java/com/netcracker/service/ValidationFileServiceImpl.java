package com.netcracker.service;

import com.netcracker.dto.EmployeeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ValidationFileServiceImpl implements ValidationFileService {
    @Override
    public EmployeeDto validateFile(MultipartFile file, EmployeeDto employeeDto) {
        try {
            String data = new String(file.getBytes()).replace("\r", "");
            String[] employee = (data).split("\n");
            if (employee.length != 7) {
                return null;
            }
            employeeDto.setSurname(employee[0]);
            employeeDto.setName(employee[1]);
            employeeDto.setLastname(employee[2]);
            employeeDto.setAge(employee[3]);
            employeeDto.setSalary(employee[4]);
            employeeDto.setEmail(employee[5]);
            employeeDto.setCompany(employee[6]);
            System.out.println(employee[0] + employee[1] + employee[2] + employee[3] + employee[4] + employee[5] + employee[6]);
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return employeeDto;
    }
}