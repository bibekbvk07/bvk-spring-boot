package com.bibek.customer_crud_demo.repository;

import com.bibek.customer_crud_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
