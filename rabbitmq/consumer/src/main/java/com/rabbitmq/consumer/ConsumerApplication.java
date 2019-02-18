package com.rabbitmq.consumer;

import com.rabbitmq.common.config.TopicExchangeQueueConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration({TopicExchangeQueueConfiguration.class})
public class ConsumerApplication
{
    static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerApplication.class, args);
        logger.info("ConsumerApplication Run");
    }
}

