package com.spring.stream8801.service.impl;

import cn.hutool.core.lang.UUID;
import com.spring.stream8801.service.StreamService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@EnableBinding(Source.class) //开启通道
public class StreamServiceImpl implements StreamService {

   @Resource
   private MessageChannel output;

    @Override
    public String send() {
        String uuid  = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        return uuid;
    }
}
