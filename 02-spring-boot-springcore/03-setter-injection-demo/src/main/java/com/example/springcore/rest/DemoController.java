package com.example.springcore.rest;

import com.example.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // define a setter method for setter injection
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }
    
    /**
    // define a method sett
    @Autowired
    public void anyMethod(Coach theCoach){
        myCoach = theCoach;
    }
     */

    // expose "/dailyWorkout" endpoints

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
