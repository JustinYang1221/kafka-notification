package com.notification.kafka.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

/**
 * @author: justin
 * @date: 2022/9/5
 */

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public void send(String message){
      SendResult<String,String> sendResult = (SendResult<String,String>) kafkaTemplate.send("c1", message);
      log.info("sendResult:{}", sendResult);
    }
}
