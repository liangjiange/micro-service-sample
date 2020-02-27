package com.example.serviceb.controller;

import com.liangjiange.message.service.IMessageService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MessageController {

    @Reference
    private IMessageService iMessageService;

    @GetMapping("message")
    public ResponseEntity getMessage(){
        String message = iMessageService.getMessage();
        return ResponseEntity.ok("Hello, you got message from service b: "+message);

    }

}
