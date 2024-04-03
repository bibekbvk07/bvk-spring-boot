package com.example.springcore.rest;

import com.example.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // Constructor injection
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach  theCoach) {
        System.out.println("Constructor in: "+ getClass().getSimpleName());
        myCoach = theCoach;
    }

    // expose "/dailyWorkout" endpoints
    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
