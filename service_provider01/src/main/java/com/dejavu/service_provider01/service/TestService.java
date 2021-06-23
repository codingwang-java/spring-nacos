package com.dejavu.service_provider01.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 14:53
 **/

public class TestService implements TestInterface{
    public String getAppName(){
        return "service_provider01";
    }
}
