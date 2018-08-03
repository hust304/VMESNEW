package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.RedisUtils;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Menu;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.MenuService;
import com.xy.vmes.service.MenuTreeService;
import com.xy.vmes.service.RoleMenuService;
import com.yvan.*;
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
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：vmes_menu:系统功能菜单Controller
* @author 陈刚 自动生成
* @date 2018-08-01
*/
@RestController
@Slf4j
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private MenuTreeService menuTreeService;

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @GetMapping("/menu/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################menu/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Menu menu = menuService.selectById(id);
        model.putResult(menu);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @PostMapping("/menu/save")
    public ResultModel save()  throws Exception {

        logger.info("################menu/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Menu menu = (Menu)HttpUtils.pageData2Entity(pd, new Menu());
        menuService.save(menu);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @PostMapping("/menu/update")
    public ResultModel update()  throws Exception {

        logger.info("################menu/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Menu menu = (Menu)HttpUtils.pageData2Entity(pd, new Menu());
        menuService.update(menu);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @GetMapping("/menu/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################menu/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        menuService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @PostMapping("/menu/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################menu/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        List<Menu> menuList = menuService.dataListPage(pd,pg);
        model.putResult(menuList);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @PostMapping("/menu/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################menu/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Menu> menuList = menuService.dataList(pd);
        model.putResult(menuList);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @GetMapping("/menu/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################menu/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = menuService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                //List<Map> varList = menuService.findDataList(pd);
                    //request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    @Autowired
    RedisClient redisClient;

    /**
     * 菜单列表分页
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/listPageMenus")
    public ResultModel listPageMenus() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {

        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**
     * 新增菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/addMenu")
    public ResultModel addMenu() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        Menu menuObj = (Menu)HttpUtils.pageData2Entity(pageData, new Menu());
        if (menuObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 菜单对象Menu 异常！</br>");
            return model;
        }

        String msgStr = menuService.checkColumnByAdd(menuObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Menu>
        Menu paterObj = menuService.findMenuById(menuObj.getPid());
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(pid:"+ menuObj.getPid() + ")系统中无数据，请与管理员联系！</br>");
            return model;
        }

        //2. (菜单名称)在同一层名称不可重复
        if (menuService.isExistByName(menuObj.getPid(), null, menuObj.getName())) {
            String msgTemp = "上级菜单名称: {0}<br/>菜单名称: {1}<br/>在系统中已经重复！</br>";
            String str_isnull = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    menuObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        try {
            String id = Conv.createUuid();
            menuObj.setId(id);
            menuObj = menuService.id2MenuByLayer(id,
                    Integer.valueOf(paterObj.getLayer().intValue() + 1),
                    menuObj);
            menuObj = menuService.paterObject2ObjectDB(paterObj, menuObj);

            //获取菜单编码
            String code = menuService.createCoder("1");
            menuObj.setCode(code);

            //设置菜单级别
            menuObj.setLayer(Integer.valueOf(paterObj.getLayer().intValue() + 1));

            menuService.save(menuObj);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**
     * 修改菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/updateMenu")
    public ResultModel updateMenu() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        Menu menuObj = (Menu)HttpUtils.pageData2Entity(pageData, new Menu());
        if (menuObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 菜单对象Menu 异常！</br>");
            return model;
        }

        String msgStr = menuService.checkColumnByEdit(menuObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Menu>
        Menu paterObj = menuService.findMenuById(menuObj.getPid());
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(pid:"+ menuObj.getPid() + ")系统中无数据，请与管理员联系！</br>");
            return model;
        }

        //2. (菜单名称)在同一层名称不可重复
        if (menuService.isExistByName(menuObj.getPid(), menuObj.getId(), menuObj.getName())) {
            String msgTemp = "上级菜单名称: {0}<br/>菜单名称: {1}<br/>在系统中已经重复！</br>";
            msgTemp = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    menuObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgTemp);
            return model;
        }

        try {
            Menu menuDB = menuService.findMenuById(menuObj.getId());
            menuDB = menuService.object2objectDB(menuObj, menuDB);
            menuDB = menuService.clearMenuByPath(menuDB);
            menuDB = menuService.id2MenuByLayer(menuDB.getId(),
                    Integer.valueOf(paterObj.getLayer().intValue() + 1),
                    menuDB);
            menuDB = menuService.paterObject2ObjectDB(paterObj, menuDB);

            //设置菜单级别
            menuDB.setLayer(Integer.valueOf(paterObj.getLayer().intValue() + 1));
            menuService.update(menuDB);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**修改菜单(禁用)状态
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/department/updateMenuDisable")
    public ResultModel updateMenuDisable() {
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

        //2. 当前菜单ID(菜单按钮)中是否使用中
        msgStr = menuService.checkDeleteMenuByIds(id);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        try {
            Menu objectDB = menuService.findMenuById(id);
            objectDB.setIsdisable(isdisable);
            objectDB.setUdate(new Date());
            menuService.update(objectDB);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**删除菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/department/deleteMenus")
    public ResultModel deleteMenus() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String menuIds = (String)pageData.get("menuIds");
        if (menuIds == null || menuIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！</br>");
            return model;
        }

        String id_str = StringUtil.stringTrimSpace(menuIds);
        String[] id_arry = id_str.split(",");

        //2. 当前菜单ID(菜单按钮)中是否使用中
        String msgStr = menuService.checkDeleteMenuByIds(id_str);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        try {
            menuService.updateDisableByIds(id_arry);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**
     * 菜单Excel导出
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/exportExcelMenus")
    public ResultModel exportExcelMenus() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {

        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**
     * 菜单Excel导入
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/importExcelMenus")
    public ResultModel importExcelMenus() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {

        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**
     * 菜单树
     * 1. 从Redis缓存中获取-当前用户(角色ID)-','逗号分隔的字符串
     * 2. (角色ID字符串)-获取菜单List<Meun>
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/treeMeuns")
    public ResultModel treeMeuns() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        try {
            String sessionID = HttpUtils.currentRequest().getHeader("sessionID");
            if (sessionID == null || sessionID.trim().length() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("(sessionID)为空或空字符串，请于管理员联系！");
                return model;
            }

            //用户角色(当前用户)-(角色ID','分隔的字符串)
            String userRole = "";
            try {
                userRole = RedisUtils.getUserRoleInfoBySessionID(redisClient, sessionID);
            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
            if (userRole.trim().length() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("当前用户无配置角色(用户角色)，请于管理员联系！");
                return model;
            }

            //String userRole = "ce6fd6bdfa0f42798007a1ec5fe84717";  //测试数据-真实环境无此代码
            userRole = StringUtil.stringTrimSpace(userRole);

            String queryStr = "";
            if (userRole != null && userRole.trim().length() > 0) {
                String strTemp = "'" + userRole.replace(",", "','" + ",") + "'";
                queryStr = "a.role_id in (" + strTemp + ")";
            }
            PageData findMap = new PageData();
            findMap.put("isdisable", "0");
            findMap.put("menuIsdisable", "0");
            findMap.put("queryStr", queryStr);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));

            List<Map<String, Object>> mapList = roleMenuService.findRoleMenuMapList(findMap);
            List<Menu> menuList = roleMenuService.mapList2MenuList(mapList, new ArrayList<Menu>());
            //遍历菜单List<Menu>-获取菜单最大级别
            Integer maxLayer = menuService.findMaxLayerByMenuList(menuList);

            menuTreeService.initialization();
            menuTreeService.findMenuTreeByList(menuList, maxLayer);
            List<TreeEntity> treeList = menuTreeService.creatMenuTree(maxLayer, null, null);

            String treeJsonStr = YvanUtil.toJson(treeList);
            //System.out.println("treeJsonStr: " + treeJsonStr);
            model.putResult(treeJsonStr);

        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }


}



