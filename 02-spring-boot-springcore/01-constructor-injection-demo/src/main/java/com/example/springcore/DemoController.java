package com.example.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    /*
    The @Autowired annotation tells Spring to inject a dependency
    Note: If you only have one constructor then @Autowired on constructor is optional
     */
    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    // expose "/dailyWorkout" endpoints

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
