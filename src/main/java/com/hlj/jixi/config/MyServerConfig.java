package com.hlj.jixi.config;

import com.hlj.jixi.servlet.MyFilter;
import com.hlj.jixi.servlet.MyListener;
import com.hlj.jixi.servlet.MyServlet;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 服务相关的配置
 *
 * @Author zc217
 * @Date 2020/10/12
 */
@Configuration
public class MyServerConfig {


    //配置嵌入式servlet容器（父接口WebServerFactory)
//    @Bean
//    public TomcatServletWebServerFactory webServerFactoryCustomizer() {
//        return new TomcatServletWebServerFactory(8081);
//        return new JettyServletWebServerFactory(8081);
//    }

    // servlet容器注册三大组件(DispatcherServletAutoConfiguration帮我们完成)
    @Bean
    public ServletRegistrationBean myServlet() {
        // http://localhost:8080/myServlet
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet", "/hello"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        return new ServletListenerRegistrationBean(new MyListener());
    }


    // 嵌入式servlet容器的自动配置 EmbeddedWebServerFactoryCustomizerAutoConfiguration
}
