package com.proje1.proje1.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    @GetMapping("/teaminfo")
    public String getTeamInfp(){
        return "Coach: "+coachName+" team name: "+teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a gard";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "fuck you";
    }


}
