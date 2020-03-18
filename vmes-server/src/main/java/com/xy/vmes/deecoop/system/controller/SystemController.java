package com.xy.vmes.deecoop.system.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.entity.User;
import com.xy.vmes.entity.UserRole;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.cache.RedisClient;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@RestController
@Slf4j
public class SystemController {
    private Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private CompanyApplicationService companyApplicationService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    RedisClient redisClient;
    @Autowired
    private MailService mailService;

    @PostMapping("/system/findSystemDateTime")
    public ResultModel findSystemDateTime() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String dateFormat = pageData.getString("dateFormat");
        if (dateFormat == null || dateFormat.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("日期格式为空或空字符串！");
            return model;
        }

        String dateStr = DateFormat.date2String(new Date(), dateFormat);
        if (dateStr == null || dateStr.trim().length() == 0) {
            String msgTemp = "系统时间转换错误，日期格式({0})";
            String msgStr = MessageFormat.format(msgTemp, dateFormat);

            model.putCode("1");
            model.putMsg(msgStr);
            return model;
        }

        model.set("sysDateTime", dateStr);
        return model;
    }

    /**
     * 获取用户所属部门
     * 1. (用户id, 组织类型id) 关联表查询(用户表,用户员工,员工岗位,部门表)
     * 2. (企业id, 组织类型id) 部门表查询
     *
     * 接口参数
     *   userId: 用户id
     *   deptType: 组织类型 字典表(pid:8421e4f093a44f029dddbc4ab13068be:部门类型)
     *
     * 返回值:
     *   deptId: 部门ID
     *   deptName: 部门名称
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/system/findUserDepartmentByUser")
    public ResultModel findUserDepartmentByUser() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String userId = pageData.getString("userId");
        if(userId == null || userId.trim().length() == 0){
            model.putCode("1");
            model.putMsg("用户id为空或空字符串！");
            return model;
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String deptType = pageData.getString("deptType");
        if (deptType == null || deptType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("组织类型(部门类型)id为空或空字符串！");
            return model;
        }

        //deptId 部门ID
        String deptId = new String();
        //deptName 部门名称
        String deptName = new String();
        PageData findMap = new PageData();
        //////////////////////////////////////////////////////////////////////////////////////////////
        //1.(用户id, 组织类型id) 关联表查询(用户表,用户员工,员工岗位,部门表)
        findMap.put("userId", userId);
        findMap.put("deptType", deptType);
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        List<Map> varList = userService.getDataListPage(findMap, null);
        if (varList != null && varList.size() > 0) {
            Map<String, Object> valueMap = varList.get(0);
            if (valueMap != null && valueMap.get("deptId") != null) {
                deptId = valueMap.get("deptId").toString().trim();
            }

            if (valueMap != null && valueMap.get("deptName") != null) {
                deptName = valueMap.get("deptName").toString().trim();
            }

            model.put("deptId", deptId);
            model.put("deptName", deptName);
            return model;
        }

        //2. (企业id, 组织类型id) 部门表查询
        String deptTypeName = new String();
        findMap.clear();
        findMap.put("id", deptType);
        Dictionary dictionary = dictionaryService.findDictionaryById(deptType);
        if (dictionary != null && dictionary.getName() != null) {
            deptTypeName = dictionary.getName().trim();
        }

        findMap.clear();
        findMap.put("id1", companyId);
        findMap.put("deptType", deptType);
        findMap.put("layer", Integer.valueOf(2));
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Department> detpList = departmentService.findDepartmentList(findMap);
        if (detpList == null || detpList.size() == 0) {
            String msgTemp = "您所在的企业组织类型({0})的部门不存在，请与管理员联系！";
            String msgStr = MessageFormat.format(msgTemp, deptTypeName);

            model.putCode("1");
            model.putMsg(msgStr);
            return model;
        } else if (detpList != null && detpList.size() == 1) {
            model.put("deptId", detpList.get(0).getId());
            model.put("deptName", detpList.get(0).getName());
            return model;
        }

        return model;
    }

    /**
     * 通过Token获取用户账号
     *
     * @return
     * @throws Exception
     */
    //@GetMapping("/system/findUserCodeByToken")  //测试代码 真实环境无此代码
    @PostMapping("/system/findUserCodeByToken")
    public ResultModel findUserCodeByToken() throws Exception {
        logger.info("################/system/findUserCodeByToken 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //token 用户token
        String userKey = pageData.getString("token");
        if (userKey == null || userKey.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("token为空或空字符串！");
            return model;
        }

        PageData findMap = new PageData();
        findMap.put("companyId", Common.SYS_TRY_COMPANY_ID);
        findMap.put("userKey", userKey);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        User userDB = userService.findUser(findMap);

        String userCode = new String();
        if (userDB != null && userDB.getUserCode() != null && userDB.getUserCode().trim().length() > 0) {
            model.put("userCode", userCode);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/system/findUserCodeByToken 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 主页企业试用申请
     * 验证企业简称(企业编码)是否同名
     * 成功: code:0 msg:执行成功!
     * 失败: code:1 msg:失败原因字符串
     *
     * @return
     * @throws Exception
     */
    //@GetMapping("/system/checkExistCompanyCode")  //测试代码 真实环境无此代码
    @PostMapping("/system/checkExistCompanyCode")
    public ResultModel checkExistCompanyCode() throws Exception {
        logger.info("################/system/checkExistCompanyCode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //企业简称(企业编码): code
        String code = pageData.getString("code");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业简称为空或空字符串！");
            return model;
        }

        //非法字符
        if (!StringUtil.isWord(code)) {
            model.putCode(Integer.valueOf(1));
            String errorTemp = "企业简称({0})存在非法字符，必须[大小写字母下划线数字]";
            String msgStr = MessageFormat.format(errorTemp, code);
            model.putMsg(msgStr);
            return model;
        }

        //验证企业简称(企业编码)是否同名
        if (companyService.isExistByCode(null, null, code)) {
            String msgTemp = "企业简称({0})在系统中已经存在";
            String msgStr = MessageFormat.format(msgTemp, code);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //企业简称: code
        //创建(企业管理员)账户 表(vmes_user)中是否存在
        String userCode = code.toLowerCase() + "admin";
        Boolean isExistUser = userService.isExistUserByUserCode(null, userCode);
        if (isExistUser != null && isExistUser.booleanValue()) {
            model.putCode(Integer.valueOf(1));
            String msgTemp = "当前企业简称({0})，对应的用户企业管理员账号{1}在系统中已经存在，请更换企业简称";
            String msgStr = MessageFormat.format(msgTemp, code, userCode);
            model.putMsg(msgStr);
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/system/checkExistCompanyCode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//     * 1. 生成4位验证码
//     * 2. 验证码-Redis缓存Key:(securityCode)
//     * 3. 验证码-返回页面
//     * 返回值 <ResultModel>
//     *     ResultModel.code
//     *     ResultModel.msg
//     *     ResultModel.result<Map<String, Object>>
//     *         securityCode:验证码
//     *         securityCodeKey:(uuid:securityCode)
//     *
//     * 创建人：陈刚
//     * 创建时间：2018-07-24
//     */
//    @PostMapping("/system/createSecurityCode")
//    public ResultModel createSecurityCode()  throws Exception {
//        logger.info("################/system/createSecurityCode 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        String SecurityCode = StringUtil.findSecurityCode(4);
//        String RedisCodeKey = Conv.createUuid() + ":" + Common.REDIS_SECURITY_CODE;
//
//        //Redis-验证码-缓存2分钟(60 * 1000)
//        int minute = 2 * 60 * 1000;
//        redisClient.setWithExpireTime(RedisCodeKey, SecurityCode, minute);
//
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        dataMap.put("securityCode", SecurityCode);
//        dataMap.put("securityCodeKey", RedisCodeKey);
//
//        ResultModel model = new ResultModel();
//        model.putResult(dataMap);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/system/createSecurityCode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

//    /**
//     * 主页企业试用申请
//     *
//     * @return
//     * @throws Exception
//     */
//    //@GetMapping("/system/companyApplication")  //测试代码 真实环境无此代码
//    @PostMapping("/system/companyApplication")
//    public ResultModel companyApplication() throws Exception {
//        logger.info("################/system/companyApplication 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        String strInfo = this.findParameterByCompanyApplication(pageData);
//        logger.info("companyApplication:parameter:" + strInfo);
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //接口参数非空判断
//        String msgIsNullTemp = "{0}为必填项不可为空";
//        //企业名称: name
//        String name = pageData.getString("name");
//        if (name == null || name.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            String msgStr = MessageFormat.format(msgIsNullTemp, "企业名称");
//            model.putMsg(msgStr);
//            return model;
//        }
//        //企业简称: code
//        String code = pageData.getString("code");
//        if (code == null || code.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            String msgStr = MessageFormat.format(msgIsNullTemp, "企业简称");
//            model.putMsg(msgStr);
//            return model;
//        }
//        code = code.trim();
//
//        //手机号: mobile
//        String mobile = pageData.getString("mobile");
//        if (mobile == null || mobile.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            String msgStr = MessageFormat.format(msgIsNullTemp, "手机号");
//            model.putMsg(msgStr);
//            return model;
//        }
//        mobile = mobile.trim();
//
//        //验证码: securityCode (当前验证码)
//        String securityCode = pageData.getString("securityCode");
//        if (securityCode == null || securityCode.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            String msgStr = MessageFormat.format(msgIsNullTemp, "验证码");
//            model.putMsg(msgStr);
//            return model;
//        }
//        securityCode = securityCode.trim();
//
//        //验证码(Redis缓存Key): securityCodeKey
//        String securityCodeKey = pageData.getString("securityCodeKey");
//        if (securityCodeKey == null || securityCodeKey.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("securityCodeKey(验证码Redis缓存Key)为空或空字符串");
//            return model;
//        }
//        securityCodeKey = securityCodeKey.trim();
//
//        //邮箱: email
//        String email = new String();
//        if (pageData.getString("email") != null) {
//            email = pageData.getString("email").trim();
//        }
//
////        //套餐: roleKey
////        String roleKey = pageData.getString("roleKey");
////        if (roleKey == null || roleKey.trim().length() == 0) {
////            model.putCode(Integer.valueOf(1));
////            String msgStr = MessageFormat.format(msgIsNullTemp, "套餐");
////            model.putMsg(msgStr);
////            return model;
////        }
////        roleKey = roleKey.trim();
//
//        //用户数: companyUserCount
//        String companyUserCountStr = pageData.getString("companyUserCount");
//        if (companyUserCountStr == null || companyUserCountStr.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            String msgStr = MessageFormat.format(msgIsNullTemp, "用户数");
//            model.putMsg(msgStr);
//            return model;
//        }
//        companyUserCountStr = companyUserCountStr.trim();
//
//        //时间: year
//        String yearStr = pageData.getString("year");
//        if (yearStr == null || yearStr.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            String msgStr = MessageFormat.format(msgIsNullTemp, "时间");
//            model.putMsg(msgStr);
//            return model;
//        }
//        yearStr = yearStr.trim();
//
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //参数(数字)字符串验证
//        String msgNumberTemp = "{0}存在非法字符，必须全数字";
//        String msgNumberZeroTemp = "{0}必须大于零";
//
//        //手机号 mobile
//        try {
//            new BigDecimal(mobile);
//            if (mobile.length() != 11) {
//                model.putCode(Integer.valueOf(1));
//                model.putMsg("手机号请输入11位数字");
//                return model;
//            }
//        } catch (NumberFormatException e) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("手机号请输入11位数字");
//            return model;
//        }
//
//        //用户数 companyUserCount
//        try {
//            Integer companyUserCount = new Integer(companyUserCountStr);
//            if (companyUserCount <= 0) {
//                model.putCode(Integer.valueOf(1));
//                String msgStr = MessageFormat.format(msgNumberZeroTemp, "用户数");
//                model.putMsg(msgStr);
//                return model;
//            }
//        } catch (NumberFormatException e) {
//            model.putCode(Integer.valueOf(1));
//            String msgStr = MessageFormat.format(msgNumberTemp, "用户数");
//            model.putMsg(msgStr);
//            return model;
//        }
//        //时间 year 界面无限:9999 year:=100
//        try {
//            Integer year = new Integer(yearStr);
//            if (year <= 0) {
//                model.putCode(Integer.valueOf(1));
//                String msgStr = MessageFormat.format(msgNumberZeroTemp, "时间");
//                model.putMsg(msgStr);
//                return model;
//            } else if (9999 == year.intValue()) {
//                yearStr = "100";
//                pageData.put("year", yearStr);
//            }
//        } catch (NumberFormatException e) {
//            model.putCode(Integer.valueOf(1));
//            String msgStr = MessageFormat.format(msgNumberTemp, "时间");
//            model.putMsg(msgStr);
//            return model;
//        }
//
//        //金额: amount(单位元)
//        BigDecimal amount = BigDecimal.valueOf(0D);
//        String amountStr = pageData.getString("amount");
//        if (amountStr != null && amountStr.trim().length() > 0) {
//            try {
//                amount = new BigDecimal(amountStr);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//        }
//        //四舍五入到2位小数
//        amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //验证码-是否过期
//        String old_securityCode = redisClient.get(securityCodeKey.trim());
//        if (!securityCode.equalsIgnoreCase(old_securityCode)) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("验证码输入错误或已经过期，请重新输入验证码！");
//            return model;
//        }
//
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //验证 企业简称(企业编码): code
//        //非法字符
//        if (!StringUtil.isWord(code)) {
//            model.putCode(Integer.valueOf(1));
//            String errorTemp = "企业简称({0})存在非法字符，必须[大小写字母下划线数字]";
//            String msgStr = MessageFormat.format(errorTemp, code);
//            model.putMsg(msgStr);
//            return model;
//        }
//
//        //验证企业简称(企业编码)是否同名
//        if (companyService.isExistByCode(null, null, code)) {
//            model.putCode(Integer.valueOf(1));
//            String msgTemp = "企业简称({0})在系统中已经存在";
//            String msgStr = MessageFormat.format(msgTemp, code);
//            model.putMsg(msgStr);
//            return model;
//        }
//
//        //企业简称: code
//        //创建(企业管理员)账户 表(vmes_user)中是否存在
//        String userCode = code.toLowerCase() + "admin";
//        Boolean isExistUser = userService.isExistUserByUserCode(null, userCode);
//        if (isExistUser != null && isExistUser.booleanValue()) {
//            model.putCode(Integer.valueOf(1));
//            String msgTemp = "当前企业简称({0})，对应的用户企业管理员账号{1}在系统中已经存在，请更换企业简称";
//            String msgStr = MessageFormat.format(msgTemp, code, userCode);
//            model.putMsg(msgStr);
//            return model;
//        }
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        companyApplicationService.addCompanyApplication(pageData);
//
//        //发送邮件
//        if (email != null && email.trim().length() > 0) {
//
//            //获取系统时间(yyyy-MM-dd)
//            String sysDateStr = DateFormat.date2String(new Date(), "yyyy年MM月dd日");
//
//            //String mailTemp = "企业名称：{0} 手机号：{1} 账号：{2} 初始密码：手机号后6位 请登录网址：https://web.ouhaicloud.com 使用";
//            String mailTemp = "亲爱的用户：<br>" +
//                                "您好！<br>" +
//                                "&nbsp;&nbsp;&nbsp;&nbsp;您于{0}注册了智造云管家，相关注册资料如下：<br>" +
//                                "&nbsp;&nbsp;&nbsp;&nbsp;企业名称：{1}<br>" +
//                                "&nbsp;&nbsp;&nbsp;&nbsp;注册手机号：{2}<br>" +
//                                "&nbsp;&nbsp;&nbsp;&nbsp;企业管理员登录账号：{3}<br>" +
//                                "&nbsp;&nbsp;&nbsp;&nbsp;初始密码：注册手机号后6位<br>" +
//                                "&nbsp;&nbsp;&nbsp;&nbsp;系统登录网址：web.deecoop.cn<br><br>" +
//
//                                "如有任何问题，欢迎随时咨询<br>" +
//                                "189-8979-2655<br>" +
//                                "或扫描下方二维码添加微信：<br>" +
//                                "<img src='https://web.deecoop.cn/fileUpload/QRCode/wxAppQRCode.png' width='150' height='150'/><br><br>" +
//
//                                "顶智智能 技术团队<br>" +
//                                "{0}<br>";
//
//            String mailContent = MessageFormat.format(mailTemp,
//                    sysDateStr,
//                    name,
//                    mobile,
//                    userCode);
//
//            try {
//                mailService.sendHtmlMail("企业申请注册成功",
//                        mailContent,
//                        email,
//                        null);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        Map<String, Object> dataMap = new HashMap();
//        dataMap.put("userCode", userCode);
//        //默认免费试用
//        String notCost = "true";
//        if (amount.doubleValue() > 0D) {
//            notCost = "false";
//
//            dataMap.put("year", yearStr);
//            dataMap.put("companyUserCount", companyUserCountStr);
//            dataMap.put("amount", amount);
//        }
//        dataMap.put("notCost", notCost);
//
//        model.putResult(dataMap);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/system/companyApplication 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
     * 主页企业(试用版)申请
     *
     * @return
     * @throws Exception
     */
    //@GetMapping("/system/companyTryApplication")  //测试代码 真实环境无此代码
    @PostMapping("/system/companyTryApplication")
    public ResultModel companyTryApplication() throws Exception {
        logger.info("################/system/companyTryApplication 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //接口参数非空判断
        String msgIsNullTemp = "{0}为必填项不可为空";

        //企业名称: name
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            String msgStr = MessageFormat.format(msgIsNullTemp, "企业名称");
            model.putMsg(msgStr);
            return model;
        }

        //手机号: mobile
        String mobile = pageData.getString("mobile");
        if (mobile == null || mobile.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            String msgStr = MessageFormat.format(msgIsNullTemp, "手机号");
            model.putMsg(msgStr);
            return model;
        }
        mobile = mobile.trim();

        //手机号 mobile
        try {
            new BigDecimal(mobile);
            if (mobile.length() != 11) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("手机号请输入11位数字");
                return model;
            }
        } catch (NumberFormatException e) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("手机号请输入11位数字");
            return model;
        }

        //验证码: securityCode (当前验证码)
        String securityCode = pageData.getString("securityCode");
        if (securityCode == null || securityCode.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            String msgStr = MessageFormat.format(msgIsNullTemp, "验证码");
            model.putMsg(msgStr);
            return model;
        }
        securityCode = securityCode.trim();

        //验证码(Redis缓存Key): securityCodeKey
        String securityCodeKey = pageData.getString("securityCodeKey");
        if (securityCodeKey == null || securityCodeKey.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("securityCodeKey(验证码Redis缓存Key)为空或空字符串");
            return model;
        }
        securityCodeKey = securityCodeKey.trim();

        //邮箱: email
        String email = new String();
        if (pageData.getString("email") != null) {
            email = pageData.getString("email").trim();
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //验证码-是否过期
        String old_securityCode = redisClient.get(securityCodeKey.trim());
        if (!securityCode.equalsIgnoreCase(old_securityCode)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("验证码输入错误或已经过期，请重新输入验证码！");
            return model;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //4. 创建(企业管理员)账户
        //获取用户登录账号(test+5位流水号)
        String userCode = coderuleService.createCoder(Common.SYS_TRY_COMPANY_ID,
                "vmes_user",
                "test");

        User addUser = new User();
        addUser.setCompanyId(Common.SYS_TRY_COMPANY_ID);
        addUser.setDeptId(Common.SYS_TRY_COMPANY_ID);
        addUser.setUserCode(userCode);
        addUser.setUserName(userCode);
        addUser.setMobile(mobile);
        addUser.setEmail(email);

        //账号登陆默认密码:手机后6位
        String password = mobile.substring(mobile.length() - 6, mobile.length());
        addUser.setPassword(MD5Utils.MD5(password));

        //用户类型(userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
        addUser.setUserType(Common.DICTIONARY_MAP.get("userType_employee"));

        //userKey 用户注册Key(用户免登录)
        addUser.setUserKey(Conv.createUuid());
        //userKeyDate 用户注册Key有效期(yyyy-MM-dd)
        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Date userKeyDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);
        try {
            String userKeyDateStr = DateFormat.getAddDay(sysDateStr,
                    DateFormat.DEFAULT_DATE,
                    Common.SYS_COMPANYAPPLICATION_USERKEY_DAYS,
                    DateFormat.DEFAULT_DATE_FORMAT);

            userKeyDate = DateFormat.dateString2Date(userKeyDateStr, DateFormat.DEFAULT_DATE_FORMAT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addUser.setUserKeyDate(userKeyDate);
        addUser.setRemark(name + " (试用版)申请注册");

        userService.save(addUser);

        //5.创建(用户角色)
        UserRole userRole = new UserRole();
        userRole.setUserId(addUser.getId());
        //角色表(vmes_role) 角色名称:套餐B 角色ID:00439bedece9443b93fc68be84c88ef4
        userRole.setRoleId(Common.SYS_COMPANYAPPLICATION_ROLE_ID_B);
        userRoleService.save(userRole);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //发送邮件
        if (email != null && email.trim().length() > 0) {

            //String mailTemp = "企业名称：{0} 手机号：{1} 账号：{2} 初始密码：手机号后6位 请登录网址：https://web.ouhaicloud.com 使用";
            String mailTemp = "亲爱的用户：<br>" +
                    "您好！<br>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;您于{0}注册了智造云管家，相关注册资料如下：<br>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;企业名称：{1}<br>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;注册手机号：{2}<br>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;企业管理员登录账号：{3}<br>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;初始密码：注册手机号后6位<br>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;系统登录网址：web.deecoop.cn<br><br>" +

                    "如有任何问题，欢迎随时咨询<br>" +
                    "189-8979-2655<br>" +
                    "或扫描下方二维码添加微信：<br>" +
                    "<img src='https://web.deecoop.cn/fileUpload/QRCode/wxAppQRCode.png' width='150' height='150'/><br><br>" +

                    "顶智智能 技术团队<br>" +
                    "{0}<br>";

            String mailContent = MessageFormat.format(mailTemp,
                    sysDateStr,
                    name,
                    mobile,
                    userCode);

            try {
                mailService.sendHtmlMail("企业申请注册成功",
                        mailContent,
                        email,
                        null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String userKey = new String();
        if (addUser != null && addUser.getUserKey() != null && addUser.getUserKey().trim().length() > 0) {
            userKey = addUser.getUserKey().trim();
        }

        Map<String, Object> dataMap = new HashMap();
        dataMap.put("userCode", userCode);
        dataMap.put("userKey", userKey);

        model.putResult(dataMap);
        Long endTime = System.currentTimeMillis();
        logger.info("################/system/companyTryApplication 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String findParameterByCompanyApplication(PageData pageData) {
        //企业名称: name
        String nameValue = new String();
        String name = pageData.getString("name");
        if (name == null) {
            nameValue = "is null";
        } else {
            nameValue = name;
        }

        //企业简称: code
        String codeValue = new String();
        String code = pageData.getString("code");
        if (code == null) {
            codeValue = "is null";
        } else {
            codeValue = code;
        }

        //手机号: mobile
        String mobileValue = new String();
        String mobile = pageData.getString("mobile");
        if (mobile == null) {
            mobileValue = "is null";
        } else {
            mobileValue = mobile;
        }

        //验证码: securityCode (当前验证码)
        String securityCodeValue = new String();
        String securityCode = pageData.getString("securityCode");
        if (securityCode == null) {
            securityCodeValue = "is null";
        } else {
            securityCodeValue = securityCode;
        }

        //验证码(Redis缓存Key): securityCodeKey
        String securityCodeKeyValue = new String();
        String securityCodeKey = pageData.getString("securityCodeKey");
        if (securityCodeKey == null) {
            securityCodeKeyValue = "is null";
        } else {
            securityCodeKeyValue = securityCodeKey;
        }

        //邮箱: email
        String emailValue = new String();
        String email = pageData.getString("email");
        if (email == null) {
            emailValue = "is null";
        } else {
            emailValue = email;
        }

        //用户数: companyUserCount
        String companyUserCountValue = new String();
        String companyUserCount = pageData.getString("companyUserCount");
        if (companyUserCount == null) {
            companyUserCountValue = "is null";
        } else {
            companyUserCountValue = companyUserCount;
        }

        //时间: year
        String yearValue = new String();
        String year = pageData.getString("year");
        if (year == null) {
            yearValue = "is null";
        } else {
            yearValue = year;
        }

        //金额: amount(单位元)
        String amountValue = new String();
        String amount = pageData.getString("amount");
        if (amount == null) {
            amountValue = "is null";
        } else {
            amountValue = amount;
        }

        String strTemp = "name:{0} code:{1} mobile:{2} securityCode:{3} securityCodeKey:{4} " +
                         "email:{5} companyUserCount:{6} year:{7} amount:{8} ";
        String strInfo = MessageFormat.format(strTemp,
                nameValue,
                codeValue,
                mobileValue,
                securityCodeValue,
                securityCodeKeyValue,
                emailValue,
                companyUserCountValue,
                yearValue,
                amountValue);

        return strInfo;
    }
}
