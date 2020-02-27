package com.example.servicea.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    @SentinelResource("hello")
    public ResponseEntity sayHello() {
        System.out.println("~~~in service a");
        return ResponseEntity.ok("Hello, you got message from service a");

    }

}
