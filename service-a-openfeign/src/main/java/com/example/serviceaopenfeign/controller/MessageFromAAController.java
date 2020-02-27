package com.example.serviceaopenfeign.controller;

import com.example.serviceaopenfeign.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api")
public class MessageFromAAController {

    @Autowired
    private MessageService messageService;

    @GetMapping("message-from-aa")
    public ResponseEntity sayHello() {
        String tempStr = messageService.getMessage();
        return ResponseEntity.ok("Hello, you got message from service aa: " + tempStr);

    }

}
