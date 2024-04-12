package com.bibek.restcrud.dao;

import com.bibek.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<EntityType, PrimaryKey>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
