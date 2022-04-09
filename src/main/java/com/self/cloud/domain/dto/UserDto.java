package com.self.cloud.domain.dto;

import com.self.cloud.domain.entity.User;
import lombok.Data;

@Data
public class UserDto extends User {

    private String other;

}
