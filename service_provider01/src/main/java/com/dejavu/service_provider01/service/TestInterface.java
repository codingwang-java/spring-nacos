package com.dejavu.service_provider01.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dejavu
 * @description
 * @create 2021-06-23 15:06
 **/
@Service
public interface TestInterface {
    String getAppName();
}
