package com.berlincode.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bollwing for 15mins atleast!!!!";
    }
}
