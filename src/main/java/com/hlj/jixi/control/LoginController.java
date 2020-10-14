package com.hlj.jixi.control;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author zc217
 * @Date 2020/9/4
 */
@Controller
public class LoginController {

    //    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if (!StringUtils.isEmpty(userName) && password.equals("1")) {
            session.setAttribute("loginUser", userName);
            //登录页面 重定向方式到main.html页面
            return "redirect:/main.html";
//            return "dashboard";
        } else {
            map.put("msg", "登录名密码错误");
            return "login";
        }
    }
}
