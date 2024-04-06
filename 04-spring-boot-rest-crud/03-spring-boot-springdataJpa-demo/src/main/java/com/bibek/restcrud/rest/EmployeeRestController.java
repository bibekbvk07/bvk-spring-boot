package com.bibek.restcrud.rest;

import com.bibek.restcrud.entity.Employee;
import com.bibek.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bvk")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    // Quick and dirty inject employee dao (constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" endpoints to return list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("employees/{emp_id}")
    public Employee getEmployeeById(@PathVariable int emp_id){
        Employee employee = employeeService.findById(emp_id);

        // Checking for validation
        if (employee == null){
            throw new RuntimeException("Employee Id not found -> "+ emp_id);
        }
        return employee;
    }
    // Add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON.. explicitly set id to 0
        // this is to force a save of new item.. instead of update
        theEmployee.setEmpId(0);
        Employee dbEmployee =employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Add mapping for PUT /employees - update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Add mapping for Delete /employees/{emp_id} - deletes an employee
    @DeleteMapping("/employees/{emp_id}")
    public String deleteEmployee(@PathVariable int emp_id){
        Employee employee = employeeService.findById(emp_id);

        if (employee == null){
            throw new RuntimeException("Employee doesn't Exist!");
        }
        employeeService.deleteById(emp_id);
        return "Deleted employee id- "+ emp_id;
    }

}
