package com.rabbitmq.provider.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface QueueMessageService extends RabbitTemplate.ConfirmCallback
{
    void send(String exchange, String routingKey, Object message) throws AmqpException;
}
