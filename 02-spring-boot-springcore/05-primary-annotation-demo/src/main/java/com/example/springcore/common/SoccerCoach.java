package com.example.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice penalty shootout!!";
    }
}
