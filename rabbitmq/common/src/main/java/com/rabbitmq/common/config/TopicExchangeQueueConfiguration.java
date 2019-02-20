package com.rabbitmq.common.config;

import com.rabbitmq.common.exchange.RabbitmqExchange;
import com.rabbitmq.common.queue.RabbitmqQueueKey;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeQueueConfiguration extends ExchangeQueueConfiguration
{
    @Bean
    public Queue topicQueueQueue()
    {
        return new Queue(RabbitmqQueueKey.TOPIC_BINDING_KEY_QUEUE, durableQueue, exclusiveQueue, autoDeleteQueue);
    }

    @Bean
    public Queue topicQueueB()
    {
        return new Queue(RabbitmqQueueKey.TOPIC_BINDING_KEY_ONE, durableQueue, exclusiveQueue, autoDeleteQueue);
    }

    @Bean
    public Queue topicQueueA()
    {
        return new Queue(RabbitmqQueueKey.TOPIC_BINDING_KEY_SOME, durableQueue, exclusiveQueue, autoDeleteQueue);
    }

    @Bean
    public TopicExchange topicExchange()
    {
        return new TopicExchange(RabbitmqExchange.TOPIC_EXCHANGE, durableQueue, autoDeleteQueue);
    }

    //bind(queue.bindingKey).to(exchange).with(queue.routingKey)
    @Bean
    public Binding topicBindingQueue()
    {
        return BindingBuilder.bind(topicQueueQueue()).to(topicExchange()).with(RabbitmqQueueKey.TOPIC_ROUTING_KEY_QUEUE);
    }

    @Bean
    public Binding topicBindingA()
    {
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with(RabbitmqQueueKey.TOPIC_ROUTING_KEY_SOME);
    }

    @Bean
    public Binding topicBindingB()
    {
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with(RabbitmqQueueKey.TOPIC_ROUTING_KEY_ONE);
    }
}
