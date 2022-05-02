package com.self.content.configuration;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局针对来源
 */
//@Component
public class SelfOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        //
        String origin = request.getParameter("origin");
        if(origin == null || "".equals(origin)){
            throw new IllegalArgumentException("origin must exist");
        }
        //return 针对来源
        return origin;
    }
}
