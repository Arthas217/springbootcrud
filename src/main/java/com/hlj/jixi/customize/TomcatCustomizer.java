package com.hlj.jixi.customize;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 修改tomcat容器端口(优先加载此自定义配置类）
 * @Author zc217
 * @Date 2020/12/7
 */
//@Configuration
public class TomcatCustomizer {
    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(2000);
        return factory;
    }
}
