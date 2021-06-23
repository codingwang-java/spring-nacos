package com.dejavu.service_provider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 14:52
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication01.class,args);
    }
}
