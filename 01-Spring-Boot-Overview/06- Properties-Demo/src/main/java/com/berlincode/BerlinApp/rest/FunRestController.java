package com.berlincode.BerlinApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class FunRestController {
//    Inject properties for : coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private  String teamName;
//    Expose a new endpoint for "Team Info"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach : " + coachName + ", Team Name : " + teamName;
    }



    //expose "/" that returns "Hello World"
   @GetMapping("/")
    public String SayHello(){
//       System.out.println(coachName + " " + teamName);
        return "Hello World";
    }

//Expose a new endpoint for workout
    @GetMapping("/berlin")
    public String StartWorkout(){
       return "Complete your 10k Steps today";
    }

// expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String Startfortune(){
        return "Its your lucky day today";
    }
}
