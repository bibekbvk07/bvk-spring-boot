package com.bibek.restcrud.dao;

import com.bibek.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("FROM Employee ", Employee.class);
        return employeeTypedQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        // check validation
        return entityManager.find(Employee.class, id);
    }

    /*
     * Note: We do not use @Transactional at DAO layer, it will be handled at @Service layer (i.e. By ServiceImplementation)
     */
    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
