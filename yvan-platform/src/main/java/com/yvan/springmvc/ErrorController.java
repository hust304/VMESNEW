package com.yvan.springmvc;

import com.yvan.YvanUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 异常控制器，springmvc发生异常页面后会跳转到本控制器
 * Created by luoyifan on 2017/3/1.
 */
@Controller
@ControllerAdvice
public class ErrorController {

    private Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    @Value("${yvan.debug}")
    private boolean debug;

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.htm");
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.htm");

                container.addErrorPages(error401Page, error404Page);

                if (!debug) {
                    ErrorPage error500Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/500.htm");
                    container.addErrorPages(error500Page);
                }
            }
        };
    }

    @RequestMapping("/error/401.htm")
    public ModelAndView error401() {
        return new ModelAndView("/error/401.ftl");
    }

    @RequestMapping("/error/404.htm")
    public ModelAndView error404() {
        return new ModelAndView("/error/404.ftl");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception ex) {
        LOGGER.error(ex.toString(), ex);

        if (!debug) {
            return new ModelAndView("/error/500.ftl");
        }

        Enumeration<String> enuma = request.getHeaderNames();
        Map<String, Object> vl = new LinkedHashMap<>();
        while (enuma.hasMoreElements()) {
            String key = enuma.nextElement();
            vl.put(key, request.getHeader(key));
        }

        String msg = ex.toString();

        String trace = "";
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            trace = sw.toString();
        } finally {
            IOUtils.closeQuietly(pw);
            IOUtils.closeQuietly(sw);
        }

        Map<String, Object> r = new LinkedHashMap<>();
        r.put("errorTrace", trace);
        r.put("errorMsg", msg);
        r.put("Headers", YvanUtil.toJsonPretty(vl));
        r.put("ServerName", request.getServerName());
        r.put("Host", request.getHeader("Host"));
        r.put("RemoteIP", currentRemoteIp());
        r.put("url", request.getScheme() + "://" + request.getHeader("Host") + request.getRequestURI());

        return new ModelAndView("/error/exception.ftl", r);

    }

    public HttpServletRequest currentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public String currentRemoteIp() {
        HttpServletRequest request = currentRequest();
        if (request == null) {
            return "";
        }
        if (request.getHeader("x-forwarded-for") != null) {
            return request.getHeader("x-forwarded-for");
        }
        return request.getRemoteAddr();
    }
}


