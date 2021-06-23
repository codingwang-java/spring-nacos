package com.dejavu.user_service;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 11:01
 **/
@SpringBootApplication
@EnableNacosDiscovery
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
