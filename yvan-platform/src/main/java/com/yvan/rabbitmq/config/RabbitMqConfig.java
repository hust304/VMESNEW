package com.yvan.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class RabbitMqConfig {
    @Autowired
    private ConnectionFactory connectionFactory;

//    private String host = "47.92.1.209";
//    private int port = 5672;
//    private String userName = "guest";
//    private String password = "guest";

    /** 消息交换机的名字*/
    public static final String EXCHANGE_A = "my-mq-exchange_A";
    //public static final String EXCHANGE_B = "my-mq-exchange_B";
    //public static final String EXCHANGE_C = "my-mq-exchange_C";

    public static final String QUEUE_A = "QUEUE_A";
    //public static final String QUEUE_B = "QUEUE_B";
    //public static final String QUEUE_C = "QUEUE_C";

    //public static final String IMMEDIATE_ROUTING_KEY = "spring-boot-routingKey_A";
    //public static final String DELAY_ROUTING_KEY = "spring-boot-routingKey_B";
    //public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

    /**
     * 获取队列A QUEUE_A
     * @return
     */
    @Bean
    public Queue firstQueue() {
        //durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
        return new Queue(QUEUE_A,true);
    }

    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(
                EXCHANGE_A,
                "x-delayed-message",
                true,
                false,
                args);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     将消息队列1和交换机进行绑定
     */
    @Bean
    public Binding binding_one() {
        return BindingBuilder.bind(firstQueue()).to(delayExchange()).with(RabbitMqConfig.QUEUE_A).noargs();
    }

    /**
     * 将消息队列2和交换机进行绑定
     */
//    @Bean
//    public Binding binding_two() {
//        return BindingBuilder.bind(queueConfig.secondQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY2);
//    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
//    @Bean public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(this.host, this.port);
//        cachingConnectionFactory.setUsername(this.userName);
//        cachingConnectionFactory.setPassword(this.password);
//        cachingConnectionFactory.setVirtualHost("/");
//        cachingConnectionFactory.setPublisherConfirms(true);
//        return cachingConnectionFactory;
//    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        return template;
    }

}
