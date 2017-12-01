package com.huorong.DemoTwo;

import org.springframework.stereotype.Service;

/**
 * Created by huorong on 17/12/1.
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解拦截的add操作")
    public void add() {
        System.out.println("DemoAnnotationService>>>");
    }
}
