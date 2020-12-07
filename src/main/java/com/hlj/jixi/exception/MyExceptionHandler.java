package com.hlj.jixi.exception;

import com.hlj.jixi.exception.HelloException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *   定制错误响应ErrorMvcAutoConfiguration自动配置类
 *   1） ErrorPageCustomizer  如果出现错误就会生效，定制错误的响应规则就会来到/error
 *   2) BasicErrorController 处理/error请求 （分浏览器页面text/html和其他端的）
 *   3) ErrorViewResolver    处理响应页面 DefaultErrorViewResolver实现
 *   4) DefaultErrorAttributes  提供错误页面能获取的内容
 *
 * 错误处理机制方案
 * 访问请求http://localhost:8080/emps/aa
 * 定制错误响应
 * 1）定制错误页面
 * 有模板引擎下，浏览器错误页面,优先选择地址 /error/状态码.html;次之选择4xx/5xx.html匹配这类型的所有错误
 * 模板引擎找不到，找静态资源文件夹/static（了解）
 * 没有模板引擎原生springboot错误提示页面 defaultErrorView
 * 2）定制错误json数据
 *
 */

@ControllerAdvice
// 异常信息不需要暴露给用户，自定义此类的返回信息
// 测试添加、不添加注解ControllerAdvice http://localhost:8080/hello?param=abc
public class MyExceptionHandler {

    // 无论浏览器还是客户端都返回json格式
//    @ResponseBody
//    @ExceptionHandler(HelloException.class)
//    public Map<String,Object> customerException(Exception exception){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code",-1);
//        map.put("info", "failed");
//        map.put("message", exception.getMessage());
//        return map;
//    }

    // 自适应返回格式（浏览器页面、postman是json）
    @ExceptionHandler(HelloException.class)
    public String handlerException(Exception exception, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //自定义返回错误状态码500
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", -1);
        map.put("info", "failed");
        // exception参数是HelloException类中抛出的
        map.put("message", exception.getMessage());
        request.setAttribute("content", map);
        // BasicErrorController源码中具有自适应特点，那我们就转发到/error页面
        return "forward:/error";
    }
}
