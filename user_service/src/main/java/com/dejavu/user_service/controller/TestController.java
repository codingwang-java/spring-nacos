package com.dejavu.user_service.controller;

import com.dejavu.user_service.service.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 14:52
 **/
@RestController
public class TestController {
    @Resource
    TestInterface testInterface;
    @RequestMapping("/getName")
    public String getName(){
        return testInterface.getAppName();
    }
}
