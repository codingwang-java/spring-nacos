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
    public void sendSpecifyMessage(String sessionId,String destination,Object message){
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        headerAccessor.setDestination(destination);
        headerAccessor.setNativeHeader("reqId","2");
        log.info("sendMessage {} to {}",message,sessionId);
        simpMessagingTemplate.convertAndSendToUser(sessionId,destination,message,headerAccessor.getMessageHeaders());
    }

    public void sendMessage(String destination,Object message){
        simpMessagingTemplate.convertAndSend(destination,message);
    }
}
