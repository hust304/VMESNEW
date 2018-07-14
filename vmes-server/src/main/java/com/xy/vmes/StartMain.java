package com.xy.vmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by luoyifan on 2018/7/14.
 */
@SpringBootApplication(exclude = {
        HibernateJpaAutoConfiguration.class
})
@EnableCaching(proxyTargetClass = true)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class StartMain {

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(StartMain.class);
        application.run(args);
    }

}
