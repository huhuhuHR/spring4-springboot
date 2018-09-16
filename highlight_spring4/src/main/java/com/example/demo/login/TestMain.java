package com.example.demo.login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Log.xml");

        ILoginService loginService = (ILoginService)ctx.getBean("loginService");

//        loginService.login("zhangsan", "12344");
        loginService.login();
    }
}
