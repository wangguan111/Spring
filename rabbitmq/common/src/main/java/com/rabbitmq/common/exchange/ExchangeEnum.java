package com.rabbitmq.common.exchange;

//import lombok.Getter;

//@Getter
public enum ExchangeEnum
{
    TOPIC_EXCHANGE(ExchangeKey.TOPIC_EXCHANGE_KEY),
    DIRECT_EXCHANGE(ExchangeKey.DIRECT_EXCHANGE_KEY),
    FANOUT_EXCHANGE(ExchangeKey.FANOUT_EXCHANGE_KEY)
    ;

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    private String key;

    ExchangeEnum(String value)
    {
        this.key = value;
    }
}
