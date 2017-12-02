package com.huorong.DemoOne.DemoCopy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huorong on 17/12/1.
 */
@Configuration
@ComponentScan("com.huorong.DemoOne")
public class ServiceFactory {
    @Bean //注解在方法上，声明当前方法返回一个值为Bean
    public UserCopyFunctionService createFunctionService() {
        return new UserCopyFunctionService();
    }
}