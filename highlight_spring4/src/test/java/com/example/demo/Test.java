package com.example.demo;

import com.example.demo.aop.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.update(1);
        userService.delete();
    }
}
