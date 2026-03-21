package com.berlincode.BerlinApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private  String teamName;
    //expose "/" that returns "Hello World"
   @GetMapping("/")
    public String SayHello(){
       System.out.println(coachName + " " + teamName);
        return "Hello World";
    }

}
