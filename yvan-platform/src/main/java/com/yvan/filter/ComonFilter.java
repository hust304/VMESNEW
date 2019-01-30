package com.yvan.filter;

import com.yvan.cache.RedisClient;
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
import java.util.Iterator;
import java.util.Set;

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

        //请求地址中含有字符串“login”和“error”的不参与sessionId校验
        if(uri.indexOf("login".toLowerCase()) < 0 && uri.indexOf("error".toLowerCase()) < 0 && uri.indexOf("file".toLowerCase())<0 && uri.indexOf("importExcel".toLowerCase())<0
                && uri.indexOf(".js".toLowerCase())<0 && uri.indexOf(".png".toLowerCase())<0 && uri.indexOf(".ttf".toLowerCase())<0 && uri.indexOf(".html".toLowerCase())<0
                && uri.indexOf(".css".toLowerCase())<0 && uri.indexOf("test".toLowerCase())<0 && uri.indexOf("mobile".toLowerCase())<0){
                if(uri.equals("/")){
                    httpResponse.sendRedirect("/index.html/");
                    return;
                }else {
                    if (!this.checkSession(httpRequest)) {
//                        httpResponse.sendRedirect(httpRequest.getHeader("referer") + "api/error/401");
                        httpResponse.sendRedirect( "/error/401");
                        return;
                    }

                //延长 Session 时间
                this.extendSessionTime(httpRequest, httpResponse);
            }

        }
        chain.doFilter(mParametersWrapper, httpResponse);
    }

    /**
     * 延长Redis缓存Key(sessionID) 有效时间
     * Redis缓存Key: (uuid:用户ID:deecoop:userLoginMap)
     *
     * @param httpRequest
     * @param httpResponse
     * @throws IOException
     */
    public void extendSessionTime(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        //sessionID: (uuid:用户ID:deecoop:userLoginMap)
        String sessionID = httpRequest.getHeader("sessionID");
        if (sessionID == null || sessionID.trim().length() == 0) {
            httpResponse.sendRedirect(httpRequest.getHeader("referer") + "api/error/401");
            return;
        }

        //获取(sessionID)值: Redis缓存Key: (uuid:用户ID:deecoop:userLoginMap)
        String sessionValue = "";
        if (redisClient.get(sessionID) != null && redisClient.get(sessionID).trim().length() > 0) {
            sessionValue = redisClient.get(sessionID).trim();
        }
        redisClient.setWithExpireTime(sessionID, sessionValue, 30*60*1000);
    }

    public boolean checkSession(HttpServletRequest httpRequest) {
        //System.out.println("*********************************** in checkSession()");
        //1. 客户端-获取历史sessionID
        //sessionID: (uuid:用户ID:deecoop:userLoginMap)
        String sessionID = httpRequest.getHeader("sessionID");
        if (sessionID == null || sessionID.trim().length() == 0) {
            return false;
        }
        //System.out.println("Client:sessionID: " + sessionID);

        String[] str_arry = sessionID.split(":");
        String uuid = str_arry[0];
        String userID = str_arry[1];
        //System.out.println("userID: " + userID);

        //2. 通过(userID)-Redis缓存中获取最新的会话id(uuid)
        String uuid_new = this.findRedisUuidByUserID(userID);
        if (uuid_new == null || uuid_new.trim().length() == 0) {
            return false;
        } else if (!uuid_new.toLowerCase().equals(uuid.toLowerCase())) {
            return false;
        }

        return true;
    }

    @Override
    public void destroy() {
        System.out.println("****************************************ComonFilter.destroy()");
    }






    @Autowired
    private RedisProperties prop;

    @Autowired
    RedisClient redisClient;

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

    private String findRedisUuidByUserID(String userID) {
        if (userID == null || userID.trim().length() == 0) {return null;}


        Jedis jedis = null;
        try {
            RedisClient redisClient = new RedisClient();
            redisClient.setJedisPool(this.jedisPool());
            jedis = redisClient.getJedisPool().getResource();

            String strTemp = ":" + userID;
            Set<String> keySet = jedis.keys("*" + strTemp + "*");
            if (keySet != null && keySet.size() > 0) {
                for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
                    String key = (String) iterator.next();
                    String[] strArry = key.split(":");
                    if (strArry.length > 0) {return strArry[0];}
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) jedis.close();
        }

        return null;
    }
}
