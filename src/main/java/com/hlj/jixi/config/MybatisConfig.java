package com.hlj.jixi.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * 当数据库字段命名为_时与bean字段驼峰不对应时，开启
 * 参考 MybatisAutoConfiguration自动配置里的sqlSessionFactory这个bean
 * 自定义mybatis配置规则
 * @Author zc217
 * @Date 2020/10/14
 */
@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                //开启驼峰与_的适配
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
