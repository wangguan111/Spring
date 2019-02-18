package com.rabbitmq.common.config;

import com.rabbitmq.common.exchange.ExchangeEnum;
import com.rabbitmq.common.queue.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class DirectExchangeQueueConfiguration
//{
//    @Bean
//    public Queue directExchangeQueue()
//    {
//        return new Queue(QueueEnum.DIRECT_EXCHANGE_QUEUE.getBindingKey(),true);
//    }
//
//    @Bean
//    public DirectExchange directExchange()
//    {
//        return new DirectExchange(ExchangeEnum.DIRECT_EXCHANGE.getKey());
//    }
//
//    //bind(queue.bindingKey).to(topic.exchange.key).with(queue.routingKey)
//    @Bean
//    public Binding directExchangeBinding()
//    {
//        return BindingBuilder.bind(directExchangeQueue()).to(directExchange()).with(QueueEnum.DIRECT_EXCHANGE_QUEUE.getRoutingKey());
//    }
//}
