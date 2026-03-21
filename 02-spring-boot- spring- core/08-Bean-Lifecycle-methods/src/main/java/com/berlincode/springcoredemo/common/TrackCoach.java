package com.berlincode.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a Hard 5k steps";
    }
}
