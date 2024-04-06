package com.bibek.restcrud.rest;

import com.bibek.restcrud.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

    // Define a private field
    private List<Employee> employeeList;

    // Define a post-Construct method, which will execute only once during initialization
    @PostConstruct
    public void loadData(){
        employeeList = new ArrayList<>();
        Employee emp1 = new Employee("Katrina", "Kaif", "katrina.kaif@luv2code.com");
        Employee emp2 = new Employee("Kabhir", "Singh", "kabhir.singh@luv2code.com");
        Employee emp3 = new Employee("Harry", "Potter", "harry.potter@luv2code.com");
        Employee emp4 = new Employee("Rohit", "Sharma", "rohit.sharma@luv2code.com");
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
    }

    // expose "/employees" endpoint to get all the employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeList;
    }

    // expose "/employees/{employeeId}" endpoints to return single employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        // check the employee id against the list size
        if (employeeId >= employeeList.size() || employeeId < 0){
            throw new EmployeeNotFoundException("Employee Id not found -> "+ employeeId);
        }
        // after validation return employee list
        return employeeList.get(employeeId);
    }

}
