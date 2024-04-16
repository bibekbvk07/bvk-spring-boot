package com.bibek.springbootrestsecurity.rest;

import com.bibek.springbootrestsecurity.entity.Employee;
import com.bibek.springbootrestsecurity.exceptions.EmployeeNotFoundException;
import com.bibek.springbootrestsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bvk")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" to return list of all the employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    // expose "/{id}" to return the employees by their id
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if (employee == null){
            throw new EmployeeNotFoundException("Employee id not found -> "+ id);
        }
        return employee;
    }

    @GetMapping("/employees/{firstName}")
    public List<Employee> findEmployeeByFirstName(@PathVariable String firstName){
        return employeeService.findByFirstName(firstName);
    }

    // expose "/employees" to create/add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setEmpId(0);
        return employeeService.save(theEmployee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployees(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if (employee == null){
            throw  new EmployeeNotFoundException("Employee not found for -> "+ id);
        }
        employeeService.deleteById(id);
        return "Deleted Employee with id -> "+ id;
    }
    @DeleteMapping("/employees")
    public int deleteAll(){
        return employeeService.deleteAll();
    }
}
