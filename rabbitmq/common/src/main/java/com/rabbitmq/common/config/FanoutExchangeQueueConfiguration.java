package com.rabbitmq.common.config;

import com.rabbitmq.common.exchange.ExchangeEnum;
import com.rabbitmq.common.queue.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class FanoutExchangeQueueConfiguration
//{
//    @Bean
//    public Queue fanoutExchangeQueue()
//    {
//        return new Queue(QueueEnum.FANOUT_EXCHANGE_QUEUE.getBindingKey(),true);
//    }
//
//    @Bean
//    public FanoutExchange fanoutExchange()
//    {
//        return new FanoutExchange (ExchangeEnum.FANOUT_EXCHANGE.getKey());
//    }
//
//    //bind(queue.bindingKey).to(topic.exchange.key).with(queue.routingKey)
//    @Bean
//    public Binding fanoutExchangeBinding()
//    {
//        return BindingBuilder.bind(fanoutExchangeQueue()).to(fanoutExchange());
//    }
//
//}
