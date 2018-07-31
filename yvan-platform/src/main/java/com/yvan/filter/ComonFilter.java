package com.yvan.filter;

import com.yvan.cache.RedisClient;
import com.yvan.platform.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 46368 on 2018/7/23.
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnClass(RedisClient.class)
public class ComonFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(ComonFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("过滤器初始化.......ComonFilter.init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;


        String uri = httpRequest.getRequestURI();
        uri = uri.toLowerCase();
        ModifyParametersWrapper mParametersWrapper = new ModifyParametersWrapper(httpRequest);
        mParametersWrapper.putHeader("sessionID", "1111111:1:deecoop:userLoginMap");
//        //请求地址中含有字符串“login”和“error”的不参与sessionId校验
//        if(uri.indexOf("login".toLowerCase()) < 0 && uri.indexOf("error".toLowerCase()) < 0){
//            if (!checkSession(httpRequest, httpResponse)) {
//                httpResponse.sendRedirect(((HttpServletRequest)request).getContextPath() + "/error/401");
//                return;
//            }
//        }
        chain.doFilter(mParametersWrapper, httpResponse);
    }

    public boolean checkSession(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        //检查是否sessionId，且sessionId是否过期
        String RedisUuid = (String)httpRequest.getAttribute("RedisUuid");
        String userID = (String)httpRequest.getAttribute("userID");

//        if (RedisUuid == null || RedisUuid.trim().length() == 0) {}
//        if (userID == null || userID.trim().length() == 0) {}
//
//        RedisUuid = RedisUuid.toLowerCase();
//        userID = userID.toLowerCase();
//        RedisClient redisClient = new RedisClient();
//        redisClient.setJedisPool(jedisPool());
//        Jedis jedis = redisClient.getJedisPool().getResource();
//        if (jedis == null) {
//            throw new RestException("", "Redis 缓存错误(jedis is null)，请与管理员联系！");
//        }
//
//        String HistoryRedisUuid = redisClient.findRedisUuidByUserID(jedis, userID);
//        if (HistoryRedisUuid == null || HistoryRedisUuid.trim().length() == 0) {
//            return false;
//        } else if (!HistoryRedisUuid.toLowerCase().equals(RedisUuid)) {
//            return false;
//        }

        return true;
    }

    @Override
    public void destroy() {
        System.out.println("ComonFilter.destroy()");
    }






    @Autowired
    private RedisProperties prop;

    @Bean(name = "jedisPool")
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(5000);
        return new JedisPool(config, prop.getHost(), prop.getPort(), prop.getTimeout(), prop.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean(RedisClient.class)
    public RedisClient redisClient(@Qualifier("jedisPool") JedisPool pool) {
        logger.info("初始化……Redis Client==Host={},Port={}", prop.getHost(), prop.getPort());
        RedisClient redisClient = new RedisClient();
        redisClient.setJedisPool(pool);
        return redisClient;
    }
}
