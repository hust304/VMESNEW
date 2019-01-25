package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.*;
import com.xy.vmes.entity.*;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.DictionaryService;
import com.xy.vmes.service.UserService;
import com.yvan.*;
import com.yvan.cache.RedisClient;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：数据字典Controller
* @author 刘威 自动生成
* @date 2018-07-31
*/
@RestController
@Slf4j
public class DictionaryController {

    private Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisClient redisClient;

    @Autowired
    private ColumnService columnService;
    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/system/dictionary/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################dictionary/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Dictionary dictionary = dictionaryService.selectById(id);
        model.putResult(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/system/dictionary/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################dictionary/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());
        dictionaryService.save(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/systemdictionary/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################dictionary/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());
        dictionaryService.update(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/system/dictionary/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################dictionary/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        dictionaryService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/system/dictionary/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################dictionary/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Dictionary> dictionaryList = dictionaryService.dataListPage(pd,pg);
        model.putResult(dictionaryList);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/system/dictionary/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################dictionary/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Dictionary> dictionaryList = dictionaryService.dataList(pd);
        model.putResult(dictionaryList);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/system/dictionary/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################dictionary/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = dictionaryService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                //List<Map> varList = dictionaryService.findDataList(pd);
                //request.setAttribute("varList", varList);
            }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/addDictionary")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addDictionary()  throws Exception {
        logger.info("################dictionary/addDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.addDictionary(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/addDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/updateDictionary")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDictionary()  throws Exception {
        logger.info("################dictionary/updateDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.updateDictionary(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/updateDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**修改组织架构(禁用)状态
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/system/dictionary/updateDisableDictionary")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableDictionary() throws Exception {
        logger.info("################dictionary/updateDisableDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.updateDisableDictionary(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/dictionary/updateDisableDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/deleteDictionarys")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteDictionarys()  throws Exception {
        logger.info("################dictionary/deleteDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.deleteDictionarys(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/deleteDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/listPageDictionarys")
    public ResultModel listPageDictionarys()  throws Exception {

        logger.info("################dictionary/listPageDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = dictionaryService.listPageDictionarys(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/listPageDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-08-01
     */
//    @GetMapping("/system/dictionary/exportExcelDictionarys")
//    public void exportExcelDictionarys()  throws Exception {
//
//        logger.info("################dictionary/exportExcelDictionarys 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        HttpServletResponse response  = HttpUtils.currentResponse();
//        HttpServletRequest request  = HttpUtils.currentRequest();
//
//        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
//            @Override
//            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
//                // TODO Auto-generated method stub
//                PageData pd = HttpUtils.parsePageData();
//                List<LinkedHashMap> titles = dictionaryService.getColumnList();
//                request.setAttribute("titles", titles.get(0));
//                List<Map> varList = dictionaryService.getDataList(pd);
//                request.setAttribute("varList", varList);
//            }
//        });
//        Long endTime = System.currentTimeMillis();
//        logger.info("################dictionary/exportExcelDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }

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
    @PostMapping("/system/dictionary/exportExcelDictionarys")
    public void exportExcelDictionarys() throws Exception {
        logger.info("################dictionary/exportExcelDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        dictionaryService.exportExcelDictionarys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/exportExcelDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/treeDictionarys")
    public ResultModel treeDictionarys()  throws Exception {
        logger.info("################dictionary/treeDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.treeDictionarys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/treeDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/getDictionarys")
    public ResultModel getDictionarys()  throws Exception {
        logger.info("################dictionary/getDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.getDictionarys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/getDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/dataListDictionarys")
    public ResultModel dataListDictionarys()  throws Exception {

        logger.info("################dictionary/dataListDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.dataListDictionarys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataListDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



