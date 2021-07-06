package com.dejavu.service_provider01.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;

/**
 * @author dejavu
 * @description
 * @create 2021-06-25 16:45
 **/
@Component
@Slf4j
public class SubscribInterceptor implements ChannelInterceptor {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message,StompHeaderAccessor.class);
        //get accessor header
        if(StompCommand.CONNECT.equals(accessor.getCommand())){
            log.info("connection is established");
        };
        if(StompCommand.SUBSCRIBE.equals(accessor.getCommand())){
            log.info("subscribe info{}",accessor.getSessionId());
        }
        return message;
    }
}
