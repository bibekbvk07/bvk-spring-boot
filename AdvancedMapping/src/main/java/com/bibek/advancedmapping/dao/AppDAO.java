package com.bibek.advancedmapping.dao;


import com.bibek.advancedmapping.entity.Course;
import com.bibek.advancedmapping.entity.Instructor;
import com.bibek.advancedmapping.entity.InstructorDetail;
import com.bibek.advancedmapping.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorById(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    Course findCourseById(int theId);

    void update(Instructor instructor);
    void update(Course tempCourse);

    void deleteById(int theID);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCoursesAndStudentByCourseId(int theId);

    Student findStudentAndCourseById(int theId);

    Student findStudentById(int theId);

    Student findStudentCourseById(int theId);

    void update(Student theStudent);

    void deleteStudentById(int theId);


}
