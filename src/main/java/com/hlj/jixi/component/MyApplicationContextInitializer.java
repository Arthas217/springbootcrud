package com.hlj.jixi.component;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 添加组件，类似还有三个监听器
 * ApplicationContextInitializer
 * SpringApplicationRunListeners
 * ApplicationRunner
 * CommandLineRunner
 * 前两种通过spring.factories方式，后两种ioc容器中获取
 *
 * @Author zc217
 * @Date 2020/10/14
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer-------------Initializer");
        System.out.println("ConfigurableApplicationContext ioc容器-------------------" + applicationContext);
    }
}
