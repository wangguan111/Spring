package com.rabbitmq.provider.control;

import com.rabbitmq.provider.service.MessageService;
import com.rabbitmq.provider.entity.UserEntity;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class MessageController
{
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/topic")
    public UserEntity saveTopic(UserEntity userEntity) throws AmqpException
    {
        messageService.saveTopic(userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/direct")
    public UserEntity saveDirect(UserEntity userEntity) throws AmqpException
    {
        messageService.saveDirect(userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/fanout")
    public UserEntity saveFanout(UserEntity userEntity) throws AmqpException
    {
        messageService.saveFanout(userEntity);
        return userEntity;
    }
}
