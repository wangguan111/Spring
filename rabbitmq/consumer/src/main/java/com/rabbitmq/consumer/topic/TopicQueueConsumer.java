package com.rabbitmq.consumer.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.consumer.QueueConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.common.queue.RabbitmqQueueKey;
import java.io.IOException;

@Component
@RabbitListener(queues = RabbitmqQueueKey.TOPIC_BINDING_KEY_QUEUE)
public class TopicQueueConsumer extends QueueConsumer
{
    static Logger logger = LoggerFactory.getLogger(TopicQueueConsumer.class);

    @RabbitHandler
    public void execute(Long userId, Message message, Channel channel) throws IOException
    {
        logger.info(RabbitmqQueueKey.TOPIC_ROUTING_KEY_QUEUE + " userID： " + userId);
        super.execute(userId, message, channel);
    }
}
