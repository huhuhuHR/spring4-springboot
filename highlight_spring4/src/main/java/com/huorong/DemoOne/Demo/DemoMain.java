package com.huorong.DemoOne.Demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMain {
    /**
     * 全注解注入方式
     */
    // 启动容器类，加载容器类
    @Test
    public void testDemoMain() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UserFunctionService userFunctionService = context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello(",aasdg"));
        context.close();
    }
}
