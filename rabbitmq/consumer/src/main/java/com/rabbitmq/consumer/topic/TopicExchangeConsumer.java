package com.rabbitmq.consumer.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.common.queue.QueueKey;

@Component
@RabbitListener(queues = QueueKey.TOPIC_EXCHANGE_BINDING_KEY)
public class TopicExchangeConsumer
{
    static Logger logger = LoggerFactory.getLogger(TopicExchangeConsumer.class);

    @RabbitHandler
    public void execute(Long userId)
    {
        logger.info("Topic exchange， userID： " + userId);
    }
}
