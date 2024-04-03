package com.example.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Component class marks the class as spring bean and makes is available for dependency injection
@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("Constructor in: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting in the nets with bowling machine!!";
    }
}
