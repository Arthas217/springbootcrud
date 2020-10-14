package com.hlj.jixi.control;

import com.alibaba.fastjson.JSON;
import com.hlj.jixi.exception.HelloException;
import com.hlj.jixi.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author zc217
 * @Date 2020/9/2
 */
@Controller
public class HelloController {

    // 访问http://localhost:8080/ 会直接找静态资源类 classpath:/public/index.html
    // 现在要求访问classpath:/templates/login.html
    // 第一种如下
//    @RequestMapping({"/","/login.html"})
//    public String login(){
//        return "login";
//    }
    // 第二种参见MyMvcConfig类
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("param") String param) {
        if (param.equals("abc")) {
            // 优先走自定义MyExceptionHandler内容，如果没有就默认
            throw new HelloException();
        }
        return "hello world";
    }

    //    @ResponseBody
    // 添加此注解返回success数据 不走视图解析器
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hi", "<h1>您好<h1>");
        map.put("arr", Arrays.asList("1", "2", "3"));
        //classpath:/templates/success.html
        return "success";
    }


    // @responseBody注解的作用https://www.jianshu.com/p/1233b22738d8
    // 1.将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据，
    // 2.使用此注解之后不会再走试图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
    @ResponseBody
    @RequestMapping("/re")
    public User response() {
        User user = new User();
        user.setEmail("123@qq.com");
        user.setId(001);
        user.setPassword("******");
        user.setUserName("tom");
        return user;
    }

    // 同response方法
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        User user = new User();
        user.setEmail("123@qq.com");
        user.setId(001);
        user.setPassword("******");
        user.setUserName("tom");
        response.getWriter().write(JSON.toJSON(user).toString());
    }


    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * jdbc + druid
     * http://localhost:8080/query
     * <p>
     * {
     * "id": 1,
     * "departmentName": "AA"
     * }
     */
    @GetMapping("/query")
    @ResponseBody
    public Map<String, Object> testMap() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }

}
