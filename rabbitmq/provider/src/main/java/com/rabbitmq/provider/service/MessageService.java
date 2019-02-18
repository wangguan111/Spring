package com.rabbitmq.provider.service;

import com.rabbitmq.common.exchange.ExchangeEnum;
import com.rabbitmq.common.queue.QueueEnum;

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

    public Long saveTopic(UserEntity userEntity) throws AmqpException
    {
//      userRepository.save(userEntity);
        if(userEntity.getId() == null)
        {
            userEntity.setId(id);
            id++;
        }
        queueMessageService.send(userEntity.getId(), ExchangeEnum.TOPIC_EXCHANGE, QueueEnum.TOPIC_EXCHANGE_QUEUE);

        return userEntity.getId();
    }

    public Long saveDirect(UserEntity userEntity) throws AmqpException
    {
        if(userEntity.getId() == null)
        {
            userEntity.setId(id);
            id++;
        }
        queueMessageService.send(userEntity.getId(), QueueEnum.TOPIC_EXCHANGE_QUEUE);

        return userEntity.getId();
    }

    public Long saveFanout(UserEntity userEntity) throws AmqpException
    {
        if(userEntity.getId() == null)
        {
            userEntity.setId(id);
            id++;
        }
        queueMessageService.send(userEntity.getId(), ExchangeEnum.FANOUT_EXCHANGE, "");

        return userEntity.getId();
    }
}
