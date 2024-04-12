package com.bibek.springbootrestsecurity.service;

import com.bibek.springbootrestsecurity.dao.EmployeeDAO;
import com.bibek.springbootrestsecurity.dao.EmployeeDAOImpl;
import com.bibek.springbootrestsecurity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return employeeDAO.findByFirstName(firstName);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return employeeDAO.deleteAll();
    }
}
