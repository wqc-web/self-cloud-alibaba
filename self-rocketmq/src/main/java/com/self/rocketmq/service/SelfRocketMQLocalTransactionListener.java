package com.self.rocketmq.service;

import com.self.rocketmq.domain.dto.MessageDto;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

@RocketMQTransactionListener
public class SelfRocketMQLocalTransactionListener implements RocketMQLocalTransactionListener {

    /**
     * 确认
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg) {
        //获取传递参数
        MessageHeaders headers = message.getHeaders();
        String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
        String selfId = (String) headers.get("self-id");
        //业务操作
        try {
            MessageDto messageDto = (MessageDto) arg;
            Object payload = message.getPayload();
            //RocketMQ提交
            return RocketMQLocalTransactionState.COMMIT;
        }catch (Exception e){
            //RocketMQ回滚
            return RocketMQLocalTransactionState.ROLLBACK;
        }

    }

    /**
     * 回查
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        //获取传递参数
        MessageHeaders headers = message.getHeaders();
        String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
        String selfId = (String) headers.get("self-id");
        Object payload = message.getPayload();
        return RocketMQLocalTransactionState.COMMIT;
    }

}
