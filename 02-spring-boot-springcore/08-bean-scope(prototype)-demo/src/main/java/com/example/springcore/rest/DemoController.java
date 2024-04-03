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
    private Coach anotherCoach;

    /*
     * As we know default scope is singleton, so all the dependency injections for the bean will reference the same bean.
     *  For example: { myCoach = theCoach, and anotherCoach = theAnotherCoach} are referencing to the same bean
     * If the scope was configured to Prototype than each bean are separate bean (new object instance for each injection)
     */
    // Constructor injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach  theCoach,
                          @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("Constructor in: "+ getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    // expose "/dailyWorkout" endpoints
    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    // To check bean scope
    @GetMapping("/check-beanscope")
    public String check(){
        // Check to see if this is the same bean
        // true or false depending on bean scope Singleton: true if Prototype: false
        return "Comparing beans: myCoach == anotherCoach, "+ (myCoach == anotherCoach);
        // Output: false --> because the scope is prototype and in prototype new instance is created on every injection, 
        // hence false so myCoach and anotherCoach are not referencing same object
    }
}
