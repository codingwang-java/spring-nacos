package com.dejavu.service_provider01.config;

import com.dejavu.service_provider01.interceptor.SubscribInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.Resource;

/**
 * @author dejavu
 * @description
 * @create 2021-06-25 16:11
 **/
@EnableWebSocketMessageBroker
@Configuration
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    @Resource
    private SubscribInterceptor subscribInterceptor;

    private final String endPoint="/ws";

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(subscribInterceptor);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(1);
        threadPoolTaskScheduler.setThreadNamePrefix("wss-heartbeat-thread-");
        threadPoolTaskScheduler.initialize();
        registry.enableSimpleBroker("/queue","/topic","/broadcast")
                .setHeartbeatValue(new long[]{10000,10000})
                .setTaskScheduler(threadPoolTaskScheduler);
        registry.setApplicationDestinationPrefixes("");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(endPoint).setAllowedOrigins("*");
    }
}
