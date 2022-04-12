package com.self.content.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "baidu" ,url = "http://www.baidu.com")
public interface BaiduFeignClient {

    @GetMapping("")
    String index();

}
