package com.self.rocketmq.service;

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
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        //获取传递参数
        MessageHeaders headers = message.getHeaders();
        String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
        Integer id = (Integer) headers.get("id");
        //业务操作
        try {



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
        return null;
    }
}
