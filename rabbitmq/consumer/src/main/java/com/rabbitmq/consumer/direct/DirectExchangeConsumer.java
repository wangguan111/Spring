package com.rabbitmq.consumer.direct;

import com.rabbitmq.common.queue.QueueKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(queues = QueueKey.DIRECT_EXCHANGE_BINDING_KEY)
//public class DirectExchangeConsumer
//{
//    static Logger logger = LoggerFactory.getLogger(DirectExchangeConsumer.class);
//
//    @RabbitHandler
//    public void execute(Long userId)
//    {
//        logger.info("Direct exchange， userID： " + userId);
//    }
//}
