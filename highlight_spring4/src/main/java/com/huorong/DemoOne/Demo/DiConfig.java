package com.huorong.DemoOne.Demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huorong on 17/12/1.
 */
@Configuration // 声明当前类是一个配置类
@ComponentScan("com.huorong.DemoOne") // 自动扫描包下所有使用@Service,@Component,@Repository,@Controller,并注册Bean
public class DiConfig {
}
