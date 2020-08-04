package com.spring.consumer8802.contrloller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class ConsumerController {

    @StreamListener(Sink.INPUT)
    public void consumer(Message<String> message){
        System.out.println("消费者1："+ message.getPayload());
    }
}
