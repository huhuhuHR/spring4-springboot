package com.huorong.DemoEvent;

import com.huorong.el.ElConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoEventConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublish demoPublish = context.getBean(DemoPublish.class);
        demoPublish.publish("huo rong huhuhuhr");
        context.close();
    }
}
