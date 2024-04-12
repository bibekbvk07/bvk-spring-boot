package com.bibek.springbootrestsecurity.dao;

import com.bibek.springbootrestsecurity.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee save(Employee theEmployee);
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee findByFirstName(String firstName);

    void deleteById(int id);

    int deleteAll();
}
