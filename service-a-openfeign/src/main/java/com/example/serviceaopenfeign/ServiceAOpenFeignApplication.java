package com.example.serviceaopenfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceAOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAOpenFeignApplication.class, args);
    }

}
