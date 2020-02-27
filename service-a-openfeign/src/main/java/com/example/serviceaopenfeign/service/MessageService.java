package com.example.serviceaopenfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-rest-aa")
public interface MessageService {

    @RequestMapping("api/message-from-service-rest-aa")
    String getMessage();

}
