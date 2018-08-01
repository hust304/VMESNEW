package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Role;
import com.xy.vmes.service.RoleButtonService;
import com.xy.vmes.service.RoleMenuService;
import com.xy.vmes.service.RoleService;
import com.xy.vmes.service.UserRoleService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.xy.vmes.common.util.StringUtil;
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
    public ResultModel listPageRoles() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        List<LinkedHashMap> titles = new ArrayList<LinkedHashMap>();
        try {
            titles = roleService.getColumnList();
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        List<Map<String, Object>> varList = new ArrayList<Map<String, Object>>();
        try {
            pageData.put("cuser", null);
            pageData.put("uuser", null);
            varList = roleService.getDataList(pageData);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        Map mapObj = new HashMap();
        mapObj.put("titles",titles);
        mapObj.put("varList",varList);

        model.putResult(mapObj);
        return model;
    }

    /**添加角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/addRole")
    public ResultModel addRole() {
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

        try {
            Role role = new Role();
            role.setIsdisable("0");
            role.setName(name);
            roleService.save(role);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**修改角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/updateRole")
    public ResultModel updateRole() {
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

        try {
            Role objectDB = roleService.findRoleById(id);
            objectDB.setName(name);
            roleService.update(objectDB);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**修改角色(禁用)状态
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/updateRoleDisable")
    public ResultModel updateRoleDisable() {
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

        try {
            Role objectDB = roleService.findRoleById(id);
            objectDB.setIsdisable(isdisable);
            roleService.update(objectDB);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**删除角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/deleteRoles")
    public ResultModel deleteRoles() {
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

        try {
            for (int i = 0; i < id_arry.length; i++) {
                String roleID = id_arry[i];
                //1. 当前角色ID-禁用(用户角色)
                userRoleService.updateDisableByRoleId(roleID);
                //2. 当前角色ID-禁用(角色菜单)
                roleMenuService.updateDisableByRoleId(roleID);
                //3. 当前角色ID-禁用(角色按钮)
                roleButtonService.updateDisableByRoleId(roleID);
            }
            roleService.updateDisableByIds(id_arry);

        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

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
    public ResultModel saveRoleUsers() {
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
        try {
            userRoleService.deleteUserRoleByRoleId(roleID);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

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
    public ResultModel saveRoleMeuns() {
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
        try {
            roleMenuService.deleteRoleMenuByRoleId(roleID);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }
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
    public ResultModel saveRoleMeunsButtons() {
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
        try {
            roleButtonService.deleteRoleButtonByRoleId(roleID);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }
        //4. 添加角色按钮(当前角色)
        roleButtonService.addRoleButtonByMeunIds(roleID, buttonIds);

        return model;
    }


}



