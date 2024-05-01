package com.bibek.spring_mvc.controller;

import com.bibek.spring_mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    // to inject from spring application.properties we could use @Value annotation
    // and provide actual name of properties given in application.properties file
   @Value("${countries}")
    private List<String> countries;

   @Value("${programming_languages}")
   private List<String> programmingLanguages;

   @Value("${operating_systems}")
   private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create a new Student object
        Student theStudent = new Student();

        // Add the student object as a model attribute
        theModel.addAttribute("student", theStudent);

        // add the list of countries to the model
        theModel.addAttribute("countries", countries);

        // add the list of languages to the model
        theModel.addAttribute("languages", programmingLanguages);

        // add the list of operating systems to the model
        theModel.addAttribute("operating_system", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){

        // log the inout data
        System.out.println(theStudent.toString());
        return "student-confirmation";
    }
}
