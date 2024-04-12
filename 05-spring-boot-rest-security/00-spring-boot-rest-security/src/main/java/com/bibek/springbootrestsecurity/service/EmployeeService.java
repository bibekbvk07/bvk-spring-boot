package com.bibek.springbootrestsecurity.service;

import com.bibek.springbootrestsecurity.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee theEmployee);
    List<Employee> findAll();
    Employee findById(int id);
    Employee findByFirstName(String firstName);
    void deleteById(int id);

    int deleteAll();
}
