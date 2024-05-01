package com.bibek.employeemanagementsystem.rest;

import com.bibek.employeemanagementsystem.entity.Department;
import com.bibek.employeemanagementsystem.exception.DepartmentNotFoundException;
import com.bibek.employeemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        List<Department> departments = departmentService.findAll();
        if (departments.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Departments not found.");
        }
        return ResponseEntity.ok(departments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            Department department = departmentService.findById(id);
            return ResponseEntity.ok(department);
        } catch (DepartmentNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found for the given ID.");
        }
    }
    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department){
        if (department == null){
            return ResponseEntity.badRequest().body("Department object cannot be null.");
        }
        department.setDeptId(0);
        Department savedDepartment = departmentService.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }
    @PutMapping
    public ResponseEntity<?> updateDepartment(@RequestBody Department department){
        if (department == null){
            return ResponseEntity.badRequest().body("Department object cannot be null.");
        }
        Department updatedDepartment = departmentService.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        departmentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Department with ID-> "+ id+ " has been deleted.");
    }
}
