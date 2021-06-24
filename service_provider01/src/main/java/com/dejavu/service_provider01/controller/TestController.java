package com.dejavu.service_provider01.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 14:52
 **/
@RestController
public class TestController {
    @RequestMapping("/getName")
    public String getAppName(){
        return "provider01";
    }
}
