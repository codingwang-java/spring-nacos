package com.dejavu.service_provider01.subscription;

import com.dejavu.tools.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author dejavu
 * @description
 * @create 2021-06-28 10:43
 **/
@Controller
@Slf4j
public class ClientSubscribe {
    @SubscribeMapping("/quote/subscriber")
    public Result quotaSubscribe(StompHeaderAccessor stompHeaderAccessor){
        String sessionId = stompHeaderAccessor.getSessionId();
        MessageDestination.getSessionList().add(sessionId);
        log.info("save sessionId{}",sessionId);
        return new Result(200,"ok",true);
    }
}
