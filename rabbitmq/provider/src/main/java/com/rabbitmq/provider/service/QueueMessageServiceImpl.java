package com.rabbitmq.provider.service;

import com.rabbitmq.common.exchange.ExchangeEnum;
import com.rabbitmq.common.queue.QueueEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QueueMessageServiceImpl implements QueueMessageService
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    static Logger logger = LoggerFactory.getLogger(QueueMessageServiceImpl.class);

    @Override
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws AmqpException
    {
        //set call back
        rabbitTemplate.setConfirmCallback(this);

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        //send message queue
       rabbitTemplate.convertAndSend(exchangeEnum.getKey(),queueEnum.getRoutingKey(),message,correlationId);
    }

    @Override
    public void send(Object message, QueueEnum queueEnum) throws AmqpException
    {
        //set call back
        rabbitTemplate.setConfirmCallback(this);

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        //send message queue
        rabbitTemplate.convertAndSend(queueEnum.getRoutingKey(),message,correlationId);
    }

    @Override
    public void send(Object message, ExchangeEnum exchangeEnum, String queueEnum) throws AmqpException
    {
        //set call back
        rabbitTemplate.setConfirmCallback(this);

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        //send message queue
        rabbitTemplate.convertAndSend(exchangeEnum.getKey(),queueEnum, message,correlationId);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause)
    {
        logger.info(" Callback id:" + correlationData.getId());
        if (ack)
        {
            logger.info("Send Message successful");
        }
        else
        {
            logger.info("Send Message failed:" + cause);
        }
    }
}
