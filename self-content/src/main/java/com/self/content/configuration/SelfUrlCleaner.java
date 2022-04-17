package com.self.content.configuration;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.UrlCleaner;
import org.springframework.stereotype.Component;

/**
 * REST风格API处理
 */
@Component
public class SelfUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String originUrl) {
        if(originUrl.startsWith("/detailById")){
            return "/detailById/*";
        }
        return originUrl;
    }
}
