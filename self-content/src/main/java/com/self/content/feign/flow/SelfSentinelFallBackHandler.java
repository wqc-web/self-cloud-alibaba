package com.self.content.feign.flow;

public class SelfSentinelFallBackHandler {

    public static String fallback(String a, Throwable t) {
        return "限流或降级 fallback: " + t.getMessage();
    }

}
