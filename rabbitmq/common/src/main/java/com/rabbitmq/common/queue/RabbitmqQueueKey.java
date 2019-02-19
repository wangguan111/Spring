package com.rabbitmq.common.queue;

public interface RabbitmqQueueKey
{
    //TOPIC_EXCHANGE
    public static final String TOPIC_BINDING_KEY_QUEUE = "topic.queue";
    public static final String TOPIC_BINDING_KEY_SOME = "topic.some";
    public static final String TOPIC_BINDING_KEY_ONE = "topic.one";

    public static final String TOPIC_ROUTING_KEY_QUEUE = "topic.queue";
    public static final String TOPIC_ROUTING_KEY_SOME = "topic.#";
    public static final String TOPIC_ROUTING_KEY_ONE = "topic.*";

    //FANOUT_EXCHANGE
    public static final String FANOUT_BINDING_KEY_QUEUE = "fanout.queue";
    public static final String FANOUT_BINDING_KEY_SOME = "fanout.some";

    //DIRECT_EXCHANGE
    public static final String DIRECT_BINDING_KEY_QUEUE = "direct.queue";
    public static final String DIRECT_BINDING_KEY_SOME = "direct.some";

    public static final String DIRECT_ROUTING_KEY_QUEUE = "direct.queue";
    public static final String DIRECT_ROUTING_KEY_SOME = "direct.#";
}
