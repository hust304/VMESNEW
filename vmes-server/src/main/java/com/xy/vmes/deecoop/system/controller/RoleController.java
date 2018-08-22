package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.common.util.RedisUtils;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Role;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.YvanUtil;
import com.yvan.cache.RedisClient;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;


/**
* 说明：Controller
* @author 陈刚 自动生成
* @date 2018-07-30
*/
@RestController
@Slf4j
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private RoleButtonService roleButtonService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    RedisClient redisClient;

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-30
    */
    @GetMapping("/role/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################role/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Role role = roleService.selectById(id);
        model.putResult(role);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-30
    */
    @PostMapping("/role/save")
    public ResultModel save()  throws Exception {

        logger.info("################role/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Role role = (Role)HttpUtils.pageData2Entity(pd, new Role());
        roleService.save(role);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-30
    */
    @PostMapping("/role/update")
    public ResultModel update()  throws Exception {

        logger.info("################role/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Role role = (Role)HttpUtils.pageData2Entity(pd, new Role());
        roleService.update(role);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-30
    */
    @GetMapping("/role/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################role/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        roleService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-30
    */
    @PostMapping("/role/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################role/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        List<Role> roleList = roleService.dataListPage(pd,pg);
        model.putResult(roleList);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-30
    */
    @PostMapping("/role/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################role/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Role> roleList = roleService.dataList(pd);
        model.putResult(roleList);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-30
    */
    @GetMapping("/role/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################role/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = roleService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                //List<Map> varList = roleService.findDataList(pd);
                    //request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################role/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**添加角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/listPageRoles")
    public ResultModel listPageRoles() throws Exception{
        ResultModel model = new ResultModel();

        //1. 查询遍历List列表
        List<LinkedHashMap<String, String>> titleOutList = new ArrayList<LinkedHashMap<String, String>>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        List<LinkedHashMap<String, String>> titleList = roleService.getColumnList();
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
        String userId = (String)pageData.get("userId");
        String companyId = (String)pageData.get("companyId");

        if (companyId != null && companyId.trim().length() > 0) {
            pageData.put("companyId", companyId);
        }
        if (userId != null && userId.trim().length() > 0) {
            pageData.put("cuser", userId);
        }

        List<Map<String, Object>> varList = roleService.getDataListPage(pageData, HttpUtils.parsePagination());
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

    /**添加角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/addRole")
    public ResultModel addRole() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：参数(pageData)为空！</br>");
            return model;
        }

        String name = (String)pageData.get("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(角色名称)输入为空或空字符串，(角色名称)是必填字段不可为空！<br/>");
            return model;
        }

        String userId = (String)pageData.get("userId");
        String companyId = "";
        if (pageData.get("companyId") != null) {
            companyId = (String)pageData.get("companyId");
        }

        //角色名称是否相同
        if (roleService.isExistByName(companyId, null, name)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("角色名称：" + name + "&nbsp;在系统中已经存在！</br>");
            return model;
        }

        //获取角色编码
        String code = coderuleService.createCoder(companyId, "vmes_role", "R");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("生成角色编码失败，请与管理员联系！");
            return model;
        }

        //3. 添加角色
        Role role = new Role();
        if (companyId != null && companyId.trim().length() > 0) {
            role.setCompanyId(companyId.trim());
        }
        role.setCuser(userId);
        role.setCode(code);
        role.setName(name);
        roleService.save(role);

        return model;
    }

    /**修改角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/updateRole")
    public ResultModel updateRole() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String id = (String)pageData.get("id");
        String name = (String)pageData.get("name");
        String companyId = (String)pageData.get("companyId");

        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！<br/>";
        }
        if (name == null || name.trim().length() == 0) {
            msgStr = msgStr + "(角色名称)输入为空或空字符串，(角色名称)是必填字段不可为空！<br/>";
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //角色名称是否相同
        if (roleService.isExistByName(companyId, id, name)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("角色名称：" + name + "&nbsp;在系统中已经存在！</br>");
            return model;
        }

        //3. 修改角色
        Role objectDB = roleService.findRoleById(id);
        objectDB.setName(name);
        roleService.update(objectDB);

        return model;
    }

    /**修改角色(禁用)状态
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/updateDisableRole")
    public ResultModel updateDisableRole() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String id = (String)pageData.get("id");
        String isdisable = (String)pageData.get("isdisable");

        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！<br/>";
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！<br/>";
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2.当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
        msgStr = roleService.checkDeleteRoleByRoleIds(id);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //修改角色(禁用)状态
        Role objectDB = roleService.findRoleById(id);
        objectDB.setIsdisable(isdisable);
        roleService.update(objectDB);

        return model;
    }

    /**删除角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/deleteRoles")
    public ResultModel deleteRoles() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String ids = (String)pageData.get("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！</br>");
            return model;
        }

        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");

        //2.当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
        String msgStr = roleService.checkDeleteRoleByRoleIds(id_str);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        for (int i = 0; i < id_arry.length; i++) {
            String roleID = id_arry[i];
            try {
                //1. 当前角色ID-禁用(用户角色)
                userRoleService.updateDisableByRoleId(roleID);
                //2. 当前角色ID-禁用(角色菜单)
                roleMenuService.updateDisableByRoleId(roleID);
                //3. 当前角色ID-禁用(角色按钮)
                roleButtonService.updateDisableByRoleId(roleID);

            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
        }
        roleService.updateDisableByIds(id_arry);

        return model;
    }

    /**Excel导入角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/importExcelRoles")
    public ResultModel importExcelRoles() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        return model;
    }
    /**Excel导出角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/exportExcelRoles")
    public ResultModel exportExcelRoles() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        return model;
    }

    /**角色批量绑定用户
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/saveRoleUsers")
    public ResultModel saveRoleUsers() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String msgStr = new String();
        String roleID = (String)pageData.get("roleID");
        if (roleID == null || roleID.trim().length() == 0) {
            msgStr = msgStr + "roleID为空或空字符串！<br/>";
        }
        String userIds = (String)pageData.get("isdisable");
        if (userIds == null || userIds.trim().length() == 0) {
            msgStr = msgStr + "userIds为空或空字符串！<br/>";
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2.当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
        msgStr = roleService.checkDeleteRoleByRoleIds(roleID);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //3. 删除角色用户(当前角色)
        userRoleService.deleteUserRoleByRoleId(roleID);

        //4. 添加角色用户(当前角色)
        userRoleService.addUserRoleByUserIds(roleID, userIds);

        return model;
    }
    /**角色批量绑定菜单
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/saveRoleMeuns")
    public ResultModel saveRoleMeuns() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String msgStr = new String();
        String roleID = (String)pageData.get("roleID");
        if (roleID == null || roleID.trim().length() == 0) {
            msgStr = msgStr + "roleID为空或空字符串！<br/>";
        }
        String meunIds = (String)pageData.get("meunIds");
        if (meunIds == null || meunIds.trim().length() == 0) {
            msgStr = msgStr + "meunIds为空或空字符串！<br/>";
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2.当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
        msgStr = roleService.checkDeleteRoleByRoleIds(roleID);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //3. 删除角色菜单(当前角色)
        roleMenuService.deleteRoleMenuByRoleId(roleID);

        //4. 添加角色菜单(当前角色)
        roleMenuService.addRoleMenuByMeunIds(roleID, meunIds);

        return model;
    }

    /**角色对应全部菜单树
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/treeRoleMeunsAll")
    public ResultModel treeRoleMeunsAll() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        return model;
    }
    /**角色对应(已选的)菜单树
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/treeRoleMeunsSelected")
    public ResultModel treeRoleMeunsSelected() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        return model;
    }

    /**角色对应全部菜单按钮列表
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/listRoleMeunsButtonsAll")
    public ResultModel listRoleMeunsButtonsAll() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        return model;
    }
    /**角色对应(已选的)菜单按钮列表
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/saveRoleMeunsButtons")
    public ResultModel saveRoleMeunsButtons() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String msgStr = new String();
        String roleID = (String)pageData.get("roleID");
        if (roleID == null || roleID.trim().length() == 0) {
            msgStr = msgStr + "roleID为空或空字符串！<br/>";
        }
        String buttonIds = (String)pageData.get("buttonIds");
        if (buttonIds == null || buttonIds.trim().length() == 0) {
            msgStr = msgStr + "buttonIds为空或空字符串！<br/>";
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2.当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
        msgStr = roleService.checkDeleteRoleByRoleIds(roleID);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //3. 删除角色按钮(当前角色)
        roleButtonService.deleteRoleButtonByRoleId(roleID);

        //4. 添加角色按钮(当前角色)
        roleButtonService.addRoleButtonByMeunIds(roleID, buttonIds);

        return model;
    }

    /**
     * @author 陈刚 自动创建，禁止修改
     * @date 2018-07-30
     */
    @PostMapping("/role/dataListRoles")
    public ResultModel dataListRoles()  throws Exception {

        logger.info("################role/dataListRoles 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Map> roleList = roleService.findDataList(pd);
        model.putResult(roleList);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/dataListRoles 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



