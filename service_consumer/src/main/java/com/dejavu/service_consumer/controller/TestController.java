package com.dejavu.service_consumer.controller;

import com.dejavu.service_consumer.service.OpenFeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 14:58
 **/
@RestController
public class TestController {
    @Resource
    OpenFeignInterface openFeignInterface;
    @GetMapping("/getName")
    public String getAppName(){
        return openFeignInterface.getAppName();
    }
}
