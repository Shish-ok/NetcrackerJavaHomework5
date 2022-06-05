package com.netcracker.service;

import com.netcracker.dto.EmployeeDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final String FIO_PATTERN = "[a-zA-Z]+";
    private final String INT_PATTERN = "[0-9]+";
    private final String EMAIL_PATTERN = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    @Override
    public boolean validateEmployee(EmployeeDto employeeDto) {

        return validateFIO(employeeDto.getSurname()) && validateFIO(employeeDto.getName()) && validateFIO(employeeDto.getLastname())
                && validateAge(employeeDto.getAge()) && validateSalary(employeeDto.getSalary()) && validateEmail(employeeDto.getEmail());
    }

    @Override
    public boolean validateFIO(String partFIO) {
        return Pattern.compile(FIO_PATTERN).matcher(partFIO).matches();
    }

    private boolean validateAge(String age) {
        if (Pattern.compile(INT_PATTERN).matcher(age).matches()) {
            int ageNum = Integer.parseInt(age);
            return ageNum > 17 && ageNum < 90;
        }
        return false;
    }

    private boolean validateSalary(String salary) {
        return Pattern.compile(INT_PATTERN).matcher(salary).matches();
    }

    @Override
    public boolean validateEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }
}