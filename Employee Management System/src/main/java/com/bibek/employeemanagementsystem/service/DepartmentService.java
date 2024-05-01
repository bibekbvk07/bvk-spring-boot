package com.bibek.employeemanagementsystem.service;

import com.bibek.employeemanagementsystem.entity.Department;
import com.bibek.employeemanagementsystem.exception.DepartmentNotFoundException;
import com.bibek.employeemanagementsystem.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Define a method to find all the department
    public List<Department> findAll(){
        List<Department> departments = departmentRepository.findAll();
        if (departments.isEmpty()){
            logger.warn("Department list is empty.");
        }
        return departments;
    }
    public Department findById(int id){
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isEmpty()){
            logger.warn("Department not found: {}", id);
            throw new DepartmentNotFoundException("Department not found for the given ID");
        }
        return department.get();
    }
    public Department save(Department department){
        if (department == null){
        logger.warn("Department object is null.");
        throw new IllegalArgumentException("Department object cannot be null.");
        }
        return departmentRepository.save(department);
    }
    public void deleteById(int id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        departmentOptional.ifPresentOrElse(
                departmentRepository::delete,
                () -> {
                    logger.warn("Department not found: {}", id);
                    throw new DepartmentNotFoundException("Department not found for the given ID");
                }
        );
    }
    public List<Department> orderByNameDesc(){
        List<Department> departments = departmentRepository.orderByDesc();
        if (departments.isEmpty()){
            logger.warn("Department list is empty.");
        }
        return departments;
    }
    public List<Department> orderByNameAsc(){
        List<Department> departments = departmentRepository.orderByAsc();
        if (departments.isEmpty()){
            logger.warn("Department list is empty.");
        }
        return departments;
    }
}
