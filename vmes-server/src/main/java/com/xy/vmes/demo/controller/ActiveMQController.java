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

    //这里就是队列消息生产，方便使用postman测试
    @GetMapping("/test/send/{msg}")
    public void send(@PathVariable("msg") String msg) throws JMSException {
        System.out.println("Receiver发送的报文为:"+msg);
        producer.sendMsg(msg,(long)60000);
    }

}
