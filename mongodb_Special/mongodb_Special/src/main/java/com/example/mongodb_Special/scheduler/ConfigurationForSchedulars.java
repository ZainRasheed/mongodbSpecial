package com.example.mongodb_Special.scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationForSchedulars {

    @Bean(initMethod = "init")
    public ToCallSchedularAndTimerClass createBean(){
        return new ToCallSchedularAndTimerClass();
    }
}
