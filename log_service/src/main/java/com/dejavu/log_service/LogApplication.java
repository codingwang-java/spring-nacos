package com.dejavu.log_service;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 11:02
 **/
@SpringBootApplication
@EnableNacosDiscovery
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class,args);
    }
}
