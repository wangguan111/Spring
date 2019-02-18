package com.rabbitmq.common.queue;

//import lombok.Getter;

//@Getter
public enum QueueEnum
{
    TOPIC_EXCHANGE_QUEUE(QueueKey.TOPIC_EXCHANGE_BINDING_KEY, QueueKey.TOPIC_EXCHANGE_ROUTING_KEY),
    FANOUT_EXCHANGE_QUEUE(QueueKey.FANOUT_EXCHANGE_BINDING_KEY, null),
    DIRECT_EXCHANGE_QUEUE(QueueKey.DIRECT_EXCHANGE_BINDING_KEY, QueueKey.DIRECT_EXCHANGE_ROUTING_KEY),
    ;

    public String getRoutingKey()
    {
        return routingKey;
    }

    public void setRoutingKey(String routingKey)
    {
        this.routingKey = routingKey;
    }

    public String getBindingKey()
    {
        return bindingKey;
    }

    public void setBindingKey(String bindingKey)
    {
        this.bindingKey = bindingKey;
    }

    private String bindingKey;

    private String routingKey;

    QueueEnum(String bindingKey, String routingKey)
    {
        this.bindingKey = bindingKey;
        this.routingKey = routingKey;
    }
}
