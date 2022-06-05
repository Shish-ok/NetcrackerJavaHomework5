package com.netcracker.model;

import com.netcracker.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "email")
    private String email;

    @Column(name = "company")
    private String company;

    public int getId() {
        return id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public Integer getSalary() {
        return salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompany() {
        return company;
    }

    public Employee() {

    }

    public Employee(EmployeeDto employeeDto) {
        this.surname = employeeDto.getSurname();
        this.name = employeeDto.getName();
        this.lastname = employeeDto.getLastname();
        this.age = Integer.parseInt(employeeDto.getAge());
        this.salary = Integer.parseInt(employeeDto.getSalary());
        this.email = employeeDto.getEmail();
        this.company = employeeDto.getCompany();
    }
}