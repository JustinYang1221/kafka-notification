package com.notification.kafka.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: justin
 * @date: 2022/9/2
 */

@Component
public class Consumer {

    @KafkaListener(topics = "c1")
    public void processMessage(String content){
        System.out.println("Message received: " + content);
    }
}
