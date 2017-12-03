package com.huorong.Single;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingleConfig.class);
        DemoSingletonService p1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService p2 = context.getBean(DemoSingletonService.class);
        System.out.println("p1与P2是否相等：" + p1.equals(p2));
    }
}
