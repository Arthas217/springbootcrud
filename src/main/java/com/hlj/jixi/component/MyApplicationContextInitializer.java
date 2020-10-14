package com.hlj.jixi.component;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 组件 ApplicationContextInitializer接口
 * 还有其他三个监听器 SpringApplicationRunListeners，ApplicationRunner,CommandLineRunner 都可创建成组件
 * @Author zc217
 * @Date 2020/10/14
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("---------------ApplicationContextInitializer-------------Initializer");
        System.out.println("ConfigurableApplicationContext ioc容器---------------"+ applicationContext);
    }
}
