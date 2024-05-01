package com.bibek.employeemanagementsystem.service;

import com.bibek.employeemanagementsystem.entity.Employee;
import com.bibek.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.bibek.employeemanagementsystem.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{

    private final EmployeeRepository employeeRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
        List<Employee> employeeList = employeeRepository.findAll();
        if (employeeList.isEmpty()){
            logger.warn("Empty List!");
        }
        return employeeList;
    }

    public Employee save(Employee employee){
        if (employee == null){
            logger.warn("Department object is null.");
            throw new IllegalArgumentException("Employee object cannot be null.");
        }
        return employeeRepository.save(employee);
    }
}
