package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.RedisUtils;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.cache.RedisClient;
import com.yvan.common.util.JsonUtil;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

@Service
public class UserLoginServiceImp implements UserLoginService {

    @Autowired
    private UserEmployeeService userEmployService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    RedisClient redisClient;

    public Map<String, Object> findRedisMap(String jsonString) {
        Map<String, Object> mapObj = new HashMap<String, Object>();
        if (jsonString == null || jsonString.trim().length() == 0) {
            return mapObj;
        }

        //JsonString 转换Map<String, String> 对象
        Map mapObject = JsonUtil.jsonString2Map(jsonString);
        for (Iterator iterator = mapObject.keySet().iterator(); iterator.hasNext(); ) {
            String mapKey = (String) iterator.next();
            String mapValue = Conv.NS(mapObject.get(mapKey));
            if (mapValue == null || mapValue.trim().length() == 0) {
                continue;
            }

            try {
                if ("sessionID".equals(mapKey)) {
                    mapObj.put(mapKey, mapValue);
                } else if ("user".equals(mapKey)) {
                    User user = (User) JsonUtil.jsonString2Object(mapValue, User.class);
                    mapObj.put(mapKey, user);
                } else if ("employ".equals(mapKey)) {
                    Employee employ = (Employee) JsonUtil.jsonString2Object(mapValue, Employee.class);
                    mapObj.put(mapKey, employ);
                } else if ("dept".equals(mapKey)) {
                    Department dept = (Department) JsonUtil.jsonString2Object(mapValue, Department.class);
                    mapObj.put(mapKey, dept);
                } else if ("userRole".equals(mapKey)) {

                } else if ("userMenu".equals(mapKey)) {

                } else if ("userButton".equals(mapKey)) {

                }
            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }

        }


        return mapObj;
    }

    @Override
    public ResultModel loginIn(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        //非空判断
        StringBuffer msgBuf = new StringBuffer();

        //登录类型(loginType):(app,web)
        String loginType = new String();

        if (pageData == null || pageData.size() == 0) {
            msgBuf.append("参数错误：用户登录参数(pageData)为空！");
        } else {
            if (pageData.get("userCode") == null || pageData.get("userCode").toString().trim().length() == 0 ) {
                msgBuf.append("参数错误：账号输入为空或空字符串，账号为必填项不可为空！");
                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            }
            if (pageData.get("userPassword") == null || pageData.get("userPassword").toString().trim().length() == 0 ) {
                msgBuf.append("参数错误：密码输入为空或空字符串，密码为必填项不可为空！");
                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            }
            if (pageData.get("loginType") == null || pageData.get("loginType").toString().trim().length() == 0 ) {
                msgBuf.append("参数错误：登录类型(loginType)为空或空字符串，密码为必填项不可为空！");
                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            } else if ("app,web".indexOf(pageData.get("loginType").toString().trim()) == -1) {
                msgBuf.append("参数错误：登录类型(loginType)必须为(app,web)！");
                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            } else {
                loginType = pageData.get("loginType").toString().trim();
            }

            if ("web".equals(loginType) && (pageData.get("securityCode") == null || pageData.get("securityCode").toString().trim().length() == 0)) {
                msgBuf.append("参数错误：验证码入为空或空字符串，验证码为必填项不可为空！");
                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            }
            if ("web".equals(loginType) && (pageData.get("securityCodeKey") == null || pageData.get("securityCodeKey").toString().trim().length() == 0)) {
                msgBuf.append("参数错误：验证码(Redis缓存Key)为空或空字符串！");
                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //验证码-是否过期
        if ("web".equals(loginType)) {
            String securityCode = pageData.get("securityCode").toString().trim();
            String old_securityCode = redisClient.get(pageData.get("securityCodeKey").toString().trim());
            if (!securityCode.equalsIgnoreCase(old_securityCode)) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("验证码输入错误或已经过期，请重新输入验证码！");
                return model;
            }
        }

        //1. (用户账号, 密码MD5)-
        String userCode = pageData.get("userCode").toString().trim();
        String userPassword = pageData.get("userPassword").toString().trim();
        userPassword = MD5Utils.MD5(userPassword);
        String queryStr = " (a.user_code = ''{0}'' or a.mobile = ''{0}'') and a.password = ''{1}'' ";
        queryStr = MessageFormat.format(queryStr,
                userCode,
                userPassword);

        PageData findMap = new PageData();
        //isdisable:是否禁用(0:已禁用 1:启用)
        findMap.put("userIsdisable", "1");
        findMap.put("queryStr", queryStr);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Map<String, Object>> objectList = userEmployService.findViewUserEmployList(findMap);
        if (objectList == null || objectList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前(用户,密码)输入错误，请重新输入！");
            return model;
        }
        Map<String, Object> userEmployMap = objectList.get(0);
        String userID = userEmployMap.get("userID").toString().toLowerCase();
        String userType = userEmployMap.get("userType").toString();

        String companyID = "";
        if (userEmployMap.get("userCompanyID") != null) {
            companyID = (String)userEmployMap.get("userCompanyID");
        }

        //2. 非超级管理员(账号)-比较当前登录企业账号-是否超过(有效期)
        //(userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
        if (!Common.DICTIONARY_MAP.get("userType_admin").equals(userType)) {
            String checkValidityDate = companyService.checkCompanyValidityDate(companyID);
            if (checkValidityDate != null && checkValidityDate.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(checkValidityDate);
                return model;
            }
        }

        //(用户账号, 密码MD5)-系统中存在--RedisKey: uuid_系统用户ID_deecoop
        //3. 生成新的Redis会话(生成新的uuid)
        String new_uuid = Conv.createUuid();
        String redis_uuid = "";
        try{
            redis_uuid = RedisUtils.findRedisUuidByUserID(redisClient, userID, loginType);
            if (redis_uuid != null && redis_uuid.trim().length() > 0) {redis_uuid = redis_uuid.toLowerCase();}
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        //生成新的uuid-与Redis缓存中的Key比较
        //生成新的uuid-与Redis缓存中的历史(uuid)-不同(在其他终端登录)
        //清空历史Redis缓存Key(系统用户ID)字符串匹配
        if (redis_uuid != null && redis_uuid.trim().length() > 0
                && !new_uuid.trim().equals(redis_uuid.trim())) {
            RedisUtils.removeByUserID(redisClient, userID, loginType);
        }


        Map<String, String> dataMap = new HashMap<String, String>();
        Map<String, String> RedisMap = new HashMap<String, String>();

        //user:用户信息()
        //User user = new User();
        User user = userEmployService.mapObject2User(userEmployMap, null);
        RedisMap.put("user", YvanUtil.toJson(user));
        dataMap.put("userId", user.getId());
        dataMap.put("userCode", user.getUserCode());
        dataMap.put("companyId", user.getCompanyId());
        dataMap.put("userType", user.getUserType());
        dataMap.put("userName", user.getUserName());
        Department company = departmentService.selectById(user.getCompanyId());
        if(company!=null&&(!StringUtils.isEmpty(company.getCompanyShortname()))){
            dataMap.put("companyShortname", company.getCompanyShortname());
        }else {
            dataMap.put("companyShortname", "智造云管家");
        }



        //employ:员工信息()
        Employee employ = new Employee();
        employ = userEmployService.mapObject2Employee(userEmployMap, employ);
        RedisMap.put("employ", YvanUtil.toJson(employ));

        //deptId部门id-postId岗位ID
        dataMap.put("deptId", user.getDeptId());
        dataMap.put("postId", "");

        //userRole用户角色(角色ID','分隔的字符串)
        String roleIds = userRoleService.findRoleIdsByByUserID(user.getId());
        dataMap.put("roleIds", roleIds);
        RedisMap.put("userRole", roleIds);

        //userMenu菜单权限()
        //userButton按钮权限()

        //缓存业务数据
        //(手机端)Redis缓存Key:   (uuid:用户ID:企业ID:deecoop:userLoginMap:app)
        //(web端)Redis缓存Key:   (uuid:用户ID:企业ID:deecoop:userLoginMap:web)
        String Redis_userLogin_Key = new_uuid + ":" +
                userID + ":" +
                companyID + ":" +
                "deecoop" + ":" +
                Common.REDIS_USERLOGINMAP + ":" +
                loginType;
        //redisClient.set(Redis_userLogin_Key, YvanUtil.toJson(RedisMap));
        //30 * 60 * 1000 (半小时)
        redisClient.setWithExpireTime(Redis_userLogin_Key, YvanUtil.toJson(RedisMap), Common.REDIS_SESSIONID_LONG);

        model.putCode(Integer.valueOf(0));
        model.putResult(YvanUtil.toJson(dataMap));
        model.set("sessionID", Redis_userLogin_Key);

        return model;
    }
}
