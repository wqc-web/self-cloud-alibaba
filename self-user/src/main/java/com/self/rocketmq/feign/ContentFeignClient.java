package com.self.rocketmq.feign;

import com.self.rocketmq.domain.dto.ContentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-content")
public interface ContentFeignClient {

    @GetMapping("/content/exposeGetUserIdAll/{userId}")
    List<ContentDto> exposeGetUserIdAll(@PathVariable("userId") Integer userId);

    @GetMapping("/content/exposeGetId/{id}")
    ContentDto exposeGetId(@PathVariable("id") Integer id);

}
