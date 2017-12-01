package com.huorong.DemoTwo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huorong on 17/12/1.
 */
public class DemoTwoMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }
}
