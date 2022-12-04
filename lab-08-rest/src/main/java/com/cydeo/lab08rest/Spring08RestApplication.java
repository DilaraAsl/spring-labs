package com.cydeo.lab08rest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring08RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring08RestApplication.class, args);
    }
@Bean
    ModelMapper mapper(){
        return new ModelMapper();
}
}
