package com.yvan;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.platform.HttpParameterParser;
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
}
