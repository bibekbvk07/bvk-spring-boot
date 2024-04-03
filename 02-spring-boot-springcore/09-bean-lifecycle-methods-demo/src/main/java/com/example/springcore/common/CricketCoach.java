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

    /**
     * @PostConstruct: This annotation is used on a method that needs to be executed after dependency injection is done
     * to perform any initialization tasks. The annotated method will be called immediately after the bean has been
     * constructed and all dependencies have been injected. It's commonly used for initializing resources,
     * setting up connections, or performing any other setup tasks.
     * For example:
     */

    // define our init method
    @PostConstruct
    public void initializationMethod(){
        System.out.println("In your initializationMethod(): "+ getClass().getSimpleName() + " I am being initialized!");
    }

    /**
     * @PreDestroy: This annotation is used on a method that needs to be executed just before the bean is removed
     * from the Spring context. It marks a method to be called during the shutdown phase of the application context.
     * It's commonly used for releasing resources, closing connections, or performing any other cleanup tasks.
     *
     * For example:
     */

    // define our destroy method
    @PreDestroy
    public void cleanUpMethod(){
        System.out.println("In your cleanUpMethod(): "+ getClass().getSimpleName() + " Thanks for using me. Bye!!");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting in the nets with bowling machine!!";
    }
}
