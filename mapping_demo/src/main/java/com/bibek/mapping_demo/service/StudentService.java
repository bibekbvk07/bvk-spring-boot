package com.bibek.mapping_demo.service;

import com.bibek.mapping_demo.entity.Student;
import com.bibek.mapping_demo.exceptions.StudentNotFoundException;
import com.bibek.mapping_demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        List<Student> studentList = studentRepository.findAll();

        if (studentList.isEmpty()){
            throw new StudentNotFoundException("Student not found -> Empty List");
        }
        return studentList;
    }
    public List<Student> findStudentByLaptop(){
        List<Student> studentList = studentRepository.findStudentByLaptop();
        if (studentList.isEmpty()){
            throw new StudentNotFoundException("Student not found!");
        }
        return studentList;
    }

    public void save(Student student){
        if (student == null){
            throw new StudentNotFoundException("Student Object is Empty/Null.");
        }
        studentRepository.save(student);
    }

    public Student findById(int id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()){
            logger.error("Student not found for: {}", id);
            throw new StudentNotFoundException("Student not found for given Id. ");
        }
        return student.get();
    }

    public List<Student> findStudentByBirthYear(String year){
        List<Student> studentList = studentRepository.findStudentByBirthYear(year);
        if (studentList.isEmpty()){
            logger.error("Student not found for: {}", year);
            throw new StudentNotFoundException("Student not found for the given year" );
        }
        return studentList;
    }

    public void deleteStudentById(int id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()){
            logger.error("Student not found for: {}", id);
            throw new StudentNotFoundException("Student not found for the given ID.");
        }
        studentRepository.delete(student.get());
    }
}
