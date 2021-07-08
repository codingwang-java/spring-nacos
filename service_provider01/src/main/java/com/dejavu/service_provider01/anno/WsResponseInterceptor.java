package com.dejavu.service_provider01.anno;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author dejavu
 * @description
 * @create 2021-07-08 14:20
 **/
@Component
@Aspect
@Slf4j
public class WsResponseInterceptor {
    private StompHeaderAccessor stompHeaderAccessor;
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;
    @Pointcut("@annotation(ResponseToUser)")
    public void ResponseToUser(){
    }
    @Before("ResponseToUser()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        Object[] o = joinPoint.getArgs();
        stompHeaderAccessor = (StompHeaderAccessor) o[1];

    }

    @Around("ResponseToUser()")
    public void doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object result = proceedingJoinPoint.proceed();
        log.info(JSONObject.toJSONString(stompHeaderAccessor));
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(stompHeaderAccessor.getSessionId());
        headerAccessor.setLeaveMutable(true);
        headerAccessor.setDestination("/indicator/all");
        headerAccessor.setNativeHeader("reqId",stompHeaderAccessor.getNativeHeader("reqId").get(0));
        simpMessagingTemplate.convertAndSendToUser(stompHeaderAccessor.getSessionId(),"/indicator/all",result,headerAccessor.getMessageHeaders());
    }
}
