package com.huorong.DemoTwo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by huorong on 17/12/1.
 */
@Configuration
@ComponentScan("com.huorong.DemoTwo")
@EnableAspectJAutoProxy
public class AopConfig {
}
