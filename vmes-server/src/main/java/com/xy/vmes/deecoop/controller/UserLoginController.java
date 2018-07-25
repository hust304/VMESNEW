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

import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
     * 返回值: JsonString
     * {
     *     result:success 成功-fail 失败
     *     msg:成功或失败信息
     *     RedisUuid: 当前Redis会话ID
     *     RedisKey: Redis缓存Key(uuid:用户ID:deecoop)
     *     RedisUserLoginKey: Redis缓存用户登录信息Map
     * }
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

            if (pageData.get("securityCode") == null || pageData.get("securityCode").toString().trim().length() == 0 ) {
                msgBuf.append("参数错误：验证码入为空或空字符串，验证码为必填项不可为空！</br>");
            }
            if (pageData.get("securityCodeKey") == null || pageData.get("securityCodeKey").toString().trim().length() == 0 ) {
                msgBuf.append("参数错误：验证码(Redis缓存Key)为空或空字符串！</br>");
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            throw new RestException("", msgBuf.toString());
        }

        //验证码-是否过期
        Jedis jedis = redisClient.getJedisPool().getResource();
        if (jedis == null) {
            throw new RestException("", "Redis 缓存错误(jedis is null)，请与管理员联系！");
        }
        String securityCode = pageData.get("securityCode").toString().trim();
        String old_securityCode = redisClient.get(pageData.get("securityCodeKey").toString().trim());
        if (!securityCode.equalsIgnoreCase(old_securityCode)) {
            throw new RestException("", "验证码输入错误或已经过期，请重新输入验证码！");
        }

        //1. (用户账号, 密码MD5)-
        String userCode = pageData.get("userCode").toString().trim();
        String userPassword = pageData.get("userPassword").toString().trim();
        String queryStr = " (a.user_code = ''{0}'' or a.mobile = ''{0}'') and a.password = ''{1}'' ";
        queryStr = MessageFormat.format(queryStr,
                userCode,
                userPassword);

        PageData findMap = new PageData();
        findMap.put("queryStr", queryStr);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Map<String, Object>> objectList = userEmployService.findViewUserEmployList(findMap);
        if (objectList == null || objectList.size() == 0) {
            throw new RestException("", "当前(用户,密码)输入错误，请重新输入！");
        }
        Map<String, Object> userEmployMap = objectList.get(0);
        String userID = userEmployMap.get("userID").toString().toLowerCase();


        //(用户账号, 密码MD5)-系统中存在--RedisKey: uuid_系统用户ID_deecoop
        //3. 生成新的Redis会话(生成新的uuid)
        String new_uuid = Conv.createUuid();
        String redis_uuid = "";
        try{
            redis_uuid = redisClient.findRedisUuidByUserID(jedis, userID);
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
            redisClient.removeByUserID(jedis, userID);
        }

        //新的uuid-生成新的Redis缓存Key-(uuid:用户ID:deecoop)
        RedisKey = new_uuid + ":" + userID + ":" + "deecoop";

        Map<String, Object> redisMap = new HashMap<String, Object>();
        //userEmployMap 缓存到Map<String, Object> 中
        redisMap = userEmployService.userEmployMap2RedisMap(userEmployMap, redisMap);

        //缓存业务数据
        //Redis缓存Key:(uuid:用户ID:deecoop:userLoginMap)
        String Redis_userLogin_Key = RedisKey + ":" + com.yvan.common.Common.REDIS_USERLOGINMAP;
        redisClient.set(Redis_userLogin_Key, new Gson().toJson(redisMap));


        //登录结果
        //RedisUuid(uuid)
        //RedisKey(uuid:用户ID:deecoop)
        //RedisUserLoginKey(用户-员工-角色Map)

        return null;
    }

    /**
     * 1. 生成4位验证码
     * 2. 验证码-Redis缓存Key:(securityCode)
     * 3. 验证码-返回页面
     * 返回值: JsonString
     * {
     *    securityCode: 验证码
     * }
     * 创建人：陈刚
     * 创建时间：2018-07-24
     */
    @GetMapping("/userLogin/createSecurityCode")
    public String createSecurityCode() {
        HttpServletResponse httpResponse = HttpUtils.currentResponse();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String SecurityCode = drawImg(output);

        Jedis jedis = redisClient.getJedisPool().getResource();
        if (jedis == null) {
            throw new RestException("", "Redis 缓存错误(jedis is null)，请与管理员联系！");
        }

        //Redis-验证码-缓存1分钟(60 * 1000)
        String RedisCodeKey = Conv.createUuid() + ":" + com.yvan.common.Common.REDIS_SECURITY_CODE;
        redisClient.setWithExpireTime(RedisCodeKey, SecurityCode, 1 * 60 * 1000);

        Map<String, String> mapObj = new HashMap<String, String>();
        mapObj.put("code", "0");
        mapObj.put("result", "");
        mapObj.put("securityCode", SecurityCode);
        mapObj.put("securityCodeKey", RedisCodeKey);

        if (mapObj != null && mapObj.size() > 0) {
            return new Gson().toJson(mapObj);
        }

        return new String();
    }



    ////////////////////////////////////////////////////////////////////////////
    //测试代码
    @GetMapping("/userLogin/sysToApplicationPage")
    public String sysToApplicationPage() {
        PageData pageData = HttpUtils.parsePageData();

        //检查是否sessionId，且sessionId是否过期
        String RedisUuid = pageData.get("RedisUuid").toString().trim();
        String userID = pageData.get("userID").toString().trim();

        if (RedisUuid == null || RedisUuid.trim().length() == 0) {}
        if (userID == null || userID.trim().length() == 0) {}

        RedisUuid = RedisUuid.toLowerCase();
        userID = userID.toLowerCase();

        Jedis jedis = redisClient.getJedisPool().getResource();
        if (jedis == null) {
            throw new RestException("", "Redis 缓存错误(jedis is null)，请与管理员联系！");
        }

        String HistoryRedisUuid = redisClient.findRedisUuidByUserID(jedis, userID);
        if (HistoryRedisUuid == null || HistoryRedisUuid.trim().length() == 0) {
            throw new RestException("", "userID:" + userID + " 没有登录！");
        } else if (!HistoryRedisUuid.toLowerCase().equals(RedisUuid)) {
            throw new RestException("", "userID:" + userID + " 会话已经过期！");
        }

        return "true";
    }

    private String drawImg(ByteArrayOutputStream output){
        String code = "";
        for(int i=0; i<4; i++){
            code += randomChar();
        }
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman",Font.PLAIN,20);
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66,2,82);
        g.setColor(color);
        g.setBackground(new Color(226,226,240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int)x, (int)baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return code;
    }

    private char randomChar(){
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
}
