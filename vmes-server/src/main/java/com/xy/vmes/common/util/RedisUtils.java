package com.xy.vmes.common.util;

import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.entity.User;
import com.xy.vmes.entity.UserRole;
import com.yvan.YvanUtil;
import com.yvan.cache.RedisClient;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by 46368 on 2018/7/31.
 */
public class RedisUtils {

    public static User getUserInfoBySessionID(RedisClient redisClient, String sessionID) {

        Jedis jedis = null;
        try {
            jedis = redisClient.getJedisPool().getResource();
            String sessionJson = jedis.get(sessionID);
            if(!StringUtils.isEmpty(sessionJson)){
                Map sessionMap = YvanUtil.jsonToMap(sessionJson);
                if(sessionMap.get("user")!=null){
                    String userJson =   sessionMap.get("user").toString();
                    User user = YvanUtil.jsonToObj(userJson, User.class);
                    return user;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }


    public static Employee getEmployeeInfoBySessionID(RedisClient redisClient, String sessionID) {
        Jedis jedis = null;
        try {
            jedis = redisClient.getJedisPool().getResource();
            String sessionJson = jedis.get(sessionID);
            if(!StringUtils.isEmpty(sessionJson)){
                Map sessionMap = YvanUtil.jsonToMap(sessionJson);
                if(sessionMap.get("employ")!=null){
                    String employeeJson =   sessionMap.get("employ").toString();
                    Employee employee = YvanUtil.jsonToObj(employeeJson, Employee.class);
                    return employee;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }


    public static Department getDeptInfoBySessionID(RedisClient redisClient, String sessionID) {
        Jedis jedis = null;
        try {
            jedis = redisClient.getJedisPool().getResource();
            String sessionJson = jedis.get(sessionID);
            if(!StringUtils.isEmpty(sessionJson)){
                Map sessionMap = YvanUtil.jsonToMap(sessionJson);
                if(sessionMap.get("dept")!=null){
                    String deptJson =   sessionMap.get("dept").toString();
                    Department dept = YvanUtil.jsonToObj(deptJson, Department.class);
                    return dept;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }


    public static String getUserRoleInfoBySessionID(RedisClient redisClient, String sessionID) {
        Jedis jedis = null;
        try {
            jedis = redisClient.getJedisPool().getResource();
            String sessionJson = jedis.get(sessionID);
            if(!StringUtils.isEmpty(sessionJson)){
                Map sessionMap = YvanUtil.jsonToMap(sessionJson);
                if(sessionMap.get("userRole") != null){
                    String userRole = sessionMap.get("userRole").toString();
                    return userRole;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }

//    public UserMenu getUserMenuBySessionID(RedisClient redisClient, String sessionID) {
//
//        Jedis jedis = null;
//        try {
//            jedis = redisClient.getJedisPool().getResource();
//            String sessionJson = jedis.get(sessionID);
//            if(!StringUtils.isEmpty(sessionJson)){
//                Map sessionMap = YvanUtil.jsonToMap(sessionJson);
//                if(sessionMap.get("userMenu")!=null){
//                    String userMenuJson =   sessionMap.get("userMenu").toString();
//                    UserMenu userMenu = YvanUtil.jsonToObj(userMenuJson, UserMenu.class);
//                    return userMenu;
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            if (jedis != null)
//                jedis.close();
//        }
//        return null;
//    }
//
//    public UserButton getUserButtonBySessionID(RedisClient redisClient, String sessionID) {
//
//        Jedis jedis = null;
//        try {
//            jedis = redisClient.getJedisPool().getResource();
//            String sessionJson = jedis.get(sessionID);
//            if(!StringUtils.isEmpty(sessionJson)){
//                Map sessionMap = YvanUtil.jsonToMap(sessionJson);
//                if(sessionMap.get("userButton")!=null){
//                    String userButtonJson =   sessionMap.get("userButton").toString();
//                    UserButton userButton = YvanUtil.jsonToObj(userButtonJson, UserButton.class);
//                    return userButton;
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            if (jedis != null)
//                jedis.close();
//        }
//        return null;
//    }

    /**
     * 根据userID-获取Redis缓存中的会话ID(Uuid)
     *  Redis缓存Key(前缀):uuid_用户ID_deecoop
     *  Redis缓存Key:uuid_用户ID_deecoop_业务Key
     *
     * @param userID  系统用户ID
     * @return
     */
    public static String findRedisUuidByUserID(RedisClient redisClient, String userID) {
        if (userID == null || userID.trim().length() == 0) {return null;}

        Jedis jedis = null;
        try {
            jedis = redisClient.getJedisPool().getResource();
            String strTemp = ":" + userID + ":deecoop";
            Set<String> keySet = jedis.keys("*" + strTemp + "*");
            if (keySet == null || keySet.size() == 0) {return null;}

            for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                String[] strArry = key.split(":");
                if (strArry.length > 0) {return strArry[0];}
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) jedis.close();
        }

        return null;
    }

    /**
     * 根据userID-移除Redis缓存数据
     * @param userID
     */
    public static void removeByUserID(RedisClient redisClient, String userID) {
        if (userID == null || userID.trim().length() == 0) {return;}

        Jedis jedis = null;
        try {
            jedis = redisClient.getJedisPool().getResource();
            String strTemp = ":" + userID + ":deecoop";
            Set<String> keySet = jedis.keys("*" + strTemp + "*");
            for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                if(jedis.exists(key)){
                    jedis.del(key);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    /**
     * 根据uuid-移除Redis缓存数据
     * @param uuid
     */
    public static void removeByUuid(RedisClient redisClient, String uuid) {
        if (uuid == null || uuid.trim().length() == 0) {return;}

        Jedis jedis = null;
        try {
            jedis = redisClient.getJedisPool().getResource();
            Set<String> keySet = jedis.keys(uuid + "*");
            for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                if(jedis.exists(key)){
                    jedis.del(key);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public static String getRedisJsonStringBySessionID(RedisClient redisClient, String sessionID) {
        Jedis jedis = null;
        String sessionJson = "";
        try {
            jedis = redisClient.getJedisPool().getResource();
            sessionJson = jedis.get(sessionID);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null)
                jedis.close();
        }
        return sessionJson;
    }
}
