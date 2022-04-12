package com.self.content.controller;

import com.self.content.dao.ContentMapper;
import com.self.content.domain.dto.UserDto;
import com.self.content.domain.entity.Content;
import com.self.content.feign.BaiduFeignClient;
import com.self.content.feign.UserFeignClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ContentController {

    @Resource
    ContentMapper contentMapper;
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    UserFeignClient userFeignClient;
    @Resource
    BaiduFeignClient baiduFeignClient;

    @GetMapping("/exposeGetUserIdAll/{userId}")
    public List<Content> exposeGetUserIdAll(@PathVariable("userId") Integer userId) {
        return contentMapper.selectByUserAll(userId);
    }

    @GetMapping("/exposeGetId/{id}")
    public Content exposeGetId(@PathVariable("id") Integer id) {
        Content content = contentMapper.selectByPrimaryKey(id);
        return content;
    }

    @GetMapping("/detailById/{id}")
    public Content detailById(@PathVariable("id") Integer id) {
        Content content = contentMapper.selectByPrimaryKey(id);
        UserDto userDto = userFeignClient.exposeGetId(content.getUserId());
        content.setUserDto(userDto);
        return content;
    }

    @GetMapping("/queryUser")
    public List<UserDto> queryUser(UserDto userDto) {
        return userFeignClient.exposeQueryUser(userDto);
    }

    @GetMapping("/baidu")
    public String baidu() {
        return baiduFeignClient.index();
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
