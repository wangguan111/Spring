package com.rabbitmq.consumer.topic;

import com.rabbitmq.common.queue.RabbitmqQueueKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitmqQueueKey.TOPIC_BINDING_KEY_ONE)
public class TopicOneConsumer
{
    static Logger logger = LoggerFactory.getLogger(TopicOneConsumer.class);

    @RabbitHandler
    public String execute(Long userId)
    {
        logger.info(RabbitmqQueueKey.TOPIC_ROUTING_KEY_ONE + " userID： " + userId);
        return RabbitmqQueueKey.TOPIC_ROUTING_KEY_ONE;
    }
}
