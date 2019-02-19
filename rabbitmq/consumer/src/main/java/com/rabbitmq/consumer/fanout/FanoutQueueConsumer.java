package com.rabbitmq.consumer.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.common.queue.RabbitmqQueueKey;

@Component
@RabbitListener(queues = RabbitmqQueueKey.FANOUT_BINDING_KEY_QUEUE)
public class FanoutQueueConsumer
{
    static Logger logger = LoggerFactory.getLogger(FanoutQueueConsumer.class);

    @RabbitHandler
    public String execute(Long userId)
    {
        logger.info(RabbitmqQueueKey.FANOUT_BINDING_KEY_QUEUE + " userID： " + userId);
        return RabbitmqQueueKey.FANOUT_BINDING_KEY_QUEUE;
    }
}
