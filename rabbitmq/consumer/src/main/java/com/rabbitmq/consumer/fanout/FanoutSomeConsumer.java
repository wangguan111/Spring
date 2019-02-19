package com.rabbitmq.consumer.fanout;

import com.rabbitmq.common.queue.RabbitmqQueueKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitmqQueueKey.FANOUT_BINDING_KEY_SOME)
public class FanoutSomeConsumer
{
    static Logger logger = LoggerFactory.getLogger(FanoutSomeConsumer.class);

    @RabbitHandler
    public String execute(Long userId)
    {
        logger.info(RabbitmqQueueKey.FANOUT_BINDING_KEY_SOME + " userID： " + userId);
        return RabbitmqQueueKey.FANOUT_BINDING_KEY_SOME;
    }
}
