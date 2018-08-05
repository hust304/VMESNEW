package com.xy.vmes.deecoop.system.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.CompanyService;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.UserService;
import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Map;

/**
 * 说明：企业管理-企业和企业账号或企业管理员Controller
 * @author 陈刚
 * @date 2018-08-06
 */
@RestController
@Slf4j
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;

    /**添加企业信息-同时创建企业账号或企业管理员
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/addCompanyAdmin")
    public ResultModel addCompanyAdmin() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        Department companyObj = (Department)HttpUtils.pageData2Entity(pageData, new Department());
        if (companyObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 组织对象Department 异常！</br>");
            return model;
        }

        String msgStr = companyService.checkColumnByAdd(companyObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Department>-组织架构的根节点(pid:root)-企业挂在此节点上
        Department rootObj = departmentService.findDepartmentByRoot();
        if (rootObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("根节点(pid:root)系统中无数据，请与管理员联系！</br>");
            return model;
        }

        //2. (企业名称-企业编码)在同一层不可重复
        StringBuffer msgBuf = new StringBuffer();
        if (companyService.isExistByName(rootObj.getId(), null, companyObj.getName())) {
            String msgTemp = "根名称: {0}<br/>企业名称: {1}<br/>在系统中已经重复！</br>";
            String msgExist = MessageFormat.format(msgTemp,
                    rootObj.getName(),
                    companyObj.getName());
            msgBuf.append(msgExist);
        }
        if (companyService.isExistByCode(rootObj.getId(), null, companyObj.getCode())) {
            String msgTemp = "根名称: {0}<br/>企业编码: {1}<br/>在系统中已经重复！</br>";
            String msgExist = MessageFormat.format(msgTemp,
                    rootObj.getName(),
                    companyObj.getCode());
            msgBuf.append(msgExist);
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        try {
            String id = Conv.createUuid();
            companyObj.setId(id);
            companyObj = departmentService.id2DepartmentByLayer(id,
                    Integer.valueOf(rootObj.getLayer().intValue() + 1),
                    companyObj);
            companyObj = departmentService.paterObject2ObjectDB(rootObj, companyObj);

            //获取(长名称,长编码)- 通过'-'连接的字符串
            Map<String, String> longNameCodeMpa = departmentService.findLongNameCodeByPater(rootObj);
            if (longNameCodeMpa != null
                    && longNameCodeMpa.get("LongName") != null
                    && longNameCodeMpa.get("LongName").trim().length() > 0
                    ) {
                companyObj.setLongName(longNameCodeMpa.get("LongName").trim() + "-" + companyObj.getName());
            }
            if (longNameCodeMpa != null
                    && longNameCodeMpa.get("LongCode") != null
                    && longNameCodeMpa.get("LongCode").trim().length() > 0
                    ) {
                companyObj.setLongCode(longNameCodeMpa.get("LongCode").trim() + "-" + companyObj.getCode());
            }
            //该企业-在组织表级别
            companyObj.setLayer(Integer.valueOf(rootObj.getLayer().intValue() + 1));
            companyObj.setPid(rootObj.getId());
            //organizeType组织类型(1:公司 2:部门)
            companyObj.setOrganizeType("1");
            //排列顺序serialNumber
            if (companyObj.getSerialNumber() == null) {
                Integer maxCount = departmentService.findMaxSerialNumber(rootObj.getId());
                companyObj.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
            }

            departmentService.save(companyObj);

            //创建(企业管理员)账户
            User user = new User();
            user.setCompanyId(companyObj.getId());
            String userCode = userService.createCoder(companyObj.getId());
            user.setUserCode(userCode);
            user.setPassword(MD5Utils.MD5(Common.DEFAULT_PASSWORD));
            userService.save(user);

        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**修改企业信息
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/updateCompany")
    public ResultModel updateCompany() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        Department companyObj = (Department)HttpUtils.pageData2Entity(pageData, new Department());
        if (companyObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 组织对象Department 异常！</br>");
            return model;
        }

        String msgStr = companyService.checkColumnByEdit(companyObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Department>-组织架构的根节点(pid:root)-企业挂在此节点上
        Department rootObj = departmentService.findDepartmentByRoot();
        if (rootObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("根节点(pid:root)系统中无数据，请与管理员联系！</br>");
            return model;
        }

        //2. (企业名称-企业编码)在同一层不可重复
        StringBuffer msgBuf = new StringBuffer();
        if (companyService.isExistByName(rootObj.getId(), companyObj.getId(), companyObj.getName())) {
            String msgTemp = "根名称: {0}<br/>企业名称: {1}<br/>在系统中已经重复！</br>";
            String msgExist = MessageFormat.format(msgTemp,
                    rootObj.getName(),
                    companyObj.getName());
            msgBuf.append(msgExist);
        }
        if (companyService.isExistByCode(rootObj.getId(), companyObj.getId(), companyObj.getCode())) {
            String msgTemp = "根名称: {0}<br/>企业编码: {1}<br/>在系统中已经重复！</br>";
            String msgExist = MessageFormat.format(msgTemp,
                    rootObj.getName(),
                    companyObj.getCode());
            msgBuf.append(msgExist);
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        try {
            Department companyDB = departmentService.findDepartmentById(companyObj.getId());
            companyDB = companyService.object2objectDB(companyObj, companyDB);

            //获取(长名称,长编码)- 通过'-'连接的字符串
            Map<String, String> longNameCodeMpa = departmentService.findLongNameCodeByPater(rootObj);
            if (longNameCodeMpa != null
                    && longNameCodeMpa.get("LongName") != null
                    && longNameCodeMpa.get("LongName").trim().length() > 0
                    ) {
                companyDB.setLongName(longNameCodeMpa.get("LongName").trim() + "-" + companyDB.getName());
            }
            if (longNameCodeMpa != null
                    && longNameCodeMpa.get("LongCode") != null
                    && longNameCodeMpa.get("LongCode").trim().length() > 0
                    ) {
                companyDB.setLongCode(longNameCodeMpa.get("LongCode").trim() + "-" + companyDB.getCode());
            }

            departmentService.update(companyDB);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**修改企业账号或企业管理员信息
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/updateAdmin")
    public ResultModel updateAdmin() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**修改企业信息-(禁用)状态
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/updateCompanyDisable")
    public ResultModel updateCompanyDisable() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**删除企业信息-有关联数据不可禁用户和删除
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/deleteCompanyAdmins")
    public ResultModel deleteCompanyAdmins() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**企业信息-Excel导出
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/exportExcelCompanyAdmins")
    public ResultModel exportExcelCompanyAdmins() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**企业信息-Excel导入
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/importExcelMenus")
    public ResultModel importExcelMenus() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }
}
