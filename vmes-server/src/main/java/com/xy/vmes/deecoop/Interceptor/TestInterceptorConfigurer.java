package com.xy.vmes.deecoop.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class TestInterceptorConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    private TestInterceptor1 testInterceptor1;
    @Autowired
    private TestInterceptor2 testInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(testInterceptor1).addPathPatterns(
//                "/*/test_findAllRedisKeyByUserID",
//                "/*/test_findAllRedisKeyByUuid").excludePathPatterns(
//                "/*/test_findAllRedisKeyByUuid"
//        );

//        registry.addInterceptor(testInterceptor1).addPathPatterns("/*/test_findAllRedisKeyByUserID");
//        registry.addInterceptor(testInterceptor2).addPathPatterns("/*/test_findAllRedisKeyByUuid");

        registry.addInterceptor(testInterceptor1).addPathPatterns("/*/test*");

        super.addInterceptors(registry);
    }
}