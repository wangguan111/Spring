package com.rabbitmq.consumer.topic;

import com.rabbitmq.common.queue.RabbitmqQueueKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitmqQueueKey.TOPIC_BINDING_KEY_SOME)
public class TopicSomeConsumer
{
    static Logger logger = LoggerFactory.getLogger(TopicSomeConsumer.class);

    @RabbitHandler
    public String execute(Long userId)
    {
        logger.info(RabbitmqQueueKey.TOPIC_ROUTING_KEY_SOME + " userID： " + userId);
        return RabbitmqQueueKey.TOPIC_ROUTING_KEY_SOME;
    }
}
