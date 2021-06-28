package com.dejavu.tools.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dejavu
 * @description
 * @create 2021-06-28 10:44
 **/
@Data
@AllArgsConstructor
public class Result {
    private int code;
    private String message;
    private boolean success;
}
