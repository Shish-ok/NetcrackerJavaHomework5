package com.netcracker.service;

import com.netcracker.model.Employee;
import com.netcracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        if (searchEmployee(employee.getSurname(), employee.getName()) == null) {
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    @Override
    public Employee searchEmployee(String surname, String name) {
        return employeeRepository.findBySurnameAndName(surname, name);
    }
}