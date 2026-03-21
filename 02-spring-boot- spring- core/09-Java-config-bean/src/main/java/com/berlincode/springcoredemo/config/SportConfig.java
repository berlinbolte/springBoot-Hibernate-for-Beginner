package com.berlincode.springcoredemo.config;

import com.berlincode.springcoredemo.common.Coach;
import com.berlincode.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("Neon")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
