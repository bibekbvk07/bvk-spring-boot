package com.example.bibekapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" endpoints to say hello world

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    // expose "/workout" endpoints to run 5K

    @GetMapping("/workout")
    public String dailyWorkout(){
        return "Run 5k mile every day.";
    }

    // expose "/fortune" endpoints to say fortune

    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day.";
    }
}
