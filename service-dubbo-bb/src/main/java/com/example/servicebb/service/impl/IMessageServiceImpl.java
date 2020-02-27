package com.example.servicebb.service.impl;

import com.liangjiange.message.service.IMessageService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class IMessageServiceImpl implements IMessageService {
    @Override
    public String getMessage() {
        System.out.println("in service dubbo bb");
        return "message from service dubbo bb";
    }
}
