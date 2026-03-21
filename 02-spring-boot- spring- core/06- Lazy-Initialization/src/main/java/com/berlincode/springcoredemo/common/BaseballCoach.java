package com.berlincode.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30mins in batting practice";
    }
}
