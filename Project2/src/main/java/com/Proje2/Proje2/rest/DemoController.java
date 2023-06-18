package com.Proje2.Proje2.rest;

import com.Proje2.Proje2.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("swimbean") Coach theCoach){
        System.out.println("In constructor: "+ getClass().getSimpleName());
        myCoach=theCoach;
    }

    @GetMapping("/dailyworkout3")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
