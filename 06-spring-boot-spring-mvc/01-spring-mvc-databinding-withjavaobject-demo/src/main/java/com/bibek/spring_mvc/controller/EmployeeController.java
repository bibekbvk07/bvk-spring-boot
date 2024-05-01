package com.bibek.spring_mvc.controller;

import com.bibek.spring_mvc.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Value("${departments}")
    private List<String> departments;

    // Define a controller to expose "/showEmployeeForm" endpoint  and route to employee registration form
    @GetMapping("/showEmployeeForm")
    public String getEmployeeRegistrationForm(Model model){
        // Create an instantiate Employee object
        Employee employee = new Employee();

        // Add the object to the model
        model.addAttribute("employee", employee);

        // add the list of departments to the model
        model.addAttribute("departments", departments);

        return "employee-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("employee") Employee employee){
        // log the data into the terminal (its optional)
        System.out.println(employee.toString());
        return "employee-confirmation";
    }
}
