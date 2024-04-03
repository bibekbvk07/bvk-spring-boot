package com.example.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Component class marks the class as spring bean and makes is available for dependency injection
@Component
@Primary
//@Primary - With primary annotation, you no longer need to specify @Qualifier in the constructor or setter methods
// Could have the issues of multiple @Primary classes leading to an error
// @Qualifier annotation has higher priority than @primary if both are used
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice batting in the nets with bowling machine!!";
    }
}
