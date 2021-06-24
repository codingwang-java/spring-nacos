package com.dejavu.user_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 15:06
 **/
@FeignClient("provider")
@Component
public interface TestInterface {
    @GetMapping("/getName")
    String getAppName();
}
