package com.hibernate.crud_demo;

import com.hibernate.crud_demo.dao.StudentDAO;
import com.hibernate.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner ->{
            createStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForAllStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudent(studentDAO);

        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students: ");
        System.out.println("Number of rows deleted: "+ studentDAO.deleteAll());
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 4;
        System.out.println("Deleting the student id: "+ studentId);

        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 4;
        Student student = studentDAO.findById(studentId);
        System.out.println(student);

        System.out.println("Updating the student with id: 1 ");
        student.setFirstName("Scooby");
        studentDAO.update(student);

        // display the updated student
        System.out.println("Updated Student: "+ student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> list = studentDAO.findByLastName("Doe ");

        // display list of students
        for (Student entity: list){
            System.out.println(entity);
        }
    }

    private void queryForAllStudents(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findAll();

        System.out.println("List of Students: \n");
        for (Student entity: studentList) {
            System.out.println(entity.getFirstName()+ " "+ entity.getLastName());
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // creates the student objects
        System.out.println("Creating new student object...");
        Student student6 = new Student("John", "Doe", "john.doe@code.com");

        // saves the student objects
        System.out.println("Saving the student..");
        studentDAO.save(student6);

        // display id of the saved student
        System.out.println("Saved student. Generated ID: "+ student6.getId());

        System.out.println("Retrieving students based on id...");
        Student student = studentDAO.findById(student6.getId());
        System.out.println("Found the student: "+ student);
    }

    private void createStudent(StudentDAO studentDAO) {
        // creates the student objects
        System.out.println("Creating new student object...");
        Student student1 = new Student("Bibek", "Shrestha", "bibek.shrestha@gmail.com");
        Student student2 = new Student("Andrew", "Carkoski", "andrew.carkoski@code.com");
        Student student3 = new Student("Binam", "Pokrel", "binam.pokrel@code.com");
        Student student4 = new Student("Samantha", "Willock", "samantha.willock@code.com");
        Student student5 = new Student("Kristy", "Doe", "kristy.doe@code.com");

        // saves the student objects
        System.out.println("Saving the student..");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
        studentDAO.save(student4);
        studentDAO.save(student5);

        // display id of the saved student
        System.out.println("Saved student. Generated ID: "+ student1.getId()+
                           "\n Student_Details: "+ student1.toString());
    }
}
