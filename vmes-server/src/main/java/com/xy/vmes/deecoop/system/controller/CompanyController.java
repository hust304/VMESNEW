package com.xy.vmes.deecoop.system.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.User;
import com.xy.vmes.entity.UserRole;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.*;

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
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private CoderuleService coderuleService;

    @PostMapping("/company/listPageCompanyAdmins")
    public ResultModel listPageCompanyAdmins() throws Exception {
        ResultModel model = new ResultModel();

        //1. 查询遍历List列表
        List<LinkedHashMap<String, String>> titleOutList = new ArrayList<LinkedHashMap<String, String>>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        List<LinkedHashMap<String, String>> titleList = companyService.getColumnList();
        if (titleList != null && titleList.size() > 0) {
            LinkedHashMap<String, String> titlesMap = titleList.get(0);
            for (Map.Entry<String, String> entry : titlesMap.entrySet()) {
                LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
                if (entry.getKey().indexOf("_hide") != -1) {
                    titleMap.put(entry.getKey().replace("_hide",""), entry.getValue());
                    titlesHideList.add(entry.getKey().replace("_hide",""));
                    varModelMap.put(entry.getKey().replace("_hide",""), "");
                } else if (entry.getKey().indexOf("_hide") == -1) {
                    titleMap.put(entry.getKey(), entry.getValue());
                    varModelMap.put(entry.getKey(), "");
                }
                titleOutList.add(titleMap);
            }
        }

        Map<String, Object> mapObj = new HashMap<String, Object>();
        mapObj.put("hideTitles", titlesHideList);
        mapObj.put("titles", YvanUtil.toJson(titleOutList));

        //2. 分页查询数据List
        PageData pageData = HttpUtils.parsePageData();
        String userType = (String)pageData.get("userType");
        String userId = (String)pageData.get("userId");
        String companyId = (String)pageData.get("companyId");

        pageData.put("layer", "1");
        if ("1".equals(userType) && companyId != null && companyId.trim().length() > 0) {
            pageData.put("id", companyId);
        } else if ("2".equals(userType) && userId != null && userId.trim().length() > 0) {
            pageData.put("cuser", userId);
        }

        List<Map<String, Object>> varList = companyService.getDataListPage(pageData, HttpUtils.parsePagination());
        List<Map<String, String>> varMapList = new ArrayList<Map<String, String>>();
        if(varList != null && varList.size() > 0) {
            for (Map<String, Object> map : varList) {
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMapList.add(varMap);
            }
        }
        mapObj.put("varList", YvanUtil.toJson(varMapList));

        model.putResult(mapObj);
        return model;
    }

    /**添加企业信息-同时创建企业账号或企业管理员
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/addCompanyAdmin")
    public ResultModel addCompanyAdmin() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String roleId = (String)pageData.get("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请选择一个角色套餐！</br>");
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

        //3. 创建(企业-企业管理员)信息
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

        //4. 创建(企业管理员)账户
        User user = new User();
        user.setCompanyId(companyObj.getId());
        String userCode = coderuleService.createCoder(companyObj.getId(), "vmes_user");
        user.setUserCode(userCode);
        user.setPassword(MD5Utils.MD5(Common.DEFAULT_PASSWORD));
        //用户类型(0:超级管理员1:企业管理员2:普通用户)
        user.setUserType("1");
        userService.save(user);

        //5. 创建(用户角色)
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleId);
        userRoleService.save(userRole);

        return model;
    }

    /**修改企业信息
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/updateCompany")
    public ResultModel updateCompany() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String roleId_new = (String)pageData.get("roleId_new");
        if (roleId_new == null || roleId_new.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请选择一个角色套餐！</br>");
            return model;
        }
        String roleId_old = (String)pageData.get("roleId_old");
        if (roleId_old == null || roleId_old.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("角色套餐ID(角色ID)为空或空字符串！</br>");
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

        //3. 修改企业信息
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

        //获取当前企业管理员
        User user = userService.findCompanyAdmin(companyDB.getId());
        if (user != null) {
            //4. 修改用户角色表
            PageData findMap = new PageData();
            findMap.put("userId", user.getId());
            findMap.put("roleId_old", roleId_old);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            UserRole userRole = userRoleService.findUserRole(findMap);

            if (userRole != null) {
                userRole.setRoleId(roleId_new);
                userRoleService.update(userRole);
            }
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

        return model;
    }

    /**修改企业信息-(禁用)状态
     *
     * @author 陈刚
     * @date 2018-08-06
     */
//    @PostMapping("/company/updateDisableCompany")
//    public ResultModel updateDisableCompany() {
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        try {
//        } catch (Exception e) {
//            throw new RestException("", e.getMessage());
//        }
//
//        return model;
//    }

    /**删除企业信息-有关联数据不可禁用户和删除
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/deleteCompanyAdmins")
    public ResultModel deleteCompanyAdmins() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String companyIds = (String)pageData.get("companyIds");
        if (companyIds == null || companyIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！</br>");
            return model;
        }

        String id_str = StringUtil.stringTrimSpace(companyIds);
        String[] id_arry = id_str.split(",");

        //2. 当前企业节点下是否含有子节点
        String msgStr = companyService.checkDeleteCompanyByIds(id_str);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //禁用企业
        departmentService.updateDisableByIds(id_arry);
        //禁用企业管理员
        userService.updateDisableByCompanyIds(id_arry);

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


        return model;
    }
}
