package com.example.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("Constructor in: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run hard 5k!";
    }
}
