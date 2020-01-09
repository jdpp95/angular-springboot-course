package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class RestfulWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServiceApplication.class, args);
    }
}
