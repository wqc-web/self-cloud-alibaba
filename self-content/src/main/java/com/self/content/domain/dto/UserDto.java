package com.self.content.domain.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;

    private String name;

    private String password;

    private String phone;

    private String source;

    private String wxId;

    private String address;
}