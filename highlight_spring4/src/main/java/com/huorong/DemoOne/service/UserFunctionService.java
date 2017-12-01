package com.huorong.DemoOne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huorong on 17/11/30.
 */
@Service
public class UserFunctionService {
    @Autowired
    FunctionService functionService;

    public String sayHello(String word) {
        return functionService.sayHello(word);
    }
}
