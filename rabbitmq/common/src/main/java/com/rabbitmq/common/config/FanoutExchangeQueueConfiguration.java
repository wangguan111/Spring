package com.rabbitmq.common.config;

import com.rabbitmq.common.exchange.RabbitmqExchange;
import com.rabbitmq.common.queue.RabbitmqQueueKey;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeQueueConfiguration extends ExchangeQueueConfiguration
{
    @Bean
    public Queue fanoutQueueQueue()
    {
        return new Queue(RabbitmqQueueKey.FANOUT_BINDING_KEY_QUEUE, durableQueue, exclusiveQueue, autoDeleteQueue);
    }

    @Bean
    public Queue fanoutQueueSome()
    {
        return new Queue(RabbitmqQueueKey.FANOUT_BINDING_KEY_SOME, durableQueue, exclusiveQueue, autoDeleteQueue);
    }

    @Bean
    public FanoutExchange fanoutExchange()
    {
        return new FanoutExchange (RabbitmqExchange.FANOUT_EXCHANGE, durableQueue, autoDeleteQueue);
    }

    //bind(queue.bindingKey).to(exchange).with(queue.routingKey)
    @Bean
    public Binding fanoutBindingQueue()
    {
        return BindingBuilder.bind(fanoutQueueQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingSome()
    {
        return BindingBuilder.bind(fanoutQueueSome()).to(fanoutExchange());
    }
}
