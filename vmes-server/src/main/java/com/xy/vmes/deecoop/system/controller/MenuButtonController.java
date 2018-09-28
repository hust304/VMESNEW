package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.MenuButtonService;
import com.xy.vmes.service.MenuService;
import com.xy.vmes.service.RoleButtonService;
import com.yvan.*;
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
* 说明：vmes_menu_button:菜单按钮表Controller
* @author 陈刚 自动生成
* @date 2018-08-03
*/
@RestController
@Slf4j
public class MenuButtonController {
    private Logger logger = LoggerFactory.getLogger(MenuButtonController.class);

    @Autowired
    private MenuButtonService menuButtonService;
    @Autowired
    private RoleButtonService roleButtonService;

    @Autowired
    private ColumnService columnService;
    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-03
    */
    @GetMapping("/button/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################button/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        MenuButton menuButton = menuButtonService.selectById(id);
        model.putResult(menuButton);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-03
    */
    @PostMapping("/button/save")
    public ResultModel save()  throws Exception {

        logger.info("################button/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        MenuButton menuButton = (MenuButton)HttpUtils.pageData2Entity(pd, new MenuButton());
        menuButtonService.save(menuButton);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-03
    */
    @PostMapping("/button/update")
    public ResultModel update()  throws Exception {

        logger.info("################button/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        MenuButton menuButton = (MenuButton)HttpUtils.pageData2Entity(pd, new MenuButton());
        menuButtonService.update(menuButton);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-03
    */
    @GetMapping("/button/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################button/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        menuButtonService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-03
    */
    @PostMapping("/button/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################button/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<MenuButton> menuButtonList = menuButtonService.dataListPage(pd,pg);
        model.putResult(menuButtonList);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-03
    */
    @PostMapping("/button/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################button/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<MenuButton> menuButtonList = menuButtonService.dataList(pd);
        model.putResult(menuButtonList);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-03
    */
    @GetMapping("/button/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################button/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = menuButtonService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                //List<Map> varList = menuButtonService.findDataList(pd);
                    //request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################button/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    @Autowired
    private MenuService menuService;

    /**
     * 新增按钮
     *
     * @author 陈刚
     * @date 2018-08-03
     */
    @PostMapping("/button/addMeunButton")
    public ResultModel addMeunButton() throws Exception {
        logger.info("################button/addMeunButton 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        MenuButton buttonObj = (MenuButton)HttpUtils.pageData2Entity(pageData, new MenuButton());
        if (buttonObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 按钮对象MenuButton 异常！");
            return model;
        }

        String msgStr = menuButtonService.checkColumnByAdd(buttonObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //menuId 获取菜单对象<Menu>
        Menu menuObj = menuService.findMenuById(buttonObj.getMenuId());
        if (menuObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(菜单ID:"+ buttonObj.getMenuId() + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (菜单)按钮名称-按钮属性值-不可重复
        StringBuffer msgBuf = new StringBuffer();
        if (menuButtonService.isExistByName(buttonObj.getMenuId(), null, buttonObj.getName())) {
            String msgTemp = "菜单名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "按钮名称: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String msgExist = MessageFormat.format(msgTemp,
                    menuObj.getName(),
                    buttonObj.getName());
            msgBuf.append(msgExist);
        }
        if (menuButtonService.isExistByNameEn(buttonObj.getMenuId(), null, buttonObj.getNameEn())) {
            String msgTemp = "菜单名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "按钮英文名: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String msgExist = MessageFormat.format(msgTemp,
                    menuObj.getName(),
                    buttonObj.getCode());
            msgBuf.append(msgExist);
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //设置按钮默认顺序
        if (buttonObj.getSerialNumber() == null) {
            Integer maxCount = menuButtonService.findMaxSerialNumber(buttonObj.getMenuId());
            buttonObj.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }

        //3. 添加(菜单)按钮
        menuButtonService.save(buttonObj);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/addMeunButton 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改按钮
     *
     * @author 陈刚
     * @date 2018-08-03
     */
    @PostMapping("/button/updateMeunButton")
    public ResultModel updateMeunButton() throws Exception {
        logger.info("################button/updateMeunButton 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        MenuButton buttonObj = (MenuButton)HttpUtils.pageData2Entity(pageData, new MenuButton());
        if (buttonObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 按钮对象MenuButton 异常！");
            return model;
        }

        String msgStr = menuButtonService.checkColumnByEdit(buttonObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //menuId 获取菜单对象<Menu>
        Menu menuObj = menuService.findMenuById(buttonObj.getMenuId());
        if (menuObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(菜单ID:"+ buttonObj.getMenuId() + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (菜单)按钮名称-按钮属性值-不可重复
        StringBuffer msgBuf = new StringBuffer();
        if (menuButtonService.isExistByName(buttonObj.getMenuId(), buttonObj.getId(), buttonObj.getName())) {
            String msgTemp = "菜单名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "按钮名称: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String msgExist = MessageFormat.format(msgTemp,
                    menuObj.getName(),
                    buttonObj.getName());
            msgBuf.append(msgExist);
        }
        if (menuButtonService.isExistByNameEn(buttonObj.getMenuId(), buttonObj.getId(), buttonObj.getNameEn())) {
            String msgTemp = "菜单名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "按钮英文名: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String msgExist = MessageFormat.format(msgTemp,
                    menuObj.getName(),
                    buttonObj.getCode());
            msgBuf.append(msgExist);
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        MenuButton objectDB = menuButtonService.findMenuButtonById(buttonObj.getId());
        objectDB = menuButtonService.object2objectDB(buttonObj, objectDB);

        //设置按钮默认顺序
        if (buttonObj.getSerialNumber() == null) {
            Integer maxCount = menuButtonService.findMaxSerialNumber(buttonObj.getMenuId());
            objectDB.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }

        //修改(菜单)按钮
        menuButtonService.update(objectDB);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/updateMeunButton 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**修改按钮(禁用)状态
     *
     * @author 陈刚
     * @date 2018-08-03
     */
    @PostMapping("/button/updateDisableMeunButton")
    public ResultModel updateDisableMeunButton() throws Exception {
        logger.info("################button/updateDisableMeunButton 执行开始 ################# ");
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

        //2. 修改按钮(禁用)状态
        MenuButton objectDB = menuButtonService.findMenuButtonById(id);
        objectDB.setIsdisable(isdisable);
        objectDB.setUdate(new Date());
        menuButtonService.update(objectDB);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/updateDisableMeunButton 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除按钮
     *
     * @author 陈刚
     * @date 2018-08-03
     */
    @PostMapping("/button/deleteMeunButtons")
    public ResultModel deleteMeunButtons() throws Exception {
        logger.info("################button/deleteMeunButtons 执行开始 ################# ");
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

//        //启用状态改为(禁用)-禁用执行物理删除
//        String id_str = StringUtil.stringTrimSpace(ids);
//        List<MenuButton> objectList = menuButtonService.findMenuButtonListByIds(id_str);
//        Map<String, String> mapObj = menuButtonService.checkDeleteMenuButtonByList(objectList);
//
//        String updateIds = mapObj.get("updateDisableIds");
//        if (updateIds != null && updateIds.trim().length() > 0) {
//            String[] id_arry = updateIds.split(",");
//            try {
//                menuButtonService.updateToDisableByIds(id_arry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        String deleteIds = mapObj.get("deleteIds");
//        if (deleteIds != null && deleteIds.trim().length() > 0) {
//            String[] id_arry = deleteIds.split(",");
//            try {
//                menuButtonService.deleteByIds(id_arry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");


        for (int i = 0; i < id_arry.length; i++) {
            String menuButtonId = id_arry[i];
            //1. 删除(vmes_role_button)菜单按钮表
            roleButtonService.deleteRoleButtonByButtonId(menuButtonId);
        }

        //2. 删除(vmes_menu_button)菜单按钮表
        menuButtonService.deleteByIds(id_arry);

        Long endTime = System.currentTimeMillis();
        logger.info("################button/deleteMeunButtons 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 菜单按钮列表分页
     *
     * @author 陈刚
     * @date 2018-08-08
     */
    @PostMapping("/button/listPageMenuButtons")
    public ResultModel listPageMenuButtons() throws Exception {
        logger.info("################button/listPageMenuButtons 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        Map<String, Object> mapObj = new HashMap<String, Object>();

        List<Column> columnList = columnService.findColumnList("button");
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
        mapObj.put("titles", YvanUtil.toJson(titlesList));

        //2. 分页查询数据List
        List<Map<String, String>> varMapList = new ArrayList<Map<String, String>>();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varList = menuButtonService.getDataListPage(pd, pg);
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
        logger.info("################button/listPageMenuButtons 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
    @PostMapping("/button/exportExcelMenuButtons")
    public void exportExcelMenuButtons() throws Exception {
        logger.info("################button/exportExcelMenuButtons 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        //1. 获取Excel导出数据查询条件
        PageData pd = HttpUtils.parsePageData();
        String ids = pd.getString("ids");
        String queryColumn = pd.getString("queryColumn");
        List<Column> columnList = columnService.findColumnList("button");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //3. 根据查询条件获取业务数据List
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        if (queryColumn != null && queryColumn.trim().length() > 0) {
            queryStr = queryStr + queryColumn;
        }

        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        //分页参数默认设置100000
        pg.setSize(100000);

        List<Map> dataList = menuButtonService.getDataListPage(pd,pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response  = HttpUtils.currentResponse();


        //查询数据-Excel文件导出
        //String fileName = "Excel数据字典数据导出";
        String fileName = "ExcelMenuButton";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/exportExcelMenuButtons 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * 根据(菜单Key,登录用户角色id)获取菜单按钮List
     *
     * @author 陈刚
     * @date 2018-09-14
     */
    @PostMapping("/button/initMenuButtons")
    public ResultModel initMenuButtons() throws Exception {
        logger.info("################button/initMenuButtons 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String menuKey = pageData.getString("menuKey");
        if (menuKey == null || menuKey.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("菜单Key为空或空字符串！");
            return model;
        }

//        //常理类(com.xy.vmes.common.util.Common.SYS_MENU_MAP)中定义Map<菜单key, 菜单id>
//        if (Common.SYS_MENU_MAP.get(menuKey) == null || Common.SYS_MENU_MAP.get(menuKey).trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("菜单Key:" + menuKey + " 常理类Common.SYS_MENU_MAP 无定义！");
//            return model;
//        }

        List<MenuButtonEntity> buttonList = new ArrayList<MenuButtonEntity>();
        String roleIds = pageData.getString("roleId");
        if (roleIds != null && roleIds.trim().length() > 0) {
            //1. 根据角色id查询(vmes_role_button)-角色按钮表
            PageData findMap = new PageData();
            roleIds = StringUtil.stringTrimSpace(roleIds);
            roleIds = "'" + roleIds.replace(",", "','") + "'";
            findMap.put("queryStr", "role_id in (" + roleIds + ")");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            List<RoleButton> roleButtonList = new ArrayList<RoleButton>();
            roleButtonList = roleButtonService.findRoleButtonList(findMap);
            if (roleButtonList == null || roleButtonList.size() == 0) {
                model.put("buttonList", buttonList);
                return model;
            }

            //2. 遍历List<RoleButton>-获取按钮id字符串
            String buttonIds = "";
            if (roleButtonList.size() > 0) {
                buttonIds = roleButtonService.findButtonIdsByRoleButtonList(roleButtonList);
            }
            if (buttonIds.trim().length() == 0) {
                model.put("buttonList", buttonList);
                return model;
            }

            //3. (菜单id, 按钮id)-查询(vmes_menu_button)-菜单按钮表
            findMap = new PageData();
            findMap.put("menuId", menuKey);
            //是否禁用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            if (buttonIds.trim().length() > 0) {
                buttonIds = StringUtil.stringTrimSpace(buttonIds);
                buttonIds = "'" + buttonIds.replace(",", "','") + "'";
                findMap.put("queryStr", "id in (" + buttonIds + ")");
            }
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            List<MenuButton> menuButtonList = menuButtonService.findMenuButtonList(findMap);

            //4. 遍历List<MenuButton> 得到按钮List<MenuButtonEntity>
            if (menuButtonList != null && menuButtonList.size() > 0) {
                for (MenuButton menuButton : menuButtonList) {
                    MenuButtonEntity buttonEntity = roleButtonService.menuButton2ButtonsEntity(menuButton, null);
                    buttonList.add(buttonEntity);
                }
            }
        }

        model.put("buttonList", buttonList);
        Long endTime = System.currentTimeMillis();
        logger.info("################button/initMenuButtons 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}

