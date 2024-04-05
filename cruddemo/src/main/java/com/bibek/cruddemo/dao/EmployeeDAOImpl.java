package com.bibek.cruddemo.dao;

import com.bibek.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final EntityManager entityManager;

    // Constructor injection with @Autowired annotation
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Performing a create operation so annotated by @Transactional
    @Override
    @Transactional
    public void save(Employee theEmployee) {
        entityManager.persist(theEmployee);
    }

    // @Transactional annotation not required for read operations
    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    // @Transactional annotation not required for read operations
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeList = entityManager.createQuery("FROM Employee", Employee.class);
        return employeeList.getResultList();
    }

    // @Transactional annotation not required for read operations
    @Override
    public List<Employee> findByFirstName(String firstName) {
        TypedQuery<Employee> empList = entityManager.createQuery("FROM Employee where firstName =: theData", Employee.class);
        empList.setParameter("theData", firstName);
        return empList.getResultList();
    }

    // @Transactional annotation for update operations
    @Override
    @Transactional
    public void update(Employee theEmployee) {
        entityManager.merge(theEmployee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE  from Employee").executeUpdate();
    }
}
