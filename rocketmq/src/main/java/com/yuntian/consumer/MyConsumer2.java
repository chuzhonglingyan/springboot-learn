package com.yuntian.consumer;

import com.yuntian.constant.Topic;
import com.yuntian.event.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author guangleilei.
 * @date Created in 10:55 2019/11/19
 * @description
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = Topic.TEST_TOPIC_2, consumerGroup = "my-consumer_"+Topic.TEST_TOPIC_2)
public class MyConsumer2 implements RocketMQListener<OrderPaidEvent>{
    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.info("received orderPaidEvent: {}", orderPaidEvent);
    }
}
