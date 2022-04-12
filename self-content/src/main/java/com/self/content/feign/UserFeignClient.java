package com.self.content.feign;

import com.self.content.domain.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-user")
public interface UserFeignClient {

    @GetMapping("/user/exposeGetId/{id}")
    UserDto exposeGetId(@PathVariable("id") Integer id);

}
