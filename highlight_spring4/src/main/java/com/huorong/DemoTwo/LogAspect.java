package com.huorong.DemoTwo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by huorong on 17/12/1.
 */
@Aspect // 注解声明一个切面
@Component // 让切面成为Spring容器管理的Bean
public class LogAspect {
    @Pointcut("@annotation(com.huorong.DemoTwo.Action)") // 声明切点
    public void annotationPointCut() {
    }

    @After("annotationPointCut()") // 使用自定义切点
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        // 通过反射可获得注解上的属性，然后做日志记录相关操作
        System.out.println("注解式拦截，" + action.name());
    }

    @Before("execution(* " + "com.huorong.DemoTwo.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截，" + method.getName());
    }
}
