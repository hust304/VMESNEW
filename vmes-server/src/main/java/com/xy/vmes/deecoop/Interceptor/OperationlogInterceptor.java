package com.xy.vmes.deecoop.Interceptor;

import com.xy.vmes.entity.Loginfo;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.LoginfoService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统操作日志-拦截器(add,update,delete)
 * 拦截系统中所有(add,update,delete)前缀的方法
 * 写入日志表(vmes_loginfo)
 *
 */
public class OperationlogInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginfoService loginfoService;

    /**
     * 方法调用前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 方法调用后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //获取Controller方法调用全路径
        String method_path = (String)handler;
        if (method_path == null || method_path.trim().length() == 0) {return;}

        //获取调用方法名称前缀
        String prefix = loginfoService.findMethodPrefix(method_path);
        //获取业务表名
        String tableName = loginfoService.findTable(method_path);

        //获取调用参数
        PageData pageData = new PageData(request);
        String cuserId = (String)pageData.get("cuser");

        Loginfo loginfoDB = loginfoService.createLoginfo(null);
        loginfoDB.setType("operate");
        loginfoDB.setSource("web");
        loginfoDB.setTableName(tableName);
        loginfoDB.setOperate(prefix);
        loginfoDB.setCuser(cuserId);

        loginfoService.save(loginfoDB);

    }
}
