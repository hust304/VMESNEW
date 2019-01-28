package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;



/**
* 说明：出库执行Controller
* @author 刘威 自动生成
* @date 2018-11-01
*/
@RestController
@Slf4j
public class WarehouseOutExecuteController {

    private Logger logger = LoggerFactory.getLogger(WarehouseOutExecuteController.class);

    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @GetMapping("/warehouse/warehouseOutExecute/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutExecute/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseOutExecute warehouseOutExecute = warehouseOutExecuteService.selectById(id);
        model.putResult(warehouseOutExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseOutExecute/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutExecute warehouseOutExecute = (WarehouseOutExecute)HttpUtils.pageData2Entity(pd, new WarehouseOutExecute());
        warehouseOutExecuteService.save(warehouseOutExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseOutExecute/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutExecute warehouseOutExecute = (WarehouseOutExecute)HttpUtils.pageData2Entity(pd, new WarehouseOutExecute());
        warehouseOutExecuteService.update(warehouseOutExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @GetMapping("/warehouse/warehouseOutExecute/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutExecute/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseOutExecuteService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseOutExecute/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        String ids = pd.getString("ids");
        if(StringUtils.isEmpty(ids)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }
        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        if(id_arry.length>0){
            warehouseOutExecuteService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseOutExecute/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseOutExecute> warehouseOutExecuteList = warehouseOutExecuteService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseOutExecuteList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseOutExecute/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseOutExecute> warehouseOutExecuteList = warehouseOutExecuteService.dataList(pd);
        model.putResult(warehouseOutExecuteList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * 出库编辑
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutExecute/updateWarehouseOutExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseOutExecute() throws Exception {
        logger.info("################/warehouseOutExecute/updateWarehouseOutExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.updateWarehouseOutExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutExecute/updateWarehouseOutExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 出库删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutExecute/deleteWarehouseOutExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseOutExecute() throws Exception {
        logger.info("################/warehouseOutExecute/deleteWarehouseOutExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.deleteWarehouseOutExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutExecute/deleteWarehouseOutExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * 出库执行
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutExecute/executeWarehouseOutExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseOutExecute() throws Exception {
        logger.info("################/warehouseOutExecute/executeWarehouseOutExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.executeWarehouseOutExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutExecute/executeWarehouseOutExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }






    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/listPageWarehouseOutExecutes")
    public ResultModel listPageWarehouseOutExecutes()  throws Exception {

        logger.info("################warehouseOutExecute/listPageWarehouseOutExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseOutExecuteService.listPageWarehouseOutExecutes(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/listPageWarehouseOutExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/exportExcelWarehouseOutExecutes")
    public void exportExcelWarehouseOutExecutes() throws Exception {
        logger.info("################warehouseOutExecute/exportExcelWarehouseOutExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseOutExecuteService.exportExcelWarehouseOutExecutes(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/exportExcelWarehouseOutExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/importExcelWarehouseOutExecutes")
    public ResultModel importExcelWarehouseOutExecutes(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseOutExecute/importExcelWarehouseOutExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseOutExecuteService.importExcelWarehouseOutExecutes(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/importExcelWarehouseOutExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



