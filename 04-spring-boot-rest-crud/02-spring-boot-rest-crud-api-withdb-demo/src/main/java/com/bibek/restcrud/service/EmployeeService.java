package com.bibek.restcrud.service;

import com.bibek.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    
    List<Employee> findAll();
    Employee findById(int empId);
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
