package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Menu;
import com.xy.vmes.entity.MenuButton;
import com.xy.vmes.service.MenuButtonService;
import com.xy.vmes.service.MenuService;
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
import java.io.PrintWriter;
import java.io.StringWriter;
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
        Pagination pg = HttpUtils.parsePagination();
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
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
            return model;
        }

        MenuButton buttonObj = (MenuButton)HttpUtils.pageData2Entity(pageData, new MenuButton());
        if (buttonObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 按钮对象MenuButton 异常！");
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
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
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
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
        if (menuButtonService.isExistByCode(buttonObj.getMenuId(), null, buttonObj.getCode())) {
            String msgTemp = "菜单名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "按钮属性值: {1}" + Common.SYS_ENDLINE_DEFAULT +
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
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
            return model;
        }

        MenuButton buttonObj = (MenuButton)HttpUtils.pageData2Entity(pageData, new MenuButton());
        if (buttonObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 按钮对象MenuButton 异常！");
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
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
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
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
        if (menuButtonService.isExistByCode(buttonObj.getMenuId(), buttonObj.getId(), buttonObj.getCode())) {
            String msgTemp = "菜单名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "按钮属性值: {1}" + Common.SYS_ENDLINE_DEFAULT +
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

        return model;
    }

    /**修改按钮(禁用)状态
     *
     * @author 陈刚
     * @date 2018-08-03
     */
    @PostMapping("/button/updateDisableMeunButton")
    public ResultModel updateDisableMeunButton() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
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

        return model;
    }

    /**
     * 删除按钮
     *
     * @author 陈刚
     * @date 2018-08-03
     */
    @PostMapping("/button/deleteMeunButtons")
    public ResultModel deleteMeunButtons() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
            return model;
        }

        String ids = (String)pageData.get("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            model.putMsg(Common.SYS_ENDLINE_DEFAULT);
            return model;
        }

        //启用状态改为(禁用)-禁用执行物理删除
        String id_str = StringUtil.stringTrimSpace(ids);
        List<MenuButton> objectList = menuButtonService.findMenuButtonListByIds(id_str);
        Map<String, String> mapObj = menuButtonService.checkDeleteMenuButtonByList(objectList);

        String updateIds = mapObj.get("updateDisableIds");
        if (updateIds != null && updateIds.trim().length() > 0) {
            String[] id_arry = updateIds.split(",");
            try {
                menuButtonService.updateToDisableByIds(id_arry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String deleteIds = mapObj.get("deleteIds");
        if (deleteIds != null && deleteIds.trim().length() > 0) {
            String[] id_arry = deleteIds.split(",");
            try {
                menuButtonService.deleteByIds(id_arry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
        ResultModel model = new ResultModel();
        Map<String, Object> mapObj = new HashMap<String, Object>();

        //1. 查询遍历List列表
        List<LinkedHashMap<String, String>> titleOutList = new ArrayList<LinkedHashMap<String, String>>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        List<LinkedHashMap<String, String>> titleList = menuButtonService.getColumnList();
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
        mapObj.put("hideTitles", titlesHideList);
        mapObj.put("titles", YvanUtil.toJson(titleOutList));

        //2. 分页查询数据List
        List<Map<String, String>> varMapList = new ArrayList<Map<String, String>>();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        List<Map<String, Object>> varList = menuButtonService.getDataListPage(pd, pg);
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
        return model;
    }
}

