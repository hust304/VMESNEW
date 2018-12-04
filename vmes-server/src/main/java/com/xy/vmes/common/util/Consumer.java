package com.xy.vmes.common.util;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by 46368 on 2018/11/30.
 */

@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")
    public void receive(String msg) {
        System.out.println("Consumer收到的报文为:"+msg);

    }

}
