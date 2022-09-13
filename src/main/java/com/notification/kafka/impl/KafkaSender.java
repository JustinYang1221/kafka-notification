package com.notification.kafka.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

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
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send("c1", message);
        SendResult<String, String> sendResult = null;
        try {
             sendResult = listenableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info("sendResult:{}", sendResult);
    }
}
