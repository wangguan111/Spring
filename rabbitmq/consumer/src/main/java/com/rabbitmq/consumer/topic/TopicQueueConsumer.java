package com.rabbitmq.consumer.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.common.queue.RabbitmqQueueKey;

@Component
@RabbitListener(queues = RabbitmqQueueKey.TOPIC_BINDING_KEY_QUEUE)
public class TopicQueueConsumer
{
    static Logger logger = LoggerFactory.getLogger(TopicQueueConsumer.class);

    @RabbitHandler
    public String execute(Long userId)
    {
        logger.info(RabbitmqQueueKey.TOPIC_ROUTING_KEY_QUEUE + " userID： " + userId);
        return RabbitmqQueueKey.TOPIC_ROUTING_KEY_QUEUE;
    }
}
