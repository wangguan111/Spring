package com.rabbitmq.common.config;

import com.rabbitmq.common.exchange.ExchangeEnum;
import com.rabbitmq.common.queue.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeQueueConfiguration
{
    @Bean
    public Queue topicExchangeQueue()
    {
        return new Queue(QueueEnum.TOPIC_EXCHANGE_QUEUE.getBindingKey(),true);
    }

    @Bean
    public TopicExchange topicExchange()
    {
        return new TopicExchange(ExchangeEnum.TOPIC_EXCHANGE.getKey());
    }

    //bind(queue.bindingKey).to(topic.exchange.key).with(queue.routingKey)
    @Bean
    public Binding topicExchangeBinding()
    {
        return BindingBuilder.bind(topicExchangeQueue()).to(topicExchange()).with(QueueEnum.TOPIC_EXCHANGE_QUEUE.getRoutingKey());
    }
}
