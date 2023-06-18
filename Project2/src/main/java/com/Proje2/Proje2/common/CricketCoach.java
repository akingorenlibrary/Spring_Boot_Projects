package com.Proje2.Proje2.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
/*
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff():"+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff():"+getClass().getSimpleName());
    }
*/
    @Override
    public String getDailyWorkout() {
        return "CricketCoach practice fast bowling for 15 minutes.";
    }
}
