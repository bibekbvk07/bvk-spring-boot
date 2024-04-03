package com.example.springcore.common;

import org.springframework.stereotype.Component;

// Component class marks the class as spring bean and makes is available for dependency injection
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice bowling in nets for 1 hr every day!!";
    }
}
