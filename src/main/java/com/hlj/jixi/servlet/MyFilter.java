package com.hlj.jixi.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author zc217
 * @Date 2020/10/12
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter process....");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
