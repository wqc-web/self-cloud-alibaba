package com.self.content.feign.flow;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SelfSentinelBlockHandler {

    public static String block(String a, BlockException e){
        return "限流或降级 block: " + e.getMessage();
    }

}
