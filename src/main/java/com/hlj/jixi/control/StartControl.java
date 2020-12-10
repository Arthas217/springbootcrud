package com.hlj.jixi.control;

import com.beijing.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 引用自定义starter
 * @Author zc217
 * @Date 2020/12/10
 */
@Controller
public class StartControl {

    @Autowired
    HelloService helloService;
    /**
     * 测试自定义自动配置
     * http://localhost:8080/customer
     */
    @GetMapping("/customer")
    @ResponseBody //渲染时返回json，不然找不到页面
    public String hello(){
        return helloService.helloSay("human");
    }

}
