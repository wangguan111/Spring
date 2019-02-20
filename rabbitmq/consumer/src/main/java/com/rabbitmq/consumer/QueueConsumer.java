package com.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import java.io.IOException;

public class QueueConsumer
{
    static Logger logger = LoggerFactory.getLogger(QueueConsumer.class);

    public void execute(Long userId, Message message, Channel channel) throws IOException
    {
        try
        {
            //delete message
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (message.getMessageProperties().getRedelivered())
            {
                logger.info("message has been executed, can not execute again");
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
            }
            else
            {
                logger.info("message will be back queue again to execute");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); // requeue为是否重新回到队列
            }
        }
    }
}
