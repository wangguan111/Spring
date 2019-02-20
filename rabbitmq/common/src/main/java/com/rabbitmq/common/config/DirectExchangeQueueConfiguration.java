package com.rabbitmq.common.config;

import com.rabbitmq.common.exchange.RabbitmqExchange;
import com.rabbitmq.common.queue.RabbitmqQueueKey;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeQueueConfiguration extends ExchangeQueueConfiguration
{
    @Bean
    public Queue directQueueQueue()
    {
        return new Queue(RabbitmqQueueKey.DIRECT_BINDING_KEY_QUEUE, durableQueue, exclusiveQueue, autoDeleteQueue);
    }

    @Bean
    public Queue directQueueSome()
    {
        return new Queue(RabbitmqQueueKey.DIRECT_BINDING_KEY_SOME, durableQueue, exclusiveQueue, autoDeleteQueue);
    }

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(RabbitmqExchange.DIRECT_EXCHANGE, durableQueue, autoDeleteQueue);
    }

    //bind(queue.bindingKey).to(direct.exchange).with(queue.routingKey)
    @Bean
    public Binding directBindingQueue()
    {
        return BindingBuilder.bind(directQueueQueue()).to(directExchange()).with(RabbitmqQueueKey.DIRECT_ROUTING_KEY_QUEUE);
    }

    @Bean
    public Binding directBindingSome()
    {
        return BindingBuilder.bind(directQueueSome()).to(directExchange()).with(RabbitmqQueueKey.DIRECT_ROUTING_KEY_SOME);
    }
}
