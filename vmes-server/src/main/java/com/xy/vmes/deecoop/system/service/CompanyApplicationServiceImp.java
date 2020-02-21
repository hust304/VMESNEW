package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.system.dao.CompanyMapper;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.User;
import com.xy.vmes.entity.UserRole;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：企业申请注册 实现口类
 * 创建人：陈刚
 * 创建时间：2020-02-21
 */
@Service
@Transactional(readOnly = false)
public class CompanyApplicationServiceImp implements CompanyApplicationService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;

    public void addCompanyApplication(PageData pageData) throws Exception {
        //1. 添加企业
        Department rootObj = departmentService.findDepartmentByRoot();
        Department addCompany = new Department();

        //企业名称: name
        String name = pageData.getString("name");
        addCompany.setName(name);

        //企业简称: code
        String code = pageData.getString("code");
        addCompany.setCode(code);

        //系统用户数 companyUserCount
        String companyUserCountStr = pageData.getString("companyUserCount").trim();
        Integer companyUserCount = Integer.valueOf(companyUserCountStr);
        addCompany.setCompanyUserCount(companyUserCount);

        //有效期(yyyy-mm-dd) companyValidityDate
        //时间 year
        String yearStr = pageData.getString("year").trim();
        Integer addYear = Integer.valueOf(yearStr);

        //当前系统时间+(时间)年
        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        String companyValidityDateStr = sysDateStr;
        try {
            companyValidityDateStr = DateFormat.getAddDay(sysDateStr,
                    DateFormat.DEFAULT_YEAR,
                    addYear.intValue(),
                    DateFormat.DEFAULT_DATE_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date companyValidityDate = DateFormat.dateString2Date(companyValidityDateStr, DateFormat.DEFAULT_DATE_FORMAT);
        addCompany.setCompanyValidityDate(companyValidityDate);

        String id = Conv.createUuid();
        addCompany.setId(id);
        //organizeType组织类型(1:公司 2:部门)
        addCompany.setOrganizeType("1");
        addCompany.setCuser(Common.SYS_COMPANYAPPLICATION_ADMIN_USER_ID);

        addCompany = departmentService.id2DepartmentByLayer(id,
                Integer.valueOf(rootObj.getLayer().intValue() + 1),
                addCompany);
        addCompany = departmentService.paterObject2ObjectDB(rootObj, addCompany);

        //排列顺序serialNumber
        if (addCompany.getSerialNumber() == null) {
            Integer maxCount = departmentService.findMaxSerialNumber(rootObj.getId());
            addCompany.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }
        departmentService.save(addCompany);

        //2.创建备件仓库:当创建企业时默认创建备件仓库
        Map<String, Object> valueMap = new HashMap<String, Object>();
        String warehouse_id = Conv.createUuid();
        valueMap.put("id", warehouse_id);
        ////实体库 warehouseEntity 2d75e49bcb9911e884ad00163e105f05
        valueMap.put("pid", Common.DICTIONARY_MAP.get("warehouseEntity"));
        valueMap.put("company_id", addCompany.getId());
        valueMap.put("entity_type", "2c81c25fbe9a45519e2df5bccaed240d");
        valueMap.put("layer", Integer.valueOf(2));

        //生成货位二维码
        String qrcode = fileService.createQRCode("warehouseBase", warehouse_id);
        if (qrcode != null && qrcode.trim().length() > 0) {
            valueMap.put("qrcode", qrcode);
        }

        //获取仓库编码
        String warehouseCode = coderuleService.createCoder(addCompany.getId(), "vmes_warehouse","WE");
        valueMap.put("code", warehouseCode);
        valueMap.put("warehouse_id", warehouse_id);
        valueMap.put("name", "备件库");
        valueMap.put("path_id", "df930aaecb7111e884ad00163e105f05-2d75e49bcb9911e884ad00163e105f05-" + warehouse_id);

        valueMap.put("path_name", "备件库");
        valueMap.put("cuser", addCompany.getCuser());
        valueMap.put("cdate", new Date());

        companyMapper.insertWarehouseBySpare(valueMap);

        //4. 创建(企业管理员)账户
        //String userName = (String)pageData.get("userName");
        String mobile = (String)pageData.get("mobile");
        String email = (String)pageData.get("email");

        User addUser = new User();
        addUser.setCompanyId(addCompany.getId());
        addUser.setDeptId(addCompany.getId());
        String userCode = addCompany.getCode().toLowerCase() + "admin";
        addUser.setUserCode(userCode);
        addUser.setUserName(userCode);
        addUser.setMobile(mobile);
        addUser.setEmail(email);

        //账号登陆默认密码:手机后6位
        String password = mobile.substring(mobile.length() - 6, mobile.length());
        addUser.setPassword(MD5Utils.MD5(password));

        //用户类型(userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
        addUser.setUserType(Common.DICTIONARY_MAP.get("userType_company"));
        userService.save(addUser);

        //5.创建(用户角色)
        UserRole userRole = new UserRole();
        userRole.setUserId(addUser.getId());
        //角色表(vmes_role) 角色名称:套餐A 角色ID:c4d92bfac8754500a44e815511b91f06
        userRole.setRoleId(Common.SYS_COMPANYAPPLICATION_ROLE_ID);
        userRoleService.save(userRole);
    }

}
