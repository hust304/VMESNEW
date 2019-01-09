package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.User;
import com.xy.vmes.entity.UserRole;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private CompanyService companyService;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserDefinedMenuService userDefinedMenuService;

    @Autowired
    private CoderuleService coderuleService;

    @Autowired
    private ColumnService columnService;

//    @PostMapping("/company/listPageCompanyAdmins")
//    public ResultModel listPageCompanyAdmins() throws Exception {
//        ResultModel model = new ResultModel();
//
//        //1. 查询遍历List列表
//        List<LinkedHashMap<String, String>> titleOutList = new ArrayList<LinkedHashMap<String, String>>();
//        List<String> titlesHideList = new ArrayList<String>();
//        Map<String, String> varModelMap = new HashMap<String, String>();
//        List<LinkedHashMap<String, String>> titleList = companyService.getColumnList();
//        if (titleList != null && titleList.size() > 0) {
//            LinkedHashMap<String, String> titlesMap = titleList.get(0);
//            for (Map.Entry<String, String> entry : titlesMap.entrySet()) {
//                LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
//                if (entry.getKey().indexOf("_hide") != -1) {
//                    titleMap.put(entry.getKey().replace("_hide",""), entry.getValue());
//                    titlesHideList.add(entry.getKey().replace("_hide",""));
//                    varModelMap.put(entry.getKey().replace("_hide",""), "");
//                } else if (entry.getKey().indexOf("_hide") == -1) {
//                    titleMap.put(entry.getKey(), entry.getValue());
//                    varModelMap.put(entry.getKey(), "");
//                }
//                titleOutList.add(titleMap);
//            }
//        }
//
//        Map<String, Object> mapObj = new HashMap<String, Object>();
//        mapObj.put("hideTitles", titlesHideList);
//        mapObj.put("titles", YvanUtil.toJson(titleOutList));
//
//        //2. 分页查询数据List
//        PageData pageData = HttpUtils.parsePageData();
//        String userType = (String)pageData.get("userType");
//        String userId = (String)pageData.get("userId");
//        String companyId = (String)pageData.get("companyId");
//
//        pageData.put("layer", "1");
//        if ("1".equals(userType) && companyId != null && companyId.trim().length() > 0) {
//            pageData.put("id", companyId);
//        } else if ("2".equals(userType) && userId != null && userId.trim().length() > 0) {
//            pageData.put("cuser", userId);
//        }
//
//        Pagination pg = HttpUtils.parsePagination(pageData);
//        List<Map<String, Object>> varList = companyService.getDataListPage(pageData, pg);
//        List<Map<String, String>> varMapList = new ArrayList<Map<String, String>>();
//        if(varList != null && varList.size() > 0) {
//            for (Map<String, Object> map : varList) {
//                Map<String, String> varMap = new HashMap<String, String>();
//                varMap.putAll(varModelMap);
//                for (Map.Entry<String, String> entry : varMap.entrySet()) {
//                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
//                }
//                varMapList.add(varMap);
//            }
//        }
//        mapObj.put("varList", YvanUtil.toJson(varMapList));
//        mapObj.put("pageData", YvanUtil.toJson(pg));
//
//        model.putResult(mapObj);
//        return model;
//    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-08-23
     */
    @PostMapping("/company/listPageCompanyAdmins")
    public ResultModel listPageCompanyAdmins()  throws Exception {
        logger.info("################company/listPageCompanyAdmins 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("company");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }

        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);


        PageData pd = HttpUtils.parsePageData();
        pd.put("layer", "1");
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = companyService.getDataListPage(pd, pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################company/listPageCompanyAdmins 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * Excel导出功能：
     * 1. 勾选指定行导出-(','逗号分隔的id字符串)
     * 2. 按查询条件导出(默认查询方式)
     * 参数说明:
     *   ids          : 业务id字符串-(','分隔的字符串)
     *   queryColumn  : 查询字段(sql where 子句)
     *   showFieldcode: 导出Excel字段Code-显示顺序按照字符串排列顺序-(','分隔的字符串)

     * 注意: 参数(ids,queryColumn)这两个参数是互斥的，(有且有一个参数不为空)
     *
     * @throws Exception
     */
    @PostMapping("/company/exportExcelCompanys")
    public void exportExcelCompanys() throws Exception {
        logger.info("################company/exportExcelCompanys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("company");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        pd.put("layer", "1");
        String ids = pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = companyService.getDataListPage(pd, pg);
        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response  = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        //String fileName = "Excel数据字典数据导出";
        String fileName = "ExcelCompany";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################company/exportExcelCompanys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**添加企业信息-同时创建企业账号或企业管理员
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/addCompanyAdmin")
    public ResultModel addCompanyAdmin() throws Exception {
        logger.info("################company/addCompanyAdmin 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String roleId = (String)pageData.get("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请选择一个角色套餐！");
            return model;
        }
        Department companyObj = (Department)HttpUtils.pageData2Entity(pageData, new Department());
        if (companyObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 组织对象Department 异常！");
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
            model.putMsg("根节点(pid:root)系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (企业名称-企业编码)在同一层不可重复
        StringBuffer msgBuf = new StringBuffer();
        if (companyService.isExistByName(rootObj.getId(), null, companyObj.getName())) {
            String msgTemp = "根名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "企业名称: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String msgExist = MessageFormat.format(msgTemp,
                    rootObj.getName(),
                    companyObj.getName());
            msgBuf.append(msgExist);
        }
        if (companyService.isExistByCode(rootObj.getId(), null, companyObj.getCode())) {
            String msgTemp = "根名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "企业编码: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
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
        //organizeType组织类型(1:公司 2:部门)
        companyObj.setOrganizeType("1");
        companyObj.setCuser(pageData.getString("cuser"));

        companyObj = departmentService.id2DepartmentByLayer(id,
                Integer.valueOf(rootObj.getLayer().intValue() + 1),
                companyObj);
        companyObj = departmentService.paterObject2ObjectDB(rootObj, companyObj);

//        //获取(长名称,长编码)- 通过'-'连接的字符串
//        Map<String, String> longNameCodeMpa = departmentService.findLongNameCodeByPater(rootObj);
//        if (longNameCodeMpa != null
//                && longNameCodeMpa.get("LongName") != null
//                && longNameCodeMpa.get("LongName").trim().length() > 0
//                ) {
//            companyObj.setLongName(longNameCodeMpa.get("LongName").trim() + "-" + companyObj.getName());
//        }
//        if (longNameCodeMpa != null
//                && longNameCodeMpa.get("LongCode") != null
//                && longNameCodeMpa.get("LongCode").trim().length() > 0
//                ) {
//            companyObj.setLongCode(longNameCodeMpa.get("LongCode").trim() + "-" + companyObj.getCode());
//        }
        //该企业-在组织表级别
        //companyObj.setLayer(Integer.valueOf(rootObj.getLayer().intValue() + 1));
        //companyObj.setPid(rootObj.getId());

        //排列顺序serialNumber
        if (companyObj.getSerialNumber() == null) {
            Integer maxCount = departmentService.findMaxSerialNumber(rootObj.getId());
            companyObj.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }

        departmentService.save(companyObj);

        //4. 创建(企业管理员)账户

        String userName = (String)pageData.get("userName");
        String mobile = (String)pageData.get("mobile");
        String email = (String)pageData.get("email");

        User user = new User();
        user.setCompanyId(companyObj.getId());
        user.setDeptId(companyObj.getId());
//        String userCode = coderuleService.createCoder(companyObj.getId(), "vmes_user");
        String userCode = companyObj.getCode().toLowerCase()+"admin";
        user.setUserCode(userCode);
        user.setUserName(StringUtils.isEmpty(userName)?userCode:userName);
        user.setMobile(mobile);
        user.setEmail(email);

        if(mobile!=null&&mobile.trim().length()>6){
            mobile = mobile.trim();
            String password = mobile.substring(mobile.length()-6,mobile.length());
            user.setPassword(MD5Utils.MD5(password));
        }else{
        user.setPassword(MD5Utils.MD5(Common.DEFAULT_PASSWORD));
        }


        //用户类型(userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
        user.setUserType(Common.DICTIONARY_MAP.get("userType_company"));
        userService.save(user);

        //5. 创建(用户角色)
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleId);
        userRoleService.save(userRole);
        Long endTime = System.currentTimeMillis();
        logger.info("################company/addCompanyAdmin 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**修改企业信息
     *
     * @author 陈刚
     * @date 2018-08-06
     */
    @PostMapping("/company/updateCompany")
    public ResultModel updateCompany() throws Exception {
        logger.info("################company/updateCompany 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String roleId = (String)pageData.get("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请选择一个角色套餐！");
            return model;
        }

        Department companyObj = (Department)HttpUtils.pageData2Entity(pageData, new Department());
        if (companyObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 组织对象Department 异常！");
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
            model.putMsg("根节点(pid:root)系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (企业名称-企业编码)在同一层不可重复
        StringBuffer msgBuf = new StringBuffer();
        if (companyService.isExistByName(rootObj.getId(), companyObj.getId(), companyObj.getName())) {
            String msgTemp = "根名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "企业名称: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String msgExist = MessageFormat.format(msgTemp,
                    rootObj.getName(),
                    companyObj.getName());
            msgBuf.append(msgExist);
        }
        if (companyService.isExistByCode(rootObj.getId(), companyObj.getId(), companyObj.getCode())) {
            String msgTemp = "根名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "企业编码: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
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

//        //获取(长名称,长编码)- 通过'-'连接的字符串
//        Map<String, String> longNameCodeMpa = departmentService.findLongNameCodeByPater(rootObj);
//        if (longNameCodeMpa != null
//                && longNameCodeMpa.get("LongName") != null
//                && longNameCodeMpa.get("LongName").trim().length() > 0
//                ) {
//            companyDB.setLongName(longNameCodeMpa.get("LongName").trim() + "-" + companyDB.getName());
//        }
//        if (longNameCodeMpa != null
//                && longNameCodeMpa.get("LongCode") != null
//                && longNameCodeMpa.get("LongCode").trim().length() > 0
//                ) {
//            companyDB.setLongCode(longNameCodeMpa.get("LongCode").trim() + "-" + companyDB.getCode());
//        }
        departmentService.update(companyDB);

        //获取当前企业管理员

        User user = userService.findCompanyAdmin(companyDB.getId());
        if (user != null) {
            String userName = (String)pageData.get("userName");
            String mobile = (String)pageData.get("mobile");
            String email = (String)pageData.get("email");
            //4. 修改用户表
            user.setUserName(userName);
            user.setMobile(mobile);
            user.setEmail(email);
            userService.update(user);

            //5. 修改用户角色表
            PageData findMap = new PageData();
            findMap.put("userId", user.getId());
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            UserRole userRole = userRoleService.findUserRole(findMap);

            if (userRole != null) {
                userRole.setRoleId(roleId);
                userRoleService.update(userRole);
            }
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################company/updateCompany 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
        logger.info("################company/deleteCompanyAdmins 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！/n");
            return model;
        }

        String companyIds = (String)pageData.get("companyIds");
        if (companyIds == null || companyIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！/n");
            return model;
        }

        String companyId_str = StringUtil.stringTrimSpace(companyIds);
        String[] companyId_arry = companyId_str.split(",");

        //当前企业节点下是否含有子节点
        String msgStr = companyService.checkDeleteCompanyByIds(companyId_str);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        for (int j = 0; j < companyId_arry.length; j++) {
            String companyId = companyId_arry[j];

            //(部门id,user_type)查询(vmes_user)用户表
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("deptId", companyId);
            findMap.put("userType", Common.DICTIONARY_MAP.get("userType_company"));
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            User user = userService.findUser(findMap);

            String userId = "";
            if (user != null && user.getId() != null && user.getId().trim().length() > 0) {
                userId = user.getId().trim();

                //2. 删除(vmes_user)用户表
                userService.deleteById(userId);
                //3. 删除(vmes_user_role)用户角色表
                userRoleService.deleteUserRoleByUserId(userId);
                //4. 删除(vmes_user_defined_menu)用户主页表
                userDefinedMenuService.deleteUserDefinedMenuByUserId(userId);
            }
        }

        //删除企业
        departmentService.deleteByIds(companyId_arry);

        Long endTime = System.currentTimeMillis();
        logger.info("################company/deleteCompanyAdmins 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
