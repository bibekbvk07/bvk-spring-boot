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


    /*
     * As we know default scope is singleton, so all the dependency injections for the bean will reference the same bean.
     *  For example: { myCoach = theCoach, and anotherCoach = theAnotherCoach} are referencing to the same bean
     * If the scope was configured to Prototype than each bean are separate bean (new object instance for each injection)
     */
    // Constructor injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach  theCoach) {
        System.out.println("Constructor in: "+ getClass().getSimpleName());
        myCoach = theCoach;
    }

    // expose "/dailyWorkout" endpoints
    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
