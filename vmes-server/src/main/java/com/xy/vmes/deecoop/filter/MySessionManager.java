//package com.xy.vmes.deecoop.filter;
//
//import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.apache.shiro.web.util.WebUtils;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.io.Serializable;
//
///**
// * Created by 46368 on 2018/7/19.
// */
//public class MySessionManager  extends DefaultWebSessionManager {
//
//    private static final String AUTHORIZATION = "Authorization";
//
//    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
//
//    public MySessionManager() {
//        super();
//    }
//
//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
//        System.out.println(1111);
//        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
//
//        String url = WebUtils.toHttp(request).getRequestURI();
//        System.out.println(url);
//
//        //如果请求头中有 Authorization 则其值为sessionId
//        if (!StringUtils.isEmpty(id)) {
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
//            return id;
//        } else {
//            //否则按默认规则从cookie取sessionId
////            super.getSessionId(request, response);
//
//            return null;
//        }
//    }
//
//
//}
