package com.huorong.DemoOne.service;

import org.springframework.stereotype.Service;

/**
 * Created by huorong on 17/11/30.
 */
@Service
public class FunctionService {
    public String sayHello(String word) {
        return "Hello" + word;
    }
}
