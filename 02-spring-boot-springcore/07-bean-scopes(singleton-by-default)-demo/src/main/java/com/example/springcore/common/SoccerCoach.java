package com.example.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{

    public SoccerCoach() {
        System.out.println("Constructor in: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice penalty shootout!!";
    }
}
