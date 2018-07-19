package com.yvan;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.platform.HttpParameterParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luoyifan on 2018/7/14.
 */
public class HttpUtils {

    public static HttpServletRequest currentRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    public static HttpServletResponse currentResponse() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 从当前请求中获取分页方法和内容
     */
    public static Pagination parsePagination() {
        HttpServletRequest request = currentRequest();
        HttpParameterParser parser = HttpParameterParser.newInstance(request);
        int pageNo = parser.getIntValue("pageNo", 1);
        int pageSize = parser.getIntValue("pageSize", 10);
        String orderBy = parser.getString("orderBy", "");
        if (pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize <= 0 || pageSize > 500) {
            pageSize = 20;
        }

        Pagination pagination = new Page(pageNo, pageSize);
        pagination.setOpenSort(false);
        return pagination;
    }

    /**
     * 从当前请求中获取分页方法和内容
     */
    public static PageData parsePageData() {
        HttpServletRequest request = currentRequest();
        PageData pd = new PageData(request);
        return pd;
    }

    public static Object copyToEntity(PageData pd, Class objectClass) {

        return null;
    }

    public static String currentHost() {
        HttpServletRequest request = currentRequest();
        if (request == null) {
            return "";
        }

        String host = request.getHeader("X-Forwarded-Host");
        if (!StringUtils.isEmpty(host)) {
            return host;
        }
        return request.getHeader("Host");
    }

    public static String currentRemoteIp() {
        HttpServletRequest request = currentRequest();
        if (request == null) {
            return "";
        }

        if (request.getHeader("x-forwarded-for") != null) {
            return request.getHeader("x-forwarded-for");
        }
        return request.getRemoteAddr();
    }

    public static String currentUrl() {
        HttpServletRequest request = currentRequest();
        if (request == null) {
            return "";
        }

        return request.getScheme() + "://" + currentHost() + request.getRequestURI();
    }
}
