package com.rabbitmq.provider.control;

import com.rabbitmq.common.exchange.RabbitmqExchange;
import com.rabbitmq.provider.entity.UserEntity;
import com.rabbitmq.provider.service.MessageService;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fanout")
public class FanoutController
{
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/queue")
    public UserEntity saveTopicQueue(UserEntity userEntity) throws AmqpException
    {
        messageService.send(RabbitmqExchange.FANOUT_EXCHANGE, null, userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/some")
    public UserEntity saveTopicSome(UserEntity userEntity) throws AmqpException
    {
        messageService.send(RabbitmqExchange.FANOUT_EXCHANGE,null, userEntity);
        return userEntity;
    }
}
