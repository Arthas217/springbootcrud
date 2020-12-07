package com.hlj.jixi.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author zc217
 * @Date 2020/9/3
 */
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 国际化中英文切换判断
     * 默认的就是根据请求头带来的区域信息获取Locale进行国际化
     * http://localhost:8080/login.html?l=en_US
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale;
        if (!StringUtils.isEmpty(l)) {
            String[] s = l.split("_");
            locale = new Locale(s[0], s[1]);
        } else {
            locale = Locale.getDefault();
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
