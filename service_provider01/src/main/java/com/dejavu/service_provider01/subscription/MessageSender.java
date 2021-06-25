package com.dejavu.service_provider01.subscription;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author dejavu
 * @description
 * @create 2021-06-25 17:03
 **/
@Component
@Slf4j
public class MessageSender {
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;
    public void sendMessage(Object message){
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId("");
        headerAccessor.setLeaveMutable(true);
        headerAccessor.setNativeHeader("","");
        simpMessagingTemplate.convertAndSendToUser("","/queue/all",message,headerAccessor.getMessageHeaders());
    }
}
