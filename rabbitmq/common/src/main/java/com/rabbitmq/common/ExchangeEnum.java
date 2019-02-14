package com.rabbitmq.common;

//import lombok.Getter;

//@Getter
public enum ExchangeEnum
{
    /**
     * 用户注册交换配置枚举
     */
    USER_REGISTER("user.register.topic.exchange")
    ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }
}
