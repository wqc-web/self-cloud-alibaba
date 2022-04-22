package com.self.rocketmq.controller;

import com.self.rocketmq.domain.dto.MessageDto;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@RestController
public class SelfRocketMqController {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send")
    public String send(String data) {
        rocketMQTemplate.convertAndSend("self-topic", data);
        return data;
    }


    @GetMapping("/sendTransaction")
    public MessageDto sendTransaction(MessageDto messageDto) {
        messageDto.setId(new Random().nextInt(100));
        messageDto.setTime(LocalDateTime.now());
        rocketMQTemplate.sendMessageInTransaction(
                "self-transaction-topic",
                MessageBuilder
                        // 消息内容
                        .withPayload(messageDto.getContent() + messageDto.getTime().toString())
                        //传递消息头
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, UUID.randomUUID().toString())
                        .setHeader("self-id", messageDto.getId())
                        .build(),
                //传递参数对象
                messageDto
        );
        return messageDto;
    }
}
