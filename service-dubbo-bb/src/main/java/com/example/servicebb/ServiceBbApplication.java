package com.example.servicebb;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ServiceBbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBbApplication.class, args);
    }

}
