package com.bibek.employeemanagementsystem.rest;

import com.bibek.employeemanagementsystem.entity.Employee;
import com.bibek.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/lists")
    public ResponseEntity<?> getAllEmployees(){
        List<Employee> employeeList = employeeService.findAll();
        if (employeeList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Empty List");
        }
        return ResponseEntity.ok(employeeList);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        if (employee == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No content found!");
        }
        employee.setEmpId(0);
        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }
}
