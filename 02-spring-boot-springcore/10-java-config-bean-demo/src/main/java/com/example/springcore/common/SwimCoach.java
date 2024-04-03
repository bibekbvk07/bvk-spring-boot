package com.example.springcore.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("Constructor in: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 10 laps in a swimming pool!";
    }
}
