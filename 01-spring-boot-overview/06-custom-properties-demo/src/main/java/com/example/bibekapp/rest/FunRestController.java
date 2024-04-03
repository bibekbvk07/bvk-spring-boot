package com.example.bibekapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose "/team-info" to return team info from custom properties file
    @GetMapping("/team-info")
    public String getTeamInfo(){
        return "Coach: "+ this.coachName + ", Team Name: "+ this.teamName;
    }

    // expose "/" endpoints to say hello world

    @GetMapping("/")
    public String sayHello(){
        return "Welcome and Hello World!";
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
