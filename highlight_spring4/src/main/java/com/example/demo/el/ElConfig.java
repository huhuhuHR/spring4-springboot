package com.example.demo.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan("com.example.demo.el")
// 注入配置配件需使用@PropertySource指文件地址，若使用@Value注入，则要配置一个PropertySourcesPlaceholderConfigurer的bean。
@PropertySource(value = "classpath:test.properties")
public class ElConfig {
    @Value("I Love You!") // 注入普通字符串
    private String normal;
    @Value("#{systemProperties['os.name']}") // 注入操作系统属性
    private String osName;
    @Value("#{T(java.lang.Math).random()*100.0}") // 注入表达式结果
    private double randomNumber;
    @Value("#{demoService.another}") // 注入其它bean属性
    private String fromAnother;
    @Value("classpath:test.txt") // 注入文件资源
    private Resource testFile;
    @Value("http://www.baidu.com") // 注入网址资源
    private Resource testUrl;
    @Value("${book.name}") // 注入配置文件
    private String bookName;
    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(randomNumber);
        System.out.println(fromAnother);
        try {
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(new String(bookName.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(environment.getProperty("book.author"));
    }
}
