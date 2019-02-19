package com.rabbitmq.consumer.direct;

import com.rabbitmq.common.queue.RabbitmqQueueKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitmqQueueKey.DIRECT_BINDING_KEY_SOME)
public class DirectSomeConsumer
{
    static Logger logger = LoggerFactory.getLogger(DirectSomeConsumer.class);

    @RabbitHandler
    public String execute(Long userId)
    {
        logger.info(RabbitmqQueueKey.DIRECT_BINDING_KEY_SOME + " userID： " + userId);
        return RabbitmqQueueKey.DIRECT_BINDING_KEY_SOME;
    }
}
