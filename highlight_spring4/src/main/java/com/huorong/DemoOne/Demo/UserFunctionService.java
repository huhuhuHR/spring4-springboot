package com.huorong.DemoOne.Demo;

import com.huorong.DemoOne.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huorong on 17/11/30.
 */
@Service // 注解当前UserFunctionService类是Spring管理的一个Bean
public class UserFunctionService {
    @Autowired // 将FunctionService的实体Bean注入到UserFunctionService
    FunctionService functionService;

    public String sayHello(String word) {
        return functionService.sayHello(word);
    }
}
