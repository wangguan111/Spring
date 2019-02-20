package com.rabbitmq.provider.service;

import com.rabbitmq.provider.entity.UserEntity;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional(rollbackFor = Exception.class)
public class MessageService
{
//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private QueueMessageService queueMessageService;

    private Long id = 1L;

    public Long send(String exchange, String routingKey, UserEntity userEntity) throws AmqpException
    {
//      userRepository.send(userEntity);
        if(userEntity.getId() == null)
        {
            userEntity.setId(id);
            id++;
        }
        queueMessageService.send(exchange, routingKey, userEntity.getId());

        return userEntity.getId();
    }
}
