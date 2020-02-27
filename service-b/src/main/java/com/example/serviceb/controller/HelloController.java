package com.example.serviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloController {

    @GetMapping("hello")
    public ResponseEntity sayHello(){
        System.out.println("~~~in service b");
        return ResponseEntity.ok("Hello, you got message from service b");

    }

}
