package com.bibek.employeemanagementsystem.repository;

import com.bibek.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("select d from Department d order by d.name desc")
    List<Department> orderByDesc();

    @Query("select d from Department d order by d.name asc ")
    List<Department> orderByAsc();
}
