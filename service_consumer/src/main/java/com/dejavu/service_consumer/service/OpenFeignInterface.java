package com.dejavu.service_consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 15:23
 **/
@FeignClient("test_provider")
public interface OpenFeignInterface {
    @GetMapping("/test")
    String getAppName();
}
