package com.bibek.restcrud.service;

import com.bibek.restcrud.dao.EmployeeRepository;
import com.bibek.restcrud.entity.Employee;
import com.bibek.restcrud.exceptionhandler.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl( EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // delegating the calls to employee dao
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int empId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);

        Employee employee = null;
        if (optionalEmployee.isPresent()){
            // optionalEmployee will check is value is present, if so the object will be stored in employee reference
            employee = optionalEmployee.get();
        }else{
            throw new EmployeeNotFoundException("Employee not found: "+ empId);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
