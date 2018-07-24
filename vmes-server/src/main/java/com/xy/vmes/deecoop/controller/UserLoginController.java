package com.xy.vmes.deecoop.controller;


import com.xy.vmes.service.UserEmployeeService;
import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.cache.RedisClient;
import com.yvan.platform.RestException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 说明：用户登录退出系统 Controller
 * 创建人：自动创建
 * 创建时间：2018-07-20
 */
@RestController
@Slf4j
public class UserLoginController {
    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @Autowired
    private UserEmployeeService userEmployService;

    @Autowired
    RedisClient redisClient;

    /**
     * 系统用户登录(web,手机)端-通用登录接口
     * Redis缓存Key:(uuid:用户ID:deecoop)
     *
     * 1. (用户账号, 密码MD5)-查询(v_vmes_user_employee)
     * 2. (用户账号, 密码MD5)-系统中存在
     * 3. 生成新的Redis会话(生成新的uuid)
     * 4. 生成新的uuid-与Redis缓存中的Key比较
     * 5. 生成新的uuid-与Redis缓存中的历史(uuid)-不同(在其他终端登录)
     * 6. 清空历史Redis缓存Key(系统用户ID)z字符串匹配
     * 7. 生成新的uuid-生成新的Redis缓存数据
     * 8. 缓存业务数据
     *
     * 用户信息(userID,userCode,companyID,)
     * 员工信息(employID,employName,postID(主岗),deptID,)
     * 当前用户角色(userRoles-角色ID','分隔的字符串)
     * 当前用户菜单树Json(userMenuTree-当前用户所有角色关联的模块-生成菜单树Json字符串)
     *
     * 创建人：陈刚
     * 创建时间：2018-07-20
     */
    @GetMapping("/userLogin/sysUserLogin")
    public String sysUserLogin() {
        StringBuffer msgBuf = new StringBuffer();

        //非空判断
        PageData pageData = HttpUtils.parsePageData();
        if (pageData == null || pageData.size() == 0) {
            msgBuf.append("参数错误：用户登录参数(pageData)为空！</br>");
        } else {
            if (pageData.get("userCode") == null || pageData.get("userCode").toString().trim().length() == 0 ) {
                msgBuf.append("参数错误：账号输入为空或空字符串，账号为必填项不可为空！</br>");
            }
            if (pageData.get("userPassword") == null || pageData.get("userPassword").toString().trim().length() == 0 ) {
                msgBuf.append("参数错误：密码输入为空或空字符串，密码为必填项不可为空！</br>");
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            throw new RestException("", msgBuf.toString());
        }

        //1. (用户账号, 密码MD5)-
        pageData.put("mapSize", Integer.valueOf(pageData.size()));
        List<Map<String, Object>> objectList = userEmployService.findViewUserEmployList(pageData);
        if (objectList == null || objectList.size() == 0) {
            throw new RestException("", "当前(用户,密码)输入错误，请重新输入！");
        }

        Map<String, Object> userEmployMap = objectList.get(0);
        Jedis jedis = redisClient.getJedisPool().getResource();
        if (jedis == null) {
            throw new RestException("", "Redis 缓存错误(jedis is null)，请与管理员联系！");
        }

        //(用户账号, 密码MD5)-系统中存在--RedisKey: uuid_系统用户ID_deecoop
        //3. 生成新的Redis会话(生成新的uuid)
        String new_uuid = Conv.createUuid();
        String redis_uuid = "";
        try{
            redis_uuid = redisClient.findRedisUuidByUserID(jedis, userEmployMap.get("userID").toString());
            if (redis_uuid != null && redis_uuid.trim().length() > 0) {redis_uuid = redis_uuid.toLowerCase();}
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        //生成新的uuid-与Redis缓存中的Key比较
        //生成新的uuid-与Redis缓存中的历史(uuid)-不同(在其他终端登录)
        //清空历史Redis缓存Key(系统用户ID)字符串匹配
        String RedisKey = "";
        if (redis_uuid != null && redis_uuid.trim().length() > 0
                && !new_uuid.trim().equals(redis_uuid.trim())) {
            redisClient.removeByUserID(jedis, userEmployMap.get("userID").toString());
        }

        //新的uuid-生成新的Redis缓存Key-(uuid:用户ID:deecoop)
        RedisKey = new_uuid + ":" + userEmployMap.get("userID").toString() + ":" + "deecoop";

        Map<String, Object> redisMap = new HashMap<String, Object>();
        //userEmployMap 缓存到Map<String, Object> 中
        redisMap = userEmployService.userEmployMap2RedisMap(userEmployMap, redisMap);

        //缓存业务数据
        //Redis缓存Key:(uuid:用户ID:deecoop:userLoginMap)
        RedisKey = RedisKey + ":" + com.yvan.common.Common.REDIS_USERLOGINMAP;
        redisClient.set(RedisKey, new Gson().toJson(redisMap));

        return null;
    }
}
