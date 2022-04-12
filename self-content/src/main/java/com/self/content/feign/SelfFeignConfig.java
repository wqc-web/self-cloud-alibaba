package com.self.content.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 添加@Configuration会导致Spring父子上下文扫描重叠
 */

public class SelfFeignConfig {
    @Bean
    public Logger.Level level() {
        // 让feign打印所有请求细节
        return Logger.Level.FULL;
    }
}
