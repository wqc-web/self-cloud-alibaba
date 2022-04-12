package com.self.user.domain.dto;

import lombok.Data;

@Data
public class ContentDto {
    private Integer id;

    private String title;

    private String content;

    private String comment;

    private Integer userId;
}