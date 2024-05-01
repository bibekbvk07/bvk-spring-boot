package com.bibek.employeemanagementsystem.controller;

import com.bibek.employeemanagementsystem.entity.Department;
import com.bibek.employeemanagementsystem.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    // add mapping for "/lists"
    @GetMapping("/lists")
    public String listDepartments(Model model){
        // get the departments from the database
        List<Department> departments = departmentService.findAll();

        // add to the spring model
        model.addAttribute("departments", departments);

        return "department";
    }

    // Mapping to show form for add
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        // Create a model attribute to bind form data
        Department department = new Department();

        model.addAttribute("department", department);
        return "department-form";
    }
    // mapping for save and update
    @PostMapping("/save")
    public String saveDepartment(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "department-form";
        }else {
            // save the department
            departmentService.save(department);

            // use a redirect to prevent duplicate submissions
            return "redirect:/departments/lists";
        }
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("departmentId") int id, Model model){
        // get department from the service
        Department theDepartment = departmentService.findById(id);

        // set department as a model attribute to pre-populate the form
        model.addAttribute("department", theDepartment);

        // send over to our form
        return "department-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("departmentId") int id){

        // delete the department for the given id
        departmentService.deleteById(id);

        // redirect to department lists
        return "redirect:/departments/lists";
    }

    @GetMapping("/orderByDesc")
    public String orderByDesc(Model model){
        List<Department> departments = departmentService.orderByNameDesc();

        // add to the spring model
        model.addAttribute("departments", departments);
        return "department";
    }
}
