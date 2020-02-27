package com.example.servicerestaa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MessageController {

    @GetMapping("message-from-service-rest-aa")
    public ResponseEntity getMessage(){
        System.out.println("this is message from service rest aa");
        return ResponseEntity.ok("this is message from service rest aa");
    }

}
