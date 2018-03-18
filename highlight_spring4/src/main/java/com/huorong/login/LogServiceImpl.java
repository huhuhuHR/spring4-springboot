package com.huorong.login;

import org.aspectj.lang.JoinPoint;

public class LogServiceImpl implements ILogService {
    @Override
    public void log() {
        System.out.println("*************Log*******************");
    }

    @Override
    public void logArg(JoinPoint point) {
        Object[] args = point.getArgs();
        System.out.println("目标参数列表：");
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg + ",");
            }
        }
    }

    @Override
    public void logArgAndReturn(JoinPoint point, Object returnObj) {
        // 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        System.out.println("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                System.out.println(obj + ",");
            }
            System.out.println();
            System.out.println("执行结果是：" + returnObj);
        }
    }

}
