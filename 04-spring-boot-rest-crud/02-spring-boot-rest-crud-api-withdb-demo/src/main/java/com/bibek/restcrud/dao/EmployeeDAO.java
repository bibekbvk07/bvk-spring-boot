package com.bibek.restcrud.dao;

import com.bibek.restcrud.entity.Employee;
import com.bibek.restcrud.service.EmployeeService;

import java.util.List;

public interface EmployeeDAO {

    // Define abstract methods to be implemented by subclasses
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);
    void deleteById(int id);

}
