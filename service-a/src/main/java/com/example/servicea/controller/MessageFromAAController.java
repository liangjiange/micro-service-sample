package com.example.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageFromAAController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("message-from-aa")
    public ResponseEntity sayHello() {
        String tempStr = restTemplate.getForObject("http://service-rest-aa/api/message-from-service-rest-aa", String.class);
        return ResponseEntity.ok("Hello, you got message from service aa: " + tempStr);

    }

}
