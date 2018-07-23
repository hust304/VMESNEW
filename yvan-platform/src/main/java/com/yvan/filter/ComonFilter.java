package com.yvan.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 46368 on 2018/7/23.
 */
@Configuration
public class ComonFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ComonFilter.init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;


        String uri = httpRequest.getRequestURI();
        //请求地址中含有字符串“login”和“error”的不参与sessionId校验
        if(uri.indexOf("login")<0&&uri.indexOf("error")<0){
            if (!checkSession(httpRequest, httpResponse)) {
                httpResponse.sendRedirect(((HttpServletRequest)request).getContextPath() + "/error/401");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    public boolean checkSession(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        //检查是否sessionId，且sessionId是否过期


        return  true;
    }

    @Override
    public void destroy() {
        System.out.println("ComonFilter.destroy()");
    }
}
