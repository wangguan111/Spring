package com.rabbitmq.common.queue;

public interface QueueKey
{
    //TOPIC_EXCHANGE
    public static final String TOPIC_EXCHANGE_BINDING_KEY = "user.topic.queue";
    public static final String TOPIC_EXCHANGE_ROUTING_KEY = "topic";

    //FANOUT_EXCHANGE
    public static final String FANOUT_EXCHANGE_BINDING_KEY = "user.fanout.queue";

    //DIRECT_EXCHANGE
    public static final String DIRECT_EXCHANGE_BINDING_KEY = "direct.queue";
    public static final String DIRECT_EXCHANGE_ROUTING_KEY = "direct";
}
