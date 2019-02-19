package com.rabbitmq.provider.control;

import com.rabbitmq.common.exchange.RabbitmqExchange;
import com.rabbitmq.common.queue.RabbitmqQueueKey;
import com.rabbitmq.provider.service.MessageService;
import com.rabbitmq.provider.entity.UserEntity;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/topic")
public class TopicController
{
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/queue")
    public UserEntity saveTopicQueue(UserEntity userEntity) throws AmqpException
    {
        messageService.send(RabbitmqExchange.TOPIC_EXCHANGE, RabbitmqQueueKey.TOPIC_ROUTING_KEY_QUEUE, userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/some")
    public UserEntity saveTopicSome(UserEntity userEntity) throws AmqpException
    {
        messageService.send(RabbitmqExchange.TOPIC_EXCHANGE, RabbitmqQueueKey.TOPIC_ROUTING_KEY_SOME, userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/one")
    public UserEntity saveTopicOne(UserEntity userEntity) throws AmqpException
    {
        messageService.send(RabbitmqExchange.TOPIC_EXCHANGE, RabbitmqQueueKey.TOPIC_ROUTING_KEY_ONE, userEntity);
        return userEntity;
    }
}
