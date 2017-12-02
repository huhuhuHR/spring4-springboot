package com.huorong.DemoOne.DemoCopy;

import com.huorong.DemoOne.FunctionService;

/**
 * Created by huorong on 17/11/30.
 */
public class UserCopyFunctionService {
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word) {
        return functionService.sayHello(word);
    }
}
