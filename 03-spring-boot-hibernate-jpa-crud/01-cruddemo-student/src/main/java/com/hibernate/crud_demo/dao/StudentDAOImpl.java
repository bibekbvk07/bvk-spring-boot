package com.hibernate.crud_demo.dao;

import com.hibernate.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //  define field for entity manager
    private final EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
         entityManager.persist(theStudent); // saves the student to the database
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // lastName => Entity field name not the column name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where firstName like 'B%'", Student.class);
        // return query results i.e. list of all the students
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        // Create a query
        TypedQuery<Student> studentByLastName = entityManager.createQuery(
                "FROM Student where lastName =: theData", Student.class);
        // JPQL Named parameters are prefixed with a colon: -> think of this as placeholder that is filled in later

        // Set Query parameters
        studentByLastName.setParameter("theData", theLastName);

        // return query result
        return studentByLastName.getResultList();
    }

    // Overriding an update method
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE  from Student ").executeUpdate();
    }

}
