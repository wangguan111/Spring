package com.rabbitmq.consumer.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.common.queue.RabbitmqQueueKey;
import com.rabbitmq.consumer.QueueConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@RabbitListener(queues = RabbitmqQueueKey.FANOUT_BINDING_KEY_SOME)
public class FanoutSomeConsumer extends QueueConsumer
{
    static Logger logger = LoggerFactory.getLogger(FanoutSomeConsumer.class);

    @RabbitHandler
    public void execute(Long userId, Message message, Channel channel) throws IOException
    {
        logger.info(RabbitmqQueueKey.FANOUT_BINDING_KEY_SOME + " userID： " + userId);
        super.execute(userId, message, channel);
    }
}
