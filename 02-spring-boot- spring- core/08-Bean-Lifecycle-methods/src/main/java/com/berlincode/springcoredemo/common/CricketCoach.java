package com.berlincode.springcoredemo.common;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

//    Defining your init methods
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStarupStuff() : "  + getClass().getSimpleName());
    }
//    Defining your destroy methods
    @PreDestroy
    public void doMyCleanupStff(){
        System.out.println("In doMyCleanupStff() : "  + getClass().getSimpleName());
    }


    public CricketCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bollwing for 15mins atleast :)!!!!";
    }
}
