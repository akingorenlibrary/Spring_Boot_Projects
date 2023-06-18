package com.Proje2.Proje2.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "SwimCoach practice fast bowling for 15 minutes.";
    }
}
