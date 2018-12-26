package com.xy.vmes.demo.controller;

import com.xy.vmes.common.util.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

@RestController
public class ActiveMQController {


    @Autowired
    private Producer producer;

    @GetMapping("/test/sendTest")
    public void sendTest() throws JMSException {
        String msg_1 = "11111";
        System.out.println("Receiver发送的报文为:"+msg_1);
        producer.sendMsg(msg_1, Long.valueOf(10 * 1000));

        String msg_2 = "22222";
        System.out.println("Receiver发送的报文为:"+msg_2);
        producer.sendMsg(msg_2, Long.valueOf(10 * 1000));

        String msg_3 = "33333";
        System.out.println("Receiver发送的报文为:"+msg_3);
        producer.sendMsg(msg_3, Long.valueOf(10 * 1000));
    }

}
