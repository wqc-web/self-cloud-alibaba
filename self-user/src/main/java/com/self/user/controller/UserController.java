package com.self.user.controller;

import com.self.user.dao.UserMapper;
import com.self.user.domain.dto.ContentDto;
import com.self.user.domain.entity.User;
import com.self.user.feign.ContentFeignClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Resource
    UserMapper userMapper;
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    ContentFeignClient contentFeignClient;

    @GetMapping("/exposeGetId/{id}")
    public User exposeGetId(@PathVariable("id") Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/detailById/{id}")
    public User detailById(@PathVariable("id") Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        List<ContentDto> contentDtoList = contentFeignClient.exposeGetUserIdAll(user.getId());
        user.setContentDtoList(contentDtoList);
        return user;
    }

    @GetMapping("/queryUser")
    public List<User> queryUser(User user) {
        return userMapper.queryUser(user);
    }

    @GetMapping("/nacosServiceList")
    public List<List> nacosServiceList() {
        List<List> dataList = new ArrayList<>();
        List<String> serviceIdList = discoveryClient.getServices();
        for (String serviceId : serviceIdList) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            dataList.add(instances);
        }
        return dataList;
    }

}
