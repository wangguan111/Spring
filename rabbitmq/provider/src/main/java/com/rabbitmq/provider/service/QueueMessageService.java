package com.rabbitmq.provider.service;

import com.rabbitmq.common.exchange.ExchangeEnum;
import com.rabbitmq.common.queue.QueueEnum;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface QueueMessageService extends RabbitTemplate.ConfirmCallback
{
    void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws AmqpException;
    void send(Object message, QueueEnum queueEnum) throws AmqpException;
    void send(Object message, ExchangeEnum exchangeEnum, String queueEnum) throws AmqpException;
}
