package com.self.cloud.controller;

import com.self.cloud.dao.UserMapper;
import com.self.cloud.domain.dto.UserDto;
import com.self.cloud.domain.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    UserMapper userMapper;

    @GetMapping("/test")
    public Object test(){
        List<User> userList = userMapper.selectAll();
        User user = userList.get(0);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user , userDto);
        userDto.setOther("其他");
        return userDto;
    }

}
