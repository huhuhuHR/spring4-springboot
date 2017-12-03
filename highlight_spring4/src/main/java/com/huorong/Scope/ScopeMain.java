package com.huorong.Scope;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeMain {
    @Test
    public void testScope() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        ScopeService scopeService1 = context.getBean(ScopeService.class);
        ScopeService scopeService2 = context.getBean(ScopeService.class);
        System.out.println(scopeService1 == scopeService2);
    }
}
