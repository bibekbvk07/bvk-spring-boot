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
     * Specify bean id: basketBallCoach, same name as class except first character lower-case
     * With @Qualifier annotation you can specify to use this implementation of the coach interface
     * (allows you to be specific on which bean you want)
     * @Qualifier solves the ambiguity issue, because without @Qualifier spring container could not tell which bean to reference
     */
    // Constructor injection
    @Autowired
    public DemoController(@Qualifier("soccerCoach") Coach theCoach){
        myCoach = theCoach;
    }

    // expose "/dailyWorkout" endpoints

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
