
package com.example.demo.login;

import org.aspectj.lang.JoinPoint;

public interface ILogService {
    // 无参的日志方法

    void log();

    // 有参的日志方法

    void logArg(JoinPoint point);

    // 有参有返回值的方法

    void logArgAndReturn(JoinPoint point, Object returnObj);
}
