package com.xy.vmes.common.util.rabbitmq.receiver;

import com.yvan.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者 消息接收
 * @author 陈刚
 * @date 2019-06-13
 */
@Component
public class FirstReceiver {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_A)
    public void receive(String content) throws Exception{
        System.out.println("接收队列消息： " + content);
    }

}
