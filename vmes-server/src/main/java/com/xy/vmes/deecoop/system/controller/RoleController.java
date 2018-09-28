package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.*;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
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
    private RoleMenuService roleMenuService;
    @Autowired
    private RoleButtonService roleButtonService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private CoderuleService coderuleService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MenuService menuService;
    //@Autowired
    //private MenuButtonService menuButtonService;
    @Autowired
    private MenuTreeService menuTreeService;
    @Autowired
    private ColumnService columnService;
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
        Pagination pg = HttpUtils.parsePagination(pd);
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
        logger.info("################role/listPageRoles 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        //1. 查询遍历List列表
        List<Column> columnList = columnService.findColumnList("role");
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
        Map<String, Object> mapObj = new HashMap<String, Object>();
        mapObj.put("hideTitles", titlesHideList);
        mapObj.put("titles", YvanUtil.toJson(titlesList));

        //2. 分页查询数据List
        PageData pageData = HttpUtils.parsePageData();
        pageData.put("cuser", null);

        Pagination pg = HttpUtils.parsePagination(pageData);
        List<Map> varList = roleService.getDataListPage(pageData, pg);
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
        mapObj.put("pageData", YvanUtil.toJson(pg));
        model.putResult(mapObj);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/listPageRoles 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
    @PostMapping("/role/exportExcelRoles")
    public void exportExcelRoles() throws Exception {
        logger.info("################role/exportExcelRoles 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("role");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        //1. 获取Excel导出数据查询条件
        PageData pd = HttpUtils.parsePageData();
        pd.put("cuser", null);
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
        List<Map> dataList = roleService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response  = HttpUtils.currentResponse();


        //查询数据-Excel文件导出
        //String fileName = "Excel数据字典数据导出";
        String fileName = "ExcelRole";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/exportExcelRoles 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

    }

    /**添加角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/addRole")
    public ResultModel addRole() throws Exception {
        logger.info("################role/addRole 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：参数(pageData)为空！");
            return model;
        }

        String name = (String)pageData.get("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(角色名称)输入为空或空字符串，(角色名称)是必填字段不可为空！");
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
            model.putMsg("角色名称：" + name + " 在系统中已经存在！");
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
        role.setRemark(pageData.getString("remark"));
        roleService.save(role);

        //4. 添加角色菜单
        RoleMenu roleMenu_1 = new RoleMenu();
        roleMenu_1.setRoleId(role.getId());
        roleMenu_1.setMenuId(Common.SYS_MENU_MAP.get("root"));
        roleMenu_1.setCuser(userId);
        roleMenuService.save(roleMenu_1);

        RoleMenu roleMenu_2 = new RoleMenu();
        roleMenu_2.setRoleId(role.getId());
        roleMenu_2.setMenuId(Common.SYS_MENU_MAP.get("home"));
        roleMenu_2.setCuser(userId);
        roleMenuService.save(roleMenu_2);

        Long endTime = System.currentTimeMillis();
        logger.info("################role/addRole 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**修改角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/updateRole")
    public ResultModel updateRole() throws Exception {
        logger.info("################role/updateRole 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String id = (String)pageData.get("id");
        String name = (String)pageData.get("name");
        String companyId = (String)pageData.get("companyId");

        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (name == null || name.trim().length() == 0) {
            msgStr = msgStr + "(角色名称)输入为空或空字符串，(角色名称)是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //角色名称是否相同
        if (roleService.isExistByName(companyId, id, name)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("角色名称：" + name + " 在系统中已经存在！");
            return model;
        }

        //3. 修改角色
        Role objectDB = roleService.findRoleById(id);
        objectDB.setName(name);
        objectDB.setRemark(pageData.getString("remark"));
        roleService.update(objectDB);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/updateRole 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**修改角色(禁用)状态
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/updateDisableRole")
    public ResultModel updateDisableRole() throws Exception {
        logger.info("################role/updateDisableRole 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String id = (String)pageData.get("id");
        String isdisable = (String)pageData.get("isdisable");

        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

//        //2.当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
//        msgStr = roleService.checkDeleteRoleByRoleIds(id);
//        if (msgStr.trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr);
//            return model;
//        }

        //修改角色(禁用)状态
        Role objectDB = (Role)HttpUtils.pageData2Entity(pageData, new Role());
        roleService.update(objectDB);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/updateDisableRole 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**删除角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/deleteRoles")
    public ResultModel deleteRoles() throws Exception {
        logger.info("################role/deleteRoles 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String ids = (String)pageData.get("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        ids = StringUtil.stringTrimSpace(ids);
        String[] id_arry = ids.split(",");
        for (int i = 0; i < id_arry.length; i++) {
            String roleID = id_arry[i];
            try {
                //1. 当前角色ID-禁用(用户角色)
                userRoleService.deleteUserRoleByRoleId(roleID);
                //2. 当前角色ID-禁用(角色菜单)
                roleMenuService.deleteRoleMenuByRoleId(roleID);
                //3. 当前角色ID-禁用(角色按钮)
                roleButtonService.deleteRoleButtonByRoleId(roleID);

            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
        }

        roleService.deleteByIds(ids.split(","));
        Long endTime = System.currentTimeMillis();
        logger.info("################role/deleteRoles 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**Excel导入角色
     *
     * @author 陈刚
     * @date 2018-07-30
     */
//    @PostMapping("/role/importExcelRoles")
//    public ResultModel importExcelRoles() {
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        return model;
//    }
//    /**Excel导出角色
//     *
//     * @author 陈刚
//     * @date 2018-07-30
//     */
//    @PostMapping("/role/exportExcelRoles")
//    public ResultModel exportExcelRoles() {
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        return model;
//    }

    /**角色批量绑定用户
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/saveRoleUsers")
    public ResultModel saveRoleUsers() throws Exception {
        logger.info("################role/saveRoleUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String roleID = (String)pageData.get("roleID");
        if (roleID == null || roleID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("roleID为空或空字符串！");
            return model;
        }

        //2. 删除角色用户(当前角色)
        userRoleService.deleteUserRoleByRoleId(roleID);

        String userIds = (String)pageData.get("userIds");
        //3. 添加角色用户(当前角色)
        userRoleService.addUserRoleByUserIds(roleID, userIds, (String)pageData.get("cuser"));

        Long endTime = System.currentTimeMillis();
        logger.info("################role/saveRoleUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**角色批量绑定菜单
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/saveRoleMeuns")
    public ResultModel saveRoleMeuns() throws Exception {
        logger.info("################role/saveRoleMeuns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String msgStr = new String();
        String roleID = (String)pageData.get("roleID");
        if (roleID == null || roleID.trim().length() == 0) {
            msgStr = msgStr + "roleID为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        String meunIds = (String)pageData.get("meunIds");
        if (meunIds == null || meunIds.trim().length() == 0) {
            msgStr = msgStr + "meunIds为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

//        //2.当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
//        msgStr = roleService.checkDeleteRoleByRoleIds(roleID);
//        if (msgStr.trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr);
//            return model;
//        }

        //3. 删除角色菜单(当前角色)
        roleMenuService.deleteRoleMenuByRoleId(roleID);

        //4. 添加角色菜单(当前角色)
        roleMenuService.addRoleMenuByMeunIds(roleID, meunIds);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/saveRoleMeuns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 菜单树
     * 1. 获取全部菜单表-生成菜单树结构体
     * 2. 根据角色ID-角色ID绑定的菜单选中状态-查询角色菜单表(vmes_role_menu)
     *
     * @author 陈刚
     * @date 2018-08-23
     */
    @PostMapping("/role/treeRoleMeunsAll")
    public ResultModel treeRoleMeunsAll() {
        logger.info("################role/treeRoleMeunsAll 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        //A. 获取全部菜单树-查询条件-(企业管理员账号)
        PageData pageData = HttpUtils.parsePageData();
        //角色List页面-勾选的角色id
        String roleIds = pageData.getString("roleIds");
        if (roleIds == null || roleIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("角色ID为空或空字符串！");
            return model;
        }

        roleIds = StringUtil.stringTrimSpace(roleIds);
        roleIds = "'" + roleIds.replace(",", "','") + "'";
        String queryRoleIds = "b.role_id in (" +  roleIds + ")";

        PageData findMap = new PageData();
        findMap.put("queryRoleIds", queryRoleIds);

        //B. 获取用户角色相关菜单树-查询条件-
        //获取当前登录用户-用户类型
        String userType = pageData.getString("userType");
        if (!Common.DICTIONARY_MAP.get("userType_admin").equals(userType)) {
            //获取当前登录用户-用户角色id
            String userRoleId = pageData.getString("userRoleId");
            if (userRoleId != null && userRoleId.trim().length() > 0) {
                String menuIds = roleMenuService.findMenuidByRoleIds(userRoleId);
                menuIds = StringUtil.stringTrimSpace(menuIds);
                menuIds = "'" + menuIds.replace(",", "','") + "'";

                String queryStr = "a.id in (" +  menuIds + ")";
                findMap.put("queryStr", queryStr);
            }
            findMap.put("rootStr", "a.pid in ('root')");
        }

        List<Map<String, Object>> roleMenuMapList = roleMenuService.listMenuMapByRole(findMap);
        List<TreeEntity> treeList = roleMenuService.roleMenuList2TreeList(roleMenuMapList, null);
        List<TreeEntity> menuTreeList = TreeUtil.listSwitchTree(null, treeList);
        String treeJsonStr = YvanUtil.toJson(menuTreeList);
        System.out.println("treeJson: " + treeJsonStr);
        model.putResult(treeJsonStr);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/treeRoleMeunsAll 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**角色对应(已选的)菜单树
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/treeRoleMeunsSelected")
    public ResultModel treeRoleMeunsSelected() {
        logger.info("################role/treeRoleMeunsSelected 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String roleIds = (String)pageData.get("roleIds");
        if (roleIds == null || roleIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("角色ID为空或空字符串！");
            return model;
        }

        roleIds = StringUtil.stringTrimSpace(roleIds);
        roleIds = "'" + roleIds.replace(",", "','") + "'";
        String queryRoleIds = "b.role_id in (" +  roleIds + ")";

        PageData findMap = new PageData();
        findMap.put("queryStr", queryRoleIds);
        findMap.put("menuIsdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        //1. 根据角色ID-获取当前角色ID绑定的菜单
        List<Map<String, Object>> mapList = roleMenuService.findRoleMenuMapList(findMap);
        List<Menu> menuList = roleMenuService.mapList2MenuList(mapList, new ArrayList<Menu>());
        Integer maxLayer = menuService.findMaxLayerByMenuList(menuList);

        //3. 生成菜单树
        menuTreeService.initialization();
        menuTreeService.findMenuTreeByList(menuList, maxLayer);
        List<TreeEntity> treeList = menuTreeService.creatMenuTree(maxLayer, null, null);

        String treeJsonStr = YvanUtil.toJson(treeList);
        System.out.println("treeJsonStr: " + treeJsonStr);
        model.putResult(treeJsonStr);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/treeRoleMeunsSelected 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
        String roleIds = (String)pageData.get("roleIds");
        if (roleIds == null || roleIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("角色ID为空或空字符串！");
            return model;
        }

        String menuId = (String)pageData.get("menuId");
        if (menuId == null || menuId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("菜单ID为空或空字符串！");
            return model;
        }

        roleIds = StringUtil.stringTrimSpace(roleIds);
        roleIds = "'" + roleIds.replace(",", "','") + "'";
        String queryRoleIds = "b.role_id in (" +  roleIds + ")";

        PageData findMap = new PageData();
        findMap.put("queryRoleIds", queryRoleIds);
        findMap.put("menuId", menuId);

        List<Map<String, Object>> mapList = roleButtonService.listMenuButtonMapByRole(findMap);
        List<MenuButtonEntity> entityList = roleButtonService.roleButtonList2ButtonList(mapList, null);

        String treeJsonStr = YvanUtil.toJson(entityList);
        System.out.println("treeJsonStr: " + treeJsonStr);

        model.putResult(treeJsonStr);
        return model;
    }
    /**角色对应(已选的)菜单按钮列表
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/saveRoleMeunsButtons")
    public ResultModel saveRoleMeunsButtons() throws Exception {
        logger.info("################role/saveRoleMeunsButtons 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String roleID = (String)pageData.get("roleID");
        if (roleID == null || roleID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("角色id为空或空字符串！");
            return model;
        }

        String menuId = (String)pageData.get("menuId");
        if (menuId == null || menuId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("菜单id为空或空字符串！");
            return model;
        }

        //获取(菜单id,角色id)所有按钮id字符串-查询(vmes_role_button,vmes_menu_button)-菜单按钮表
        PageData findMap = new PageData();
        findMap.put("menuId", menuId);
        findMap.put("roleId", roleID);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<RoleButton> roleButtonList = roleButtonService.findRoleButtonList(findMap);
        String roleButtonIds = roleButtonService.findButtonIdsByRoleButtonList(roleButtonList);

        //3. 删除角色按钮(当前角色)
        if (roleButtonIds != null && roleButtonIds.trim().length() > 0) {
            findMap = new PageData();
            findMap.put("roleId", roleID);

            roleButtonIds = StringUtil.stringTrimSpace(roleButtonIds);
            String[] idArry = roleButtonIds.split(",");
            for (String buttonId : idArry) {
                try {
                    roleButtonService.deleteRoleButtonByButtonId(buttonId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //4. 添加角色按钮(当前角色)
        String buttonIds = (String)pageData.get("buttonIds");
        if (buttonIds != null && buttonIds.trim().length() > 0) {
            roleButtonService.addRoleButtonByMeunIds(roleID, buttonIds);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################role/saveRoleMeunsButtons 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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


    /**
     * 根据部门id获取全部待选用户
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/listAllUsersByDeptId")
    public ResultModel listAllUsersByDeptId() throws Exception{
        logger.info("################role/listAllUsersByDeptId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        Map<String, Object> mapObj = new HashMap<String, Object>();

        //1. 查询遍历List列表
        List<Column> columnList = columnService.findColumnList("userRole");
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
        mapObj.put("hideTitles", titlesHideList);
        mapObj.put("titles", titlesList);

        //2. 查询数据List
        PageData findMap = new PageData();
        PageData pageData = HttpUtils.parsePageData();

        String deptId = (String)pageData.get("deptId");
        if (deptId != null && deptId.trim().length() > 0) {
            String queryIdStr = departmentService.findDeptidById(deptId, null, "dept.");
            findMap.put("queryStr", queryIdStr);
        }

        String roleId = (String)pageData.get("roleId");
        if (roleId != null && roleId.trim().length() > 0) {
            String userIds = userRoleService.findUserIdsByByRoleID(roleId);
            if (userIds != null && userIds.trim().length() > 0) {
                userIds = StringUtil.stringTrimSpace(userIds);
                userIds = "'" + userIds.replace(",", "','") + "'";
                findMap.put("queryUserIdStr", "user.id not in (" + userIds + ")");
            }
        }

        findMap.put("userIsdisable", "1");
        //查询用户未绑定角色
        //findMap.put("queryIsBindRole", "userRole.role_id is null");
        //普通用户-外部用户
        String queryUserType = "user_type in ('69726efa45044117ac94a33ab2938ce4','028fb82cfbe341b1954834edfa2fc18d')";
        findMap.put("queryUserType", queryUserType);

        List<Map<String, String>> varMapList = new ArrayList<Map<String, String>>();
        List<Map<String, Object>> varList = userRoleService.listUserByRole(findMap);
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
        mapObj.put("varList", varMapList);

        model.putResult(mapObj);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/listAllUsersByDeptId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

        return model;
    }

    /**
     * 获取当前角色id已经绑定用户List
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/listUsersByRole")
    public ResultModel listUsersByRole() throws Exception{
        logger.info("################role/listUsersByRole 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        Map<String, Object> mapObj = new HashMap<String, Object>();

        //1. 查询遍历List列表
        List<Column> columnList = columnService.findColumnList("userRole");
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
        mapObj.put("hideTitles", titlesHideList);
        mapObj.put("titles", titlesList);

        //2. 分页查询数据List
        PageData pageData = HttpUtils.parsePageData();

        //角色id-已经绑定的用户ID
        PageData findMap = new PageData();
        String roleId = (String)pageData.get("roleId");
        findMap.put("roleId", roleId);

        //普通用户-外部用户
        String queryUserType = "user_type in ('69726efa45044117ac94a33ab2938ce4','028fb82cfbe341b1954834edfa2fc18d')";
        findMap.put("queryUserType", queryUserType);

        List<Map<String, String>> varMapList = new ArrayList<Map<String, String>>();
        List<Map<String, Object>> varList = userRoleService.listUserByRole(findMap);
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
        mapObj.put("varList", varMapList);

        model.putResult(mapObj);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/listUsersByRole 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

        return model;
    }


    /**
     * 获取当前角色id已经绑定用户List
     *
     * @author 陈刚
     * @date 2018-07-30
     */
    @PostMapping("/role/getRoles")
    public ResultModel getRoles() throws Exception{
        logger.info("################role/getRoles 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        List<Map> roleList = roleService.findDataList(pd);

        List<Map> options = new ArrayList<Map>();
        if(roleList!=null&&roleList.size()>0){
            for(int i=0;i<roleList.size();i++){
                Map role = roleList.get(i);
                if(role!=null){
                    Map option = new HashMap();
                    option.put("label",role.get("name"));
                    option.put("value",role.get("id"));
                    option.put("remark",role.get("remark"));
                    options.add(option);
                }

            }
        }
        Map result = new HashMap();
        result.put("options", options);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################role/getRoles 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

        return model;
    }

}



