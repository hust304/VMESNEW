package com.xy.vmes.deecoop.mobile.system.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.RedisUtils;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.CompanyService;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.UserEmployeeService;
import com.xy.vmes.service.UserRoleService;
import com.yvan.*;
import com.yvan.cache.RedisClient;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：用户登录退出系统 Controller
 * 创建人：自动创建
 * 创建时间：2018-07-20
 */
@RestController
@Slf4j
public class MobileUserLoginController {
    private Logger logger = LoggerFactory.getLogger(MobileUserLoginController.class);

    @Autowired
    private CompanyService companyService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserEmployeeService userEmployService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    RedisClient redisClient;

    /**
     * 系统用户登录(web,手机)端-通用登录接口
     * Redis缓存Key:(uuid:mobile:用户ID:企业ID:deecoop:userLoginMap)
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

     * Redis缓存Key:   (uuid:mobile:用户ID:企业ID:deecoop:userLoginMap)
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
    @PostMapping("/mobile/userLogin/loginIn")
    public ResultModel loginIn() throws Exception {
        logger.info("################/mobile/userLogin/loginIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        //非空判断
        StringBuffer msgBuf = new StringBuffer();
        PageData pageData = HttpUtils.parsePageData();
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

//            if (pageData.get("securityCode") == null || pageData.get("securityCode").toString().trim().length() == 0 ) {
//                msgBuf.append("参数错误：验证码入为空或空字符串，验证码为必填项不可为空！");
//                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
//            }
//            if (pageData.get("securityCodeKey") == null || pageData.get("securityCodeKey").toString().trim().length() == 0 ) {
//                msgBuf.append("参数错误：验证码(Redis缓存Key)为空或空字符串！");
//                msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
//            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

//        //验证码-是否过期
//        String securityCode = pageData.get("securityCode").toString().trim();
//        String old_securityCode = redisClient.get(pageData.get("securityCodeKey").toString().trim());
//        if (!securityCode.equalsIgnoreCase(old_securityCode)) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("验证码输入错误或已经过期，请重新输入验证码！");
//            return model;
//        }

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
            redis_uuid = RedisUtils.findMobileRedisUuidByUserID(redisClient, userID);
            if (redis_uuid != null && redis_uuid.trim().length() > 0) {redis_uuid = redis_uuid.toLowerCase();}
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        //生成新的uuid-与Redis缓存中的Key比较
        //生成新的uuid-与Redis缓存中的历史(uuid)-不同(在其他终端登录)
        //清空历史Redis缓存Key(系统用户ID)字符串匹配
        if (redis_uuid != null && redis_uuid.trim().length() > 0
                && !new_uuid.trim().equals(redis_uuid.trim())) {
            RedisUtils.removeMobileByUserID(redisClient, userID);
        }

        //登录接口返回值 Map<String, String> dataMap
        Map<String, String> dataMap = new HashMap<String, String>();
        //user:用户信息()
        User user = userEmployService.mapObject2User(userEmployMap, null);
        //RedisMap.put("user", YvanUtil.toJson(user));
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

        //deptId部门id-postId岗位ID
        dataMap.put("deptId", user.getDeptId());
        dataMap.put("postId", "");


        Map<String, String> RedisMap = new HashMap<String, String>();
//        //employ:员工信息()
//        Employee employ = new Employee();
//        employ = userEmployService.mapObject2Employee(userEmployMap, employ);
//        RedisMap.put("employ", YvanUtil.toJson(employ));


        //userRole用户角色(角色ID','分隔的字符串)
        String roleIds = userRoleService.findRoleIdsByByUserID(user.getId());
        dataMap.put("roleIds", roleIds);
        //RedisMap.put("userRole", roleIds);

        //userMenu菜单权限()
        //userButton按钮权限()

        //缓存业务数据
        //Redis缓存Key:(uuid:mobile:用户ID:企业ID:deecoop:userLoginMap)
        String Redis_userLogin_Key = new_uuid + ":" +
                "mobile:" +
                userID + ":" +
                companyID + ":" +
                "deecoop" + ":" +
                Common.REDIS_USERLOGINMAP;
        //30 * 60 * 1000 (半小时)
        redisClient.setWithExpireTime(Redis_userLogin_Key, YvanUtil.toJson(RedisMap), Common.REDIS_SESSIONID_LONG);

        model.putCode(Integer.valueOf(0));
        model.putResult(YvanUtil.toJson(dataMap));
        model.set("sessionID", Redis_userLogin_Key);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/userLogin/loginIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 系统用户退出系统
     * Redis缓存Key:(uuid:mobile:用户ID:企业ID:deecoop:userLoginMap)
     *
     * 创建人：陈刚
     * 创建时间：2018-07-25
     * @return
     */
    @PostMapping("/mobile/userLogin/loginOut")
    public ResultModel loginOut() {
        logger.info("################/mobile/userLogin/loginOut 执行开始 ################# ");
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
        logger.info("################/mobile/userLogin/loginOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
