package com.rabbitmq.provider;

import com.rabbitmq.common.exchange.RabbitmqExchange;
import com.rabbitmq.common.queue.RabbitmqQueueKey;
import com.rabbitmq.provider.service.QueueMessageService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderApplicationTests
{
    @Autowired
    private QueueMessageService queueMessageService;

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    public void testTopic()
    {
 //       queueMessageService.send(RabbitmqExchange.TOPIC_EXCHANGE, RabbitmqQueueKey.TOPIC_ROUTING_KEY_QUEUE, 10L);
 //       Assert.assertFalse( capture.toString().contains("Send Message failed:"));
    }

    @Test
    public void testDirect()
    {
//       queueMessageService.send(RabbitmqExchange.DIRECT_EXCHANGE, RabbitmqQueueKey.DIRECT_ROUTING_KEY_QUEUE, 10L);
//       Assert.assertFalse( capture.toString().contains("Send Message failed:"));
    }

    @Test
    public void testFanout()
    {
//       queueMessageService.send(RabbitmqExchange.FANOUT_EXCHANGE, RabbitmqQueueKey.FANOUT_ROUTING_KEY_QUEUE, 10L);
//       Assert.assertFalse( capture.toString().contains("Send Message failed:"));
    }
}

