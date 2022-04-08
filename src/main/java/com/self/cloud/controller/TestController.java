package com.self.cloud.controller;

import com.self.cloud.dao.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    UserMapper userMapper;

    @GetMapping("/test")
    public Object test(){
        return userMapper.selectAll();
    }

}
