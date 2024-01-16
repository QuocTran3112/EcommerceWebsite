package com.example.pij1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Pij1Application {

    public static void main(String[] args) {
        SpringApplication.run(Pij1Application.class, args);
    }

}
