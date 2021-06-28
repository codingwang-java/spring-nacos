package com.dejavu.service_provider01.controller;

import com.dejavu.service_provider01.subscription.MessageDestination;
import com.dejavu.service_provider01.subscription.MessageSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 14:52
 **/
@RestController
public class TestController {
    @Resource
    MessageSender messageSender;
    @RequestMapping("/getName")
    public String getAppName(){
        return "provider01";
    }

    @RequestMapping("/testwebsocket")
    public void testSendMessage() throws InterruptedException {
        for (;;) {
            MessageDestination.getSessionList().forEach(s ->
                    messageSender.sendMessage(s, "ok"));
            Thread.sleep(1000);
        }
    }
}
