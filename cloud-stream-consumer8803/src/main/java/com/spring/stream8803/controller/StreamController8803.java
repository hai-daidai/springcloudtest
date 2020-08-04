package com.spring.stream8803.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class StreamController8803 {

    @StreamListener(Sink.INPUT)
    public  void  stream8803(Message<String>message){
        System.out.println("消费者2"+message.getPayload());
    }
}
