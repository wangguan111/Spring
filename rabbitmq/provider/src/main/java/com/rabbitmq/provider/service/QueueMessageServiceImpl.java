package com.rabbitmq.provider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
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
    public void send(String exchange, String routingKey, Object message) throws AmqpException
    {
        //set call back
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        //send message queue
       rabbitTemplate.convertAndSend(exchange, routingKey, message,correlationId);
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

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey)
    {
        logger.info("[message]  " + message);
        logger.info("[replyCode]  " + replyCode);
        logger.info("[replyText]  " + replyText);
        logger.info("[exchange]  " + exchange);
        logger.info("[routingKey]  " + routingKey);
    }
}
