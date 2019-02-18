package com.rabbitmq.common.exchange;

public interface ExchangeKey
{
   //TOPIC_EXCHANGE
   static final String TOPIC_EXCHANGE_KEY = "topic.exchange";

   //DIRECT_EXCHANGE
   static final String DIRECT_EXCHANGE_KEY = "direct.exchange";

   //FANOUT_EXCHANGE
   static final String FANOUT_EXCHANGE_KEY = "fanout.exchange";
}
