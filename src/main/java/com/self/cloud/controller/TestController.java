package com.self.cloud.controller;

import com.self.cloud.dao.UserMapper;
import com.self.cloud.domain.dto.UserDto;
import com.self.cloud.domain.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Resource
    UserMapper userMapper;
    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public Object test(){
        List<User> userList = userMapper.selectAll();
        User user = userList.get(0);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user , userDto);
        userDto.setOther("其他");
        return userDto;
    }

    @GetMapping("/nacosServiceList")
    public List<List> nacosServiceList(){
        List<List> dataList = new ArrayList<>();
        List<String> serviceIdList = discoveryClient.getServices();
        for (String serviceId : serviceIdList) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            dataList.add(instances);
        }
        return dataList;
    }

}
