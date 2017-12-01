package com.huorong.DemoOne;

import com.huorong.DemoOne.configuration.ServiceFactory;
import com.huorong.DemoOne.service.FunctionService;
import com.huorong.DemoOne.service.UserCopyFunctionService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huorong.DemoOne.configuration.DiConfig;
import com.huorong.DemoOne.service.UserFunctionService;

/**
 * Created by huorong on 17/12/1.
 */
public class DemoTestMain {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UserFunctionService userFunctionService = context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello(",aasdg"));
        context.close();
    }

    @Test
    public void testJavaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceFactory.class);
        UserCopyFunctionService userCopyFunctionService = context.getBean(UserCopyFunctionService.class);
        FunctionService functionService = context.getBean(FunctionService.class);
        userCopyFunctionService.setFunctionService(functionService);
        System.out.println(userCopyFunctionService.sayHello(",word"));
        context.close();
    }
}
