package com.hlj.jixi.config;

import com.hlj.jixi.component.LoginHandlerInteceptor;
import com.hlj.jixi.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @Author zc217
 * @Date 2020/9/3
 * springboot默认springmvc自动配置（部分）
 * 对与其他springmvc扩展需要自己配置 --举例ViewControllers（ @Configuration、继承WebMvcConfigurerAdapter、不使用@EnableWebMvc)
 * springboot放弃springmvc自动配置，使用spring方式 添加@EnableWebMvc
 */
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 继承方式
     * WebMvcAutoConfiguration->WebMvcAutoConfigurationAdapter-> import EnableWebMvcConfiguration
     * -> DelegatingWebMvcConfiguration  -> WebMvcConfigurer
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atgg").setViewName("success");
    }


    /**
     * 组件方式
     */
    @Bean
    public WebMvcConfigurerAdapter viewControllerAdapter() {
        WebMvcConfigurerAdapter wmca = new WebMvcConfigurerAdapter() {
            // 视图映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                // 用户登录防止表单重复提交，通过服务器视图映射
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 权限验证
//                registry.addInterceptor(new LoginHandlerInteceptor())
                        // 静态资源springboot处理不需要添加
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/login.html", "/", "/user/login");
            }
        };
        return wmca;
    }

    /**
     * 组件方式-自定义国际化功能
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
