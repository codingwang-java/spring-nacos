package com.dejavu.service_provider01.anno;

import java.lang.annotation.*;

/**
 * @author dejavu
 * @description
 * @create 2021-07-08 14:15
 **/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseToUser {

}
