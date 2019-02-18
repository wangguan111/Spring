package com.rabbitmq.consumer.fanout;

import com.rabbitmq.common.queue.QueueKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(queues = QueueKey.FANOUT_EXCHANGE_BINDING_KEY)
//public class FanoutExchangeConsumer
//{
//    static Logger logger = LoggerFactory.getLogger(FanoutExchangeConsumer.class);
//
//    @RabbitHandler
//    public void execute(Long userId)
//    {
//        logger.info("Fanout exchange， userID： " + userId);
//    }
//}
