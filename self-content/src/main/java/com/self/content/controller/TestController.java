package com.self.content.controller;

import com.self.content.dao.ContentMapper;
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
    ContentMapper contentMapper;
    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public Object test() {
        return contentMapper.selectAll();
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
