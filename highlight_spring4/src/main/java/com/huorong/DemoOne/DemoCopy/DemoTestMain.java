package com.huorong.DemoOne.DemoCopy;

import com.huorong.DemoOne.FunctionService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huorong on 17/12/1.
 */
public class DemoTestMain {
    /**
     * 手动set方式
     */
    @Test
    public void testJavaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceFactory.class);
        // UserCopyFunctionService 初始化容器时候由@Bean注入
        UserCopyFunctionService userCopyFunctionService = context.getBean(UserCopyFunctionService.class);
        // @Service注入
        FunctionService functionService = context.getBean(FunctionService.class);
        // 组合依赖set functionService到 UserCopyFunctionService
        userCopyFunctionService.setFunctionService(functionService);
        System.out.println(userCopyFunctionService.sayHello(",word"));
        context.close();
    }
}
