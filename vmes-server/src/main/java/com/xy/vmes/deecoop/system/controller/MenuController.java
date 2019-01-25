package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Menu;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.*;
import com.yvan.*;
//import com.yvan.cache.RedisClient;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
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

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @GetMapping("/system/menu/selectById/{id}")
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
    @PostMapping("/system/menu/save")
    @Transactional(rollbackFor=Exception.class)
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
    @PostMapping("/system/menu/update")
    @Transactional(rollbackFor=Exception.class)
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
    @GetMapping("/system/menu/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
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
    @PostMapping("/system/menu/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################menu/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
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
    @PostMapping("/system/menu/dataList")
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
    @GetMapping("/system/menu/excelExport")
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
//    @Autowired
//    RedisClient redisClient;

    /**
     * 菜单列表分页
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/system/menu/listPageMenus")
    public ResultModel listPageMenus() throws Exception {
        logger.info("################menu/listPageMenus 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = menuService.listPageMenus(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/listPageMenus 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
    @GetMapping("/system/menu/exportExcelMenus")
    public void exportExcelMenus() throws Exception {
        logger.info("################menu/exportExcelMenus 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        //1. 获取Excel导出数据查询条件
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        menuService.exportExcelMenus(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/exportExcelMenus 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

    }

    /**
     * 新增菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/system/menu/addMenu")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addMenu() throws Exception {
        logger.info("################menu/addMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = menuService.addMenu(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/addMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/system/menu/updateMenu")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateMenu() throws Exception {
        logger.info("################menu/updateMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = menuService.updateMenu(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/updateMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**修改菜单(禁用)状态
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/system/menu/updateDisableMenu")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableMenu() throws Exception {
        logger.info("################menu/updateDisableMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = menuService.updateDisableMenu(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/updateDisableMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**删除菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/system/menu/deleteMenus")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteMenus() throws Exception {
        logger.info("################menu/deleteMenus 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = menuService.deleteMenus(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/deleteMenus 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 菜单Excel导入
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/system/menu/importExcelMenus")
    public ResultModel importExcelMenus(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################menu/importExcelMenus 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = menuService.importExcelMenus(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/importExcelMenus 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
    //@GetMapping("/system/menu/treeMeuns")
    @PostMapping("/system/menu/treeMeuns")
    public ResultModel treeMeuns()  throws Exception  {
        logger.info("################menu/treeMeuns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = menuService.treeMeuns(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/treeMeuns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



