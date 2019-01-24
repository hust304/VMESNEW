package com.xy.vmes.deecoop.system.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.RedisUtils;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.cache.RedisClient;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.text.MessageFormat;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


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
    private UserService userService;
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    RedisClient redisClient;

    /**
     * 系统用户登录(web,手机)端-通用登录接口
     * 登录类型(loginType)
     *   手机端:app
     *   web端:web
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
     * 返回值 <ResultModel>
     *     ResultModel.code
     *     ResultModel.msg
     *     ResultModel.result
     *     ResultModel.sessionID(Redis缓存Key:uuid:用户ID:企业ID:deecoop:userLoginMap)

     * (手机端)Redis缓存Key:   (uuid:用户ID:企业ID:deecoop:userLoginMap:app)
     * (web端)Redis缓存Key:   (uuid:用户ID:企业ID:deecoop:userLoginMap:web)
     * Redis缓存Value: JsonString--Map<String, String>
     *     userID:    用户ID
     *     userCode:  系统账号
     *     userName:  姓名
     *     companyId: 企业ID
     *     deptId:    部门ID
     *     postId:    岗位ID
     *     roleIds:   角色ID
     *     userMenu:  用户菜单树
     *     userMain:  用户主页
     *
     * 创建人：陈刚
     * 创建时间：2018-07-20
     */
    @PostMapping("/system/userLogin/loginIn")
    public ResultModel loginIn() throws Exception {
        logger.info("################userLogin/loginIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = userLoginService.loginIn(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################userLogin/loginIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 1. 生成4位验证码
     * 2. 验证码-Redis缓存Key:(securityCode)
     * 3. 验证码-返回页面
     * 返回值 <ResultModel>
     *     ResultModel.code
     *     ResultModel.msg
     *     ResultModel.result<Map<String, Object>>
     *         securityCode:验证码
     *         securityCodeKey:(uuid:securityCode)
     *
     * 创建人：陈刚
     * 创建时间：2018-07-24
     */
    @PostMapping("/system/userLogin/createSecurityCode")
    public ResultModel createSecurityCode() {
        logger.info("################userLogin/createSecurityCode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        String SecurityCode = this.drawImg(new ByteArrayOutputStream());

        //Redis-验证码-缓存1分钟(60 * 1000)
        String RedisCodeKey = Conv.createUuid() + ":" + Common.REDIS_SECURITY_CODE;
        redisClient.setWithExpireTime(RedisCodeKey, SecurityCode, Common.REDIS_SECURITYCODE_LONG);

        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("securityCode", SecurityCode);
        dataMap.put("securityCodeKey", RedisCodeKey);

        ResultModel model = new ResultModel();
        model.putResult(dataMap);
        Long endTime = System.currentTimeMillis();
        logger.info("################userLogin/createSecurityCode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改系统用户登录密码
     *
     * 创建人：陈刚
     * 创建时间：2018-07-25
     *
     * @return
     */
    @PostMapping("/system/userLogin/changePassWord")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel changePassWord() throws Exception {
        logger.info("################userLogin/changePassWord 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String userID = pageData.getString("userID");
        String passwordOld = pageData.getString("passwordOld");
        String passwordNew = pageData.getString("passwordNew");

        //非空判断
        StringBuffer msgBuf = new StringBuffer();
        if (userID == null || userID.trim().length() == 0 ) {
            msgBuf.append("参数错误：系统用户ID为空或空字符串！");
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }
        if (passwordOld == null || passwordOld.trim().length() == 0 ) {
            msgBuf.append("参数错误：原密码输入为空或空字符串，原密码为必填项不可为空！");
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }
        if (passwordNew == null || passwordNew.trim().length() == 0 ) {
            msgBuf.append("参数错误：新密码输入为空或空字符串，新密码为必填项不可为空！");
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //1. 查询(用户id,原密码)-系统中是否存在
        PageData findMap = new PageData();
        findMap.put("userID", userID);
        findMap.put("userPassword", MD5Utils.MD5(passwordOld));
        //isdisable:是否禁用(0:已禁用 1:启用)
        findMap.put("userIsdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Map<String, Object>> objectList = userEmployService.findViewUserEmployList(findMap);
        if (objectList == null || objectList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("原密码输入错误，请核对后再次输入！");
            return model;
        }

        //2. 修改用户新密码
        Map<String, Object> userEmployMap = objectList.get(0);
        User userDB = userEmployService.mapObject2User(userEmployMap, null);
        userDB.setPassword(MD5Utils.MD5(passwordNew));
        userService.update(userDB);

        model.putMsg("密码修改成功！");
        Long endTime = System.currentTimeMillis();
        logger.info("################userLogin/changePassWord 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 系统用户找回密码
     *
     * 创建人：陈刚
     * 创建时间：2018-07-25
     * @return
     */
    @PostMapping("/system/userLogin/findPassWord")
    public ResultModel findPassWord() throws Exception {
        logger.info("################userLogin/findPassWord 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        //非空判断
        PageData pageData = HttpUtils.parsePageData();
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String type = (String)pageData.get("type");
        String mobile = (String)pageData.get("mobile");
        String email = (String)pageData.get("email");
        String userCode = (String)pageData.get("userCode");

        if (type == null || type.trim().length() == 0) {
            //throw new RestException("", "参数错误：密码找回方式为空或空字符串，密码找回方式为必填项不可为空！");
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：密码找回方式为空或空字符串！");
            return model;
        }
        //type (mobile, email)取值范围
        StringBuffer msgBuf = new StringBuffer();
        if ("mobile".equals(type.toLowerCase())) {
            if (mobile == null || mobile.trim().length() == 0) {
                msgBuf.append("参数错误：手机号为空或空字符串，手机号为必填项不可为空！");
            }
        } else if ("email".equals(type.toLowerCase())) {
            if (userCode == null || userCode.trim().length() == 0) {
                msgBuf.append("参数错误：账号手机为空或空字符串，账号手机为必填项不可为空！");
                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            }
            if (email == null || email.trim().length() == 0) {
                msgBuf.append("参数错误：邮箱地址为空或空字符串，邮箱地址为必填项不可为空！");
                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            }
        }
        if (msgBuf.toString().trim().length() > 0) {
            //throw new RestException("", msgBuf.toString());
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //获取查询条件
        msgBuf = new StringBuffer();
        PageData findMap = new PageData();
        //isdisable:是否禁用(1:已禁用 0:启用)
        findMap.put("userIsdisable", "0");
        if ("mobile".equals(type.toLowerCase())) {
            findMap.put("userMobile", mobile);
            msgBuf.append("手机号:" + mobile);
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        } else if ("email".equals(type.toLowerCase())) {
            String queryStr = " (a.user_code = ''{0}'' or a.mobile = ''{0}'') ";
            queryStr = MessageFormat.format(queryStr, userCode);
            findMap.put("queryStr", queryStr);
            findMap.put("userEmail", email);

            msgBuf.append("账号手机:" + userCode);
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            msgBuf.append("邮箱地址:" + email);
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Map<String, Object>> objectList = userEmployService.findViewUserEmployList(findMap);
        if (objectList == null || objectList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString() + "系统中不存在，请与管理员联系！");
            return model;
        }
        Map<String, Object> userEmployMap = objectList.get(0);
        User userDB = userEmployService.mapObject2User(userEmployMap, new User());

        //获取默认新密码:
        String default_password = MD5Utils.MD5(Common.DEFAULT_PASSWORD);
        userDB.setPassword(default_password);

        if ("mobile".equals(type.toLowerCase())) {
            //TODO 重置密码(新密码)-手机短信(mobile)

        } else if ("email".equals(type.toLowerCase())) {
            //TODO 重置密码(新密码)-邮件发给(email)
        }

        userService.update(userDB);

        model.putCode(Integer.valueOf(0));
        model.putMsg("密码重置成功！");
        Long endTime = System.currentTimeMillis();
        logger.info("################userLogin/findPassWord 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 系统用户退出系统
     *
     * 创建人：陈刚
     * 创建时间：2018-07-25
     * @return
     */
    @PostMapping("/system/userLogin/loginOut")
    public ResultModel loginOut() {
        logger.info("################userLogin/loginOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String sessionID = (String)pageData.get("sessionID");
        if (sessionID == null || sessionID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("sessionID为空或空字符串！");
            return model;
        }

        String[] str_arry = sessionID.split(":");
        String uuid = str_arry[0];
        RedisUtils.removeByUuid(redisClient, uuid);
        Long endTime = System.currentTimeMillis();
        logger.info("################userLogin/loginOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////
    //测试代码

    /**
     * 获取全部含有(userID)的Redis缓存key
     * Redis缓存Key:(uuid:用户ID:企业ID:deecoop:userLoginMap)
     * @return
     */
//    @GetMapping("/system/userLogin/test_findAllRedisKeyByUserID")
//    public ResultModel test_findAllRedisKeyByUserID() {
//        logger.info("################userLogin/test_findAllRedisKeyByUserID 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        //1. 非空判断
//        if (pageData == null || pageData.size() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("参数错误：用户登录参数(pageData)为空！");
//            return model;
//        }
//
//        String userID = (String)pageData.get("userID");
//        if (userID == null || userID.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("userID为空或空字符串！");
//            return model;
//        }
//
//        Jedis jedis = redisClient.getJedisPool().getResource();
//        if (jedis == null) {
//            throw new RestException("", "Redis 缓存错误(jedis is null)，请与管理员联系！");
//        }
//
//        StringBuffer msgBuf = new StringBuffer();
//        try {
//            String strTemp = ":" + userID;
//            Set<String> keySet = jedis.keys("*" + strTemp + "*");
//            for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
//                String key = (String) iterator.next();
//                msgBuf.append(key);
//                msgBuf.append("--");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//
//        model.putMsg(msgBuf.toString());
//        Long endTime = System.currentTimeMillis();
//        logger.info("################userLogin/test_findAllRedisKeyByUserID 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
     * 获取全部含有(uuid)的Redis缓存key
     * Redis缓存Key:(uuid:用户ID:企业ID:deecoop:userLoginMap)
     * @return
     */
//    @GetMapping("/system/userLogin/test_findAllRedisKeyByUuid")
//    public ResultModel test_findAllRedisKeyByUuid() {
//        logger.info("################userLogin/test_findAllRedisKeyByUuid 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        //1. 非空判断
//        if (pageData == null || pageData.size() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("参数错误：用户登录参数(pageData)为空！");
//            return model;
//        }
//
//        String uuid = (String)pageData.get("uuid");
//        if (uuid == null || uuid.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("uuid为空或空字符串！");
//            return model;
//        }
//
//        Jedis jedis = redisClient.getJedisPool().getResource();
//        if (jedis == null) {
//            throw new RestException("", "Redis 缓存错误(jedis is null)，请与管理员联系！");
//        }
//
//        StringBuffer msgBuf = new StringBuffer();
//        try {
//            Set<String> keySet = jedis.keys(uuid + "*");
//            for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
//                String key = (String) iterator.next();
//                msgBuf.append(key);
//                msgBuf.append("--");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//
//        model.putMsg(msgBuf.toString());
//        Long endTime = System.currentTimeMillis();
//        logger.info("################userLogin/test_findAllRedisKeyByUuid 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
     * 获取全部含有(uuid)的Redis缓存key
     * Redis缓存Key:(uuid:用户ID:企业ID:deecoop:userLoginMap)
     * @return
     */
    @GetMapping("/system/userLogin/test_findAllRedisKeyByCodeKey")
    public ResultModel test_findAllRedisKeyByCodeKey() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String codeKey = (String)pageData.get("codeKey");
        if (codeKey == null || codeKey.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("codeKey为空或空字符串！");
            return model;
        }

        String codeValue = (String)pageData.get("codeValue");
        if (codeValue == null || codeValue.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("codeValue为空或空字符串！");
            return model;
        }

        Jedis jedis = redisClient.getJedisPool().getResource();
        if (jedis == null) {
            throw new RestException("", "Redis 缓存错误(jedis is null)，请与管理员联系！");
        }

        StringBuffer msgBuf = new StringBuffer();
        try {
            String strTemp = "";
            if ("uuid".equals(codeKey)) {
                strTemp = codeValue;
            } else if ("userID,companyID,deecoop,userLoginMap".indexOf(codeKey) != -1 ) {
                strTemp = ":" + codeValue;
            } else {
                strTemp = codeValue;
            }

            Set<String> keySet = jedis.keys("*" + strTemp + "*");
            for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                msgBuf.append(key);
                msgBuf.append("--");
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        model.putMsg(msgBuf.toString());
        return model;
    }

    @GetMapping("/system/userLogin/test_removeRedisKeyByCodeKey")
    public ResultModel test_removeRedisKeyByCodeKey() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String codeKey = (String)pageData.get("codeKey");
        if (codeKey == null || codeKey.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("codeKey为空或空字符串！");
            return model;
        }

        String codeValue = (String)pageData.get("codeValue");
        if (codeValue == null || codeValue.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("codeValue为空或空字符串！");
            return model;
        }

        String loginType = (String)pageData.get("loginType");
        if (loginType == null || loginType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("loginType为空或空字符串！");
            return model;
        }

        if ("uuid".equals(codeKey)) {
            RedisUtils.removeByUuid(redisClient, codeValue);
        } else if ("userID".equals(codeKey)) {
            RedisUtils.removeByUserID(redisClient, codeValue, loginType);
        } else {
            RedisUtils.removeByCode(redisClient, codeValue);
        }

        return model;
    }



    /**
     * 获取全部含有(uuid)的Redis缓存key
     * Redis缓存Key:(uuid:用户ID:企业ID:deecoop:userLoginMap)
     * @return
     */
//    @GetMapping("/system/userLogin/test_removeRedisKeyByUserID")
//    public ResultModel test_removeRedisKeyByUserID() {
//        logger.info("################userLogin/test_removeRedisKeyByUserID 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        //1. 非空判断
//        if (pageData == null || pageData.size() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("参数错误：用户登录参数(pageData)为空！");
//            return model;
//        }
//
//        String userID = (String)pageData.get("userID");
//        if (userID == null || userID.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("userID为空或空字符串！");
//            return model;
//        }
//
//        RedisUtils.removeByUserID(redisClient, userID);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################userLogin/test_removeRedisKeyByUserID 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
     * 获取全部含有(uuid)的Redis缓存key
     * Redis缓存Key:(uuid:用户ID:企业ID:deecoop:userLoginMap)
     * @return
     */
//    @GetMapping("/system/userLogin/test_removeRedisKeyByUuid")
//    public ResultModel test_removeRedisKeyByUuid() {
//        logger.info("################userLogin/test_removeRedisKeyByUuid 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        //1. 非空判断
//        if (pageData == null || pageData.size() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("参数错误：用户登录参数(pageData)为空！");
//            return model;
//        }
//
//        String uuid = (String)pageData.get("uuid");
//        if (uuid == null || uuid.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("uuid为空或空字符串！");
//            return model;
//        }
//
//        RedisUtils.removeByUuid(redisClient, uuid);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################userLogin/test_removeRedisKeyByUuid 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    @GetMapping("/system/userLogin/test_findRedisJsonStringBySessionID")
    public ResultModel test_findRedisJsonStringBySessionID() {
        logger.info("################userLogin/test_findRedisJsonStringBySessionID 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String sessionID = (String)pageData.get("sessionID");
        if (sessionID == null || sessionID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("uuid为空或空字符串！");
            return model;
        }

        String jsonString = RedisUtils.getRedisJsonStringBySessionID(redisClient, sessionID);
        model.putMsg(jsonString);
        Long endTime = System.currentTimeMillis();
        logger.info("################userLogin/test_findRedisJsonStringBySessionID 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////
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
