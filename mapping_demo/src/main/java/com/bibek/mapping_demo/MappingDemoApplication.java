package com.bibek.mapping_demo;

import com.bibek.mapping_demo.entity.Address;
import com.bibek.mapping_demo.entity.Laptop;
import com.bibek.mapping_demo.entity.Student;
import com.bibek.mapping_demo.repository.AddressRepository;
import com.bibek.mapping_demo.repository.LaptopRepository;
import com.bibek.mapping_demo.repository.StudentRepository;
import com.bibek.mapping_demo.service.LaptopService;
import com.bibek.mapping_demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class MappingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MappingDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository, LaptopRepository laptopRepository, AddressRepository addressRepository){
        return args -> {
//            System.out.println("----------Creating Student Objects ---------");
//            Student s1 = new Student("Bibek", "Amatya", new SimpleDateFormat("yyyy-MM-dd").parse("1993-02-11"), "bibek.amatya@gmail.com");
//            Student s2 = new Student("Bipin", "Amatya", new SimpleDateFormat("yyyy-MM-dd").parse("1995-12-31"), "bipin.amatya@gmail.com");
//            Student s3 = new Student("Karuna", "Hamal", new SimpleDateFormat("yyyy-MM-dd").parse("1991-10-22"), "karuna.hamal@gotmail.com");
//            Student s4 = new Student("Virat", "Kohli", new SimpleDateFormat("yyyy-MM-dd").parse("1989-10-05"), "virat.kohli@gmail.com");
//
//            // Saving the student objects
//            studentRepository.save(s1);
//            studentRepository.save(s2);
//            studentRepository.save(s3);
//            studentRepository.save(s4);
//
//            System.out.println("----------Creating Laptop Objects ---------");
//            Laptop laptop1 = new Laptop("Apple", "AXC8DF09XD",s1);
//            Laptop laptop2 = new Laptop("Apple", "BVN8TC6DC9",s2);
//            Laptop laptop3 = new Laptop("Dell", "XPS10", s3);
//
//            // Saving the laptop objects
//            laptopRepository.save(laptop1);
//            laptopRepository.save(laptop2);
//            laptopRepository.save(laptop3);
//
//            System.out.println("----------Creating Address Objects ---------");
//            Address address1 = new Address("1904 Warren St", "Mankato", "MN", 56001, s1);
//            Address address2 = new Address("1335 Pohl Road", "Mankato", "MN", 56001, s1);
//            Address address4 = new Address("60/60 new South wale", "Sydney", "SD", 34561, s2);
//            Address address3 = new Address("1400 Warren St", "Brooklyn", "NY", 76225, s3);
//
//            // saving
//            addressRepository.save(address1);
//            addressRepository.save(address2);
//            addressRepository.save(address3);
//            addressRepository.save(address4);
        };
    }
}
