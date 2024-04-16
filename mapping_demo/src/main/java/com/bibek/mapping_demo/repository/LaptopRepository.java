package com.bibek.mapping_demo.repository;

import com.bibek.mapping_demo.entity.Laptop;
import com.bibek.mapping_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

    @Query("select l from Laptop l inner join Student s on l.student.studentId = s.studentId where s.firstName =?1")
    Laptop findLaptopByStudentFirstName(String firstName);
}
