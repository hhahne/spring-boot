package com.henrik.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CardFrontentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardFrontentApplication.class, args);
    }
}
