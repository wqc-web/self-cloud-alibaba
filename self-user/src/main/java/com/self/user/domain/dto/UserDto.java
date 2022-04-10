package com.self.user.domain.dto;


import com.self.user.domain.entity.User;
import lombok.Data;

@Data
public class UserDto extends User {

    private String other;

}
