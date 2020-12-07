package com.hlj.jixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//多个mapper类时，不需要在每个类上添加@mapper，可以使用@MapperScan注解
@MapperScan(value = "com.hlj.jixi.mapper")
@SpringBootApplication //Spring Boot的主配置类
public class SpringbootcrudApplication {

    // 应用访问SpringData 通过统一接口repository（crud、排序、分页）、提供数据访问的xxxTemplate、统一对象映射Mapper来简化和统一数据访问
    // SpringData JPA模块   遵循JAP规范接口  实现多种hibernate toplink OPEJPA

    // 整合步骤： 1. 实体类和数据表映射配置 2 编写Dao接口操作实体类对应的数据表（repository） 3.yml基本配置


    // springboot流程
    // 1.SpringApplication阶段
    // ApplicationContextInitializer 存初始化器initializer
    // SpringApplicationRunListeners 存监听器listener
    // 上面两个是需要getSpringFactoriesInstances()方法从配置spring.factories中获取
    // 2.run阶段
    // 获取监听器listen   getRunListeners方法，
    // 回调listeners.starting();
    // 准备环境 prepareEnvironment，
    // 创建ioc容器 createApplicationContext （web还会普通）
    // 准备上下问 prepareContext( applyInitializers，回调listeners.contextPrepared(context)，回到listeners.contextLoaded(context))
    // 加载ioc容器 refreshContext（容器刷新--扫描、创建、加载组件的地方  sring加载bean过程）
    // 回调listeners.started(context);
    // callRunners(从ioc容器中回调 ApplicationRunner,CommandLineRunner）
    // 回调listeners.running(context);
    // 返回ioc容器
    public static void main(String[] args) {
        SpringApplication.run(SpringbootcrudApplication.class, args);
    }

}
