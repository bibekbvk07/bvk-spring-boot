package com.bibek.advancedmapping.dao;

import com.bibek.advancedmapping.entity.Course;
import com.bibek.advancedmapping.entity.Instructor;
import com.bibek.advancedmapping.entity.InstructorDetail;
import com.bibek.advancedmapping.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    // define field for entity manager
    // inject entity manager using constructor injection

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference
        // break bidirectional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorById(int theId) {
        // create query to find courses by id
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        // setting the parameter value passed (int theId)
        query.setParameter("data", theId);
        // execute the query
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i join fetch i.courses join fetch i.instructorDetail where i.id=:data", Instructor.class);
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(int theID) {
        // retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, theID);

        List<Course> courses = instructor.getCourses();

        // break associations of all courses for instructor
        for (Course tempCourse: courses) {
            tempCourse.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(instructor);

    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course course = entityManager.find(Course.class, theId);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c join fetch c.reviews where c.id=:data", Course.class);
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    public Course findCoursesAndStudentByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c join fetch c.studentList where c.id=:data", Course.class);

        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCourseById(int theId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s join fetch s.courses where s.id=:data", Student.class);

        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentById(int theId) {
        return entityManager.find(Student.class, theId);
    }

    @Override
    public Student findStudentCourseById(int theId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s join fetch s.courses where s.id=:data", Student.class);

        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        Student student = entityManager.find(Student.class, theId);
        entityManager.remove(student);
    }
}
