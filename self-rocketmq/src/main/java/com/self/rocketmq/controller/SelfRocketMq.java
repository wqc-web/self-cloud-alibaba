package com.self.rocketmq.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelfRocketMq {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send")
    public String send(String data){
        rocketMQTemplate.convertAndSend("self-topic" , data);
        return data;
    }

}
