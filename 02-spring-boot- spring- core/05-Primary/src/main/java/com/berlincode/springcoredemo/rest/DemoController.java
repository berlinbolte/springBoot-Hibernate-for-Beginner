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

    //This below code is for @Qualifier which has more priority compared to @primary
//    @Autowired
//    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
//        myCoach = theCoach;
//    }

    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
