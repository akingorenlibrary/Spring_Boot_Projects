package com.Proje2.Proje2.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swimbean")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
