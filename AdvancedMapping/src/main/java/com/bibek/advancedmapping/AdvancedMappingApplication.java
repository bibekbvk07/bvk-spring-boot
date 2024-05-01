package com.bibek.advancedmapping;

import com.bibek.advancedmapping.dao.AppDAO;
import com.bibek.advancedmapping.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner ->{
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
//            deleteInstructorDetail(appDAO);
//            createInstructorWithCourses(appDAO);
//            findInstructorWithCourses(appDAO);
//            findCoursesForInstructor(appDAO);
//            findCoursesForInstructorUsingJoinFetch(appDAO);
//            updateInstructor(appDAO);
//            updateCourse(appDAO);
//            deleteInstructorById(appDAO);
//            deleteCourseById(appDAO);
//            createCourseAndReviews(appDAO);
//            findCourseAndReviews(appDAO);
//            deleteCourseAndReviews(appDAO);
//            createCourseAndStudents(appDAO);
//            findCourseAndStudent(appDAO);
//            findStudentAndCourse(appDAO);
//            addMoreCoursesForStudent(appDAO);
//            deleteCourseById(appDAO);
            deleteStudent(appDAO);

        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting student id: "+ theId);
        appDAO.deleteStudentById(theId);
        System.out.println("Done!");
    }


    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Find student: "+ theId);
        Student tempStudent = appDAO.findStudentAndCourseById(theId);
        System.out.println(tempStudent);

        // create more courses for student (instead of creating new course adding the course available in db)
        Course course1 = appDAO.findCourseById(10);
        System.out.println(course1);
        Course course2 = appDAO.findCourseById(18);
        System.out.println(course2);

        // add course to the students
        tempStudent.addCourse(course1);
        tempStudent.addCourse(course2);
        appDAO.update(tempStudent);
        System.out.println("Done!");
    }

    private void findStudentAndCourse(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Find student: "+ theId);
        Student tempStudent = appDAO.findStudentAndCourseById(theId);

        System.out.println("Student and Course Details: ");
        System.out.println("Student: "+ tempStudent);
        System.out.println("Associated Course: "+ tempStudent.getCourses());
        System.out.println("Done!");
    }

    private void findCourseAndStudent(AppDAO appDAO) {
        int theId = 16;
        System.out.println("Find the course: "+ theId);
        Course tempCourse = appDAO.findCoursesAndStudentByCourseId(theId);

        System.out.println();
        System.out.println("tempCourse: "+ tempCourse);
        System.out.println("Associated students: "+ tempCourse.getStudentList());
        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        // create a course
        Course course1 = new Course("Basic Programming");

        // create the students
        Student student1 = new Student("Jenny", "Colbert", "jenny@luv2code.com");
        Student student2 = new Student("Nanny", "Voldt", "nanny@luv2code.com");

        // add students to the course
        course1.addStudent(student1);
        course1.addStudent(student2);

        // save the course and associated students
        System.out.println("Saving the course: "+ course1);
        System.out.println("Associated students: "+ course1.getStudentList());

        appDAO.save(course1);

        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int theId = 15;

        System.out.println("Deleting Course: ");
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void findCourseAndReviews(AppDAO appDAO) {
        int theId = 15;
        System.out.println("Finding course: "+ theId);
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

        System.out.println("tempCourse: "+ tempCourse);
        System.out.println("Associated Reviews: "+ tempCourse.getReviews());
        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        // create a course
        Course course = new Course("Data Structure and Algorithms");

        // add some reviews to the course
        course.addReview(new Review("Enjoyed the Course"));
        course.addReview(new Review("Good Learning"));
        course.addReview(new Review("Course was not quite up to the Standard!"));

        // save the course
        System.out.println("Saving the course: ");
        System.out.println(course);
        System.out.println(course.getReviews());

        appDAO.save(course);

        System.out.println("Done!");
    }

    private void deleteCourseById(AppDAO appDAO) {
        int theId = 16;
        System.out.println("Finding the instructor id: "+ theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void deleteInstructorById(AppDAO appDAO) {
        int theId = 6;
        System.out.println("Finding the instructor id: "+ theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Deleting Instructor: "+ theId);
        appDAO.deleteById(theId);
        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Finding the instructor id: "+ theId);
        Course course = appDAO.findCourseById(theId);

        // calling the setter methods to update the course
        course.setTitle("Advanced Java with Spring Boot");

        // update the database
        appDAO.update(course);
        System.out.println("Done!");

    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 6;
        System.out.println("Finding the instructor id: "+ theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Updating instructor id: "+ theId);
        tempInstructor.setLastName("Tester");

        // update
        appDAO.update(tempInstructor);
        System.out.println("Done!");

    }

    private void findCoursesForInstructorUsingJoinFetch(AppDAO appDAO) {
        int theId = 6;
        System.out.println("Finding the instructor id: "+ theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: "+ tempInstructor);
        System.out.println("tempInstructorDetail: "+ tempInstructor.getInstructorDetail());
        System.out.println("The associated courses: "+ tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 6;
        System.out.println("Finding the instructor id: "+ theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: "+ tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id: "+ theId);
        List<Course> courseList = appDAO.findCoursesByInstructorById(theId);

        // setting the courses to instructor
        tempInstructor.setCourses(courseList);

        System.out.println("The associated courses: "+ tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 6;
        System.out.println("Finding the instructor id: "+ theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: "+ tempInstructor);
        System.out.println("the associated courses: "+ tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor1 = new Instructor("Magic", "Mike", "magic@luv2code.com");
        InstructorDetail instructorDetail1 = new InstructorDetail("htttp://www.youtube.com", "Gamer");

        // associate the objects
        instructor1.setInstructorDetail(instructorDetail1);

        // create some courses
        Course course1 = new Course("Basic Java for Beginners");
        Course course2 = new Course("Database Administrator");

        // add courses to instructor
        instructor1.add(course1);
        instructor1.add(course2);

        // saving instructor
        // Note: this will also save the courses because of CascadeType.PERSIST
        //
        System.out.println("Saving instructor: "+ instructor1);
        System.out.println("the courses: "+ instructor1.getCourses());
        appDAO.save(instructor1);
        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 5;
        System.out.println("Deleting InstructorDetail: "+ theId);
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding InstructorDetails: "+ theId);
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
        System.out.println("tempInstructorDetail: "+ instructorDetail);
        System.out.println("the associate instructor: "+ instructorDetail.getInstructor());

    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Deleting Instructor: "+ theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Finding instructor: "+ theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: "+ tempInstructor);
        System.out.println("the associate instructor details only: "+ tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        // create the instructor
//        Instructor instructor1 = new Instructor("Bibek", "Amatya", "bibek@luv2code.com");
//        Instructor instructor2 = new Instructor("Michael", "Levy", "michael@luv2code.com");
        Instructor instructor3 = new Instructor("Mickey", "Mouse", "mickey@luv2code.com");

        // create instructor details
//        InstructorDetail instructorDetail1 = new InstructorDetail("htttp://www.luv2code.com/youtube", "Love to Code");
//        InstructorDetail instructorDetail2 = new InstructorDetail("htttp://www.luv2code.com/youtube", "Guitar");
        InstructorDetail instructorDetail3 = new InstructorDetail("htttp://www.luv2code.com/youtube", "Play Mickey");

        // associate the objects
        instructor3.setInstructorDetail(instructorDetail3);

        // save the instructor
        // Note: this will also save the details objects because of Cascade.TypeALL
        System.out.println("Saving instructor: "+ instructor3);
        appDAO.save(instructor3);
        System.out.println("Done!");
    }
}
