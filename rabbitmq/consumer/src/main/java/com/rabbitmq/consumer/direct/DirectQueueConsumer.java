package com.rabbitmq.consumer.direct;

import com.rabbitmq.common.queue.RabbitmqQueueKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitmqQueueKey.DIRECT_BINDING_KEY_QUEUE)
public class DirectQueueConsumer
{
    static Logger logger = LoggerFactory.getLogger(DirectQueueConsumer.class);

    @RabbitHandler
    public String execute(Long userId)
    {
        logger.info(RabbitmqQueueKey.DIRECT_BINDING_KEY_QUEUE + " userID： " + userId);
        return RabbitmqQueueKey.DIRECT_BINDING_KEY_QUEUE;
    }
}
