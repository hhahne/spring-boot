package com.henrik.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CardServiceApplication {

    @Value("${hello:DEFAULTHELLO}")
    private String testProp;

    @Value("${test:DEFAULTVALUE}")
    private String cardServiceProp;

    @Autowired
    void setEnvironment(Environment e) {
//        System.out.println("Property fra en property fil: " + e.getProperty("aloha"));
//        System.out.println("Property fra spesifikk fil: " + e.getProperty("test"));
//        System.out.println("Test");
        System.out.println(testProp);
        System.out.println(cardServiceProp);
    }

    public static void main(String[] args) {


        SpringApplication.run(CardServiceApplication.class, args);
    }
}
