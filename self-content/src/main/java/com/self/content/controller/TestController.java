package com.self.content.controller;

import com.self.content.dao.ContentMapper;
import com.self.content.domain.dto.UserDto;
import com.self.content.domain.entity.Content;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Resource
    ContentMapper contentMapper;
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/test")
    public Object test() {
        return contentMapper.selectAll();
    }

    @GetMapping("/getId/{id}")
    public Content getId(@PathVariable("id") Integer id){
        Content content = contentMapper.selectByPrimaryKey(id);
        List<ServiceInstance> instances = discoveryClient.getInstances("service-user");
        String uri = instances.stream().map(instan -> instan.getUri().toString()).findFirst().orElseThrow(() -> new RuntimeException("service-user不存在"));
        UserDto userDto = restTemplate.getForObject(uri + "/user/getId/{id}", UserDto.class, content.getUserId());
        content.setUserDto(userDto);
        return content;
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
