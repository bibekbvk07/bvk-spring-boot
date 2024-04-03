package com.example.springcore.config;

import com.example.springcore.common.Coach;
import com.example.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // We can give customized bean id like @Bean("aquatic") can pass it into the @Qualifier
    @Bean // the bean id (swimCoach) defaults to the method name
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
