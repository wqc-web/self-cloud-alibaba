package com.self.rocketmq.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(consumerGroup = "self-group", topic = "self-topic")
public class SelfRocketMqListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("RocketMQListener: " + s);
    }
}
