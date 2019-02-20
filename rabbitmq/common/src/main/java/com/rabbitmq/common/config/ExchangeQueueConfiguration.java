package com.rabbitmq.common.config;

public class ExchangeQueueConfiguration
{
    // 是否持久化
     protected  boolean durableQueue = true;
    // 仅创建者可以使用的私有队列，断开后自动删除
    protected boolean exclusiveQueue = false;
    // 当所有消费客户端连接断开后，是否自动删除队列
    protected boolean autoDeleteQueue = false;


    // 是否持久化
    protected boolean durableExchange = true;
    // 当所有消费客户端连接断开后，是否自动删除队列
    protected boolean autoDeleteExchange = false;
}
