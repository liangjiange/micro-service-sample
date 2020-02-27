package com.example.servicea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${my.config.test}")
    private String configTest;

    @GetMapping("config/test")
    public ResponseEntity sayHello() {
        System.out.println("~~~in service a config test");
        return ResponseEntity.ok("Hello, you got service a config: " + configTest);

    }

}
