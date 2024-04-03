package com.example.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice 3-pointer shootout!!";
    }
}
