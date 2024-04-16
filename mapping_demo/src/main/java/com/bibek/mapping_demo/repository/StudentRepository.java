package com.bibek.mapping_demo.repository;

import com.bibek.mapping_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s right join Laptop l on l.student.studentId = s.studentId")
    List<Student> findStudentByLaptop();

    @Query("select s from Student s where DATE_FORMAT(s.dob, '%Y') = ?1")
    List<Student> findStudentByBirthYear(String year);

}
