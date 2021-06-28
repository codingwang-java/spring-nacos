package com.dejavu.service_provider01.subscription;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dejavu
 * @description
 * @create 2021-06-28 10:52
 **/
@Data
public class MessageDestination {
    @Getter
    private static final List<String> sessionList = new ArrayList<>();
}
