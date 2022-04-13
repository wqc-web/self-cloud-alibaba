package com.self.content.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.self.content.service.ContentService;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

    @SentinelResource("say")
    @Override
    public String say() {
        return "content-say";
    }

}
