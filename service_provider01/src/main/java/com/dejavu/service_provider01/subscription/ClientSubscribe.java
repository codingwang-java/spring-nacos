package com.dejavu.service_provider01.subscription;

import com.alibaba.nacos.common.model.RestResult;
import com.alibaba.nacos.common.model.RestResultUtils;
import com.dejavu.service_provider01.anno.ResponseToUser;
import com.dejavu.tools.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author dejavu
 * @description
 * @create 2021-06-28 10:43
 **/
@Controller
@Slf4j
public class ClientSubscribe {
    @Resource
    SimpMessagingTemplate simpMessagingTemplate;
    @Resource
    MessageSender messageSender;
    @SubscribeMapping("/user/queue/all")
    public String quotaSubscribe(StompHeaderAccessor stompHeaderAccessor){
        String sessionId = stompHeaderAccessor.getSessionId();
        if(MessageDestination.getSessionList().size()==0) {
            log.info("save sessionId{}",sessionId);
            MessageDestination.getSessionList().add(sessionId);
        }

//        new Thread(()->{
            for(int i =0;i<2;i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor
                            .create(SimpMessageType.MESSAGE);
                    headerAccessor.setSessionId(sessionId);
                    headerAccessor.setLeaveMutable(true);

                    String destination="/queue/all";
                    headerAccessor.setDestination(destination);
                    //前后端同时订阅/queue/all  convertAndSend方法可以使用
                MessageDestination.getSessionList().forEach(s -> simpMessagingTemplate.convertAndSendToUser(s, "/queue/all", "111", headerAccessor.getMessageHeaders()));


            }
//        }).start();
        return "111";
    }

    @SubscribeMapping("/queue/message")
    public RestResult broadcast(StompHeaderAccessor stompHeaderAccessor){
        new Thread(()->{
            for(int i =0;i<3;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                messageSender.sendSpecifyMessage(stompHeaderAccessor.getSessionId(),"/queue/message","user");
            }
        }).start();

        return RestResultUtils.success("connection established");

    }
    @MessageMapping("/send/message")
    @ResponseToUser
    public RestResult publish(String s,StompHeaderAccessor stompHeaderAccessor){

        return RestResultUtils.success("connection established");

    }

    @SubscribeMapping("/broadcast/all")
    public RestResult broadcastAll(StompHeaderAccessor stompHeaderAccessor) throws InterruptedException {
        log.info("destination{}",stompHeaderAccessor.getDestination());
        new Thread(()->{
            for(int i =0;i<5;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                messageSender.sendMessage("/broadcast/all","ok");
            }
        }).start();
        Thread.sleep(1000);
        return RestResultUtils.success("connection established");

    }
}
