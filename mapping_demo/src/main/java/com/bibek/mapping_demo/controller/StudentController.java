package com.bibek.mapping_demo.controller;

import com.bibek.mapping_demo.entity.Student;
import com.bibek.mapping_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bvk/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentList);
    }
    @GetMapping("/laptops")
    public ResponseEntity<List<Student>> getStudentsByLaptop(){
        List<Student> studentList = studentService.findStudentByLaptop();
        if (studentList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student = studentService.findById(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("birth-year/{birthYear}")
    public ResponseEntity<List<Student>> getStudentsByBirthYear(@PathVariable String birthYear){
        List<Student> studentList = studentService.findStudentByBirthYear(birthYear);
        if (studentList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        if (student == null){
            // Return 400 for null input
            return ResponseEntity.badRequest().build();
        }
        student.setStudentId(0);
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student updatedStudent){
        if (updatedStudent == null) {
            return ResponseEntity.badRequest().build();
        }
        studentService.save(updatedStudent);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteStudentByID(@PathVariable int id){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok(id);
    }
}
