package com.yvan.cache;

import com.yvan.YvanUtil;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by 46368 on 2018/7/18.
 */
public class RedisClient {
    private JedisPool jedisPool;

    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    /**
     * 设置过期时间
     * @param key
     * @param value
     * @param exptime
     * @throws Exception
     */
    public void setWithExpireTime(String key, String value, int exptime) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value, "NX", "EX", exptime);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    public String get(String key) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }

    /**
     * 根据userID-获取Redis缓存中的会话ID(Uuid)
     *  Redis缓存Key(前缀):uuid_用户ID_deecoop
     *  Redis缓存Key:uuid_用户ID_deecoop_业务Key
     *
     * @param jedis
     * @param userID  系统用户ID
     * @return
     */
    public String findRedisUuidByUserID(Jedis jedis, String userID) {
        if (jedis == null) {return null;}
        if (userID == null || userID.trim().length() == 0) {return null;}

        String strTemp = ":" + userID + ":deecoop";
        Set<String> keySet = jedis.keys("*" + strTemp + "*");
        if (keySet == null || keySet.size() == 0) {return null;}

        for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            String[] strArry = key.split(":");
            if (strArry.length > 0) {return strArry[0];}
        }

        return null;
    }

    public void removeByUserID(Jedis jedis, String userID) {
        if (jedis == null) {return;}
        if (userID == null || userID.trim().length() == 0) {return;}

        String strTemp = ":" + userID + ":deecoop";
        Set<String> keySet = jedis.keys("*" + strTemp + "*");
        for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            if(jedis.exists(key)){
                jedis.del(key);
            }
        }
    }

    public void removeByUuid(Jedis jedis, String uuid) {
        if (jedis == null) {return;}
        if (uuid == null || uuid.trim().length() == 0) {return;}

        Set<String> keySet = jedis.keys(uuid + "*");
        for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            if(jedis.exists(key)){
                jedis.del(key);
            }
        }
    }




    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
