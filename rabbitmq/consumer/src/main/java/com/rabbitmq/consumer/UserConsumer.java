package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "user.register.queue")
public class UserConsumer {

    static Logger logger = LoggerFactory.getLogger(UserConsumer.class);

    //Receiver
    @RabbitHandler
    public void execute(Long userId)
    {
        logger.info("用户：" + userId+"，完成了注册");
    }
}
