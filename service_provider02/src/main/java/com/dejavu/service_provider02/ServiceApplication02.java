package com.dejavu.service_provider02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 14:50
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication02.class,args);
    }
}
