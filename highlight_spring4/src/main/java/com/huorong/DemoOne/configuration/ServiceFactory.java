package com.huorong.DemoOne.configuration;

import com.huorong.DemoOne.service.UserCopyFunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huorong on 17/12/1.
 */
@Configuration
@ComponentScan("com.huorong.DemoOne")
public class ServiceFactory {
    @Bean
    public UserCopyFunctionService createFunctionService() {
        return new UserCopyFunctionService();
    }
}
