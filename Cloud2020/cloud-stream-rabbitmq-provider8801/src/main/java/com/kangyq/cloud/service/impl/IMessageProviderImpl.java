package com.kangyq.cloud.service.impl;

import com.kangyq.cloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class) //output 定义消息 的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    //消息发送管道
    @Resource
    private MessageChannel output;
    /**
     *
     */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*****************serial:"+serial);
        return null;
    }
}
