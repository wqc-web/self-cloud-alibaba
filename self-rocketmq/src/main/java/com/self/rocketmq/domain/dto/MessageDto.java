package com.self.rocketmq.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {
    private Integer id;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime time;
}
