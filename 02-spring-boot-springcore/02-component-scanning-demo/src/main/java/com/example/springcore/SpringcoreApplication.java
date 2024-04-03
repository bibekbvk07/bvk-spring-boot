package com.example.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Note: If your components (regular java classes) are outside the base package i.e com.example.springcore,
then you have to scan base packages like shown below

  @SpringBootApplication(
        scanBasePackages = {"com.example.springcore",
                            "com.example.util"})
 */

@SpringBootApplication
public class SpringcoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoreApplication.class, args);
    }

}
