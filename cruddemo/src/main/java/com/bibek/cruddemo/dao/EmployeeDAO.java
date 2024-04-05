package com.bibek.cruddemo.dao;

import com.bibek.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Abstract method to save the data to db
    void save(Employee theEmployee);

    // Abstract method to find Employee by id
    Employee findById(Integer id);

    // Abstract method to find all the Employees
    List<Employee> findAll();

    // Passing the parameter to find the employee
    List<Employee> findByFirstName(String firstName);

    void update(Employee theEmployee);

    void delete(Integer id);

    int deleteAll();
}
