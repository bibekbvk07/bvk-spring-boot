package com.bibek.springbootrestsecurity.dao;

import com.bibek.springbootrestsecurity.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("FROM Employee ", Employee.class).getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        Query query = entityManager.createQuery("SELECT e from Employee e where e.firstName =:theData");
        query.setParameter("theData", firstName);
        return entityManager.find(Employee.class, query);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE from Employee ", Employee.class).executeUpdate();
    }
}
