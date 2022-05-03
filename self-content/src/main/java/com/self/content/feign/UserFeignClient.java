package com.self.content.feign;

import com.self.content.domain.dto.UserDto;
import com.self.content.feign.sentinel.SelfFeignSentinelFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "service-user", fallbackFactory = SelfFeignSentinelFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/user/exposeGetId/{id}")
    UserDto exposeGetId(@PathVariable("id") Integer id);

    @GetMapping("/user/exposeQueryUser")
    List<UserDto> exposeQueryUser(@SpringQueryMap UserDto user);

    @GetMapping("/user/login")
    UserDto login(@RequestHeader("userId") Integer userId);
}
