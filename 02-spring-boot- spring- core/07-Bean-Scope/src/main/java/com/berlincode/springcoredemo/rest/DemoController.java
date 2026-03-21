package com.berlincode.springcoredemo.rest;

import com.berlincode.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for dependencies
    private Coach myCoach;
    private Coach antoherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach TheAnotherCoach){
        System.out.println("In Constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
        antoherCoach = TheAnotherCoach;
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing myCoach == anotherCoach , " + (myCoach == antoherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
