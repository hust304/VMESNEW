package com.xy.vmes.deecoop.Interceptor;

import com.yvan.PageData;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TestInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TestInterceptor1.preHandle : 事件完成前");
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TestInterceptor1.postHandle: 事件处理时");

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TestInterceptor1.afterCompletion: 事件完成后");
        //handler 获取调用方法全路径
        String funName = handler.toString();
        System.out.println("funName: " + funName);

        //获取调用参数
        PageData pageData = new PageData(request);
        System.out.println("**********************************");

    }
}
