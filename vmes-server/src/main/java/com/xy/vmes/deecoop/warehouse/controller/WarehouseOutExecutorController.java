package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseOutExecute;
import com.xy.vmes.entity.WarehouseOutExecutor;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseOutExecuteService;
import com.xy.vmes.service.WarehouseOutExecutorService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
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
import java.util.*;



/**
* 说明：出库执行人Controller
* @author 刘威 自动生成
* @date 2018-11-01
*/
@RestController
@Slf4j
public class WarehouseOutExecutorController {

    private Logger logger = LoggerFactory.getLogger(WarehouseOutExecutorController.class);

    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @GetMapping("/warehouse/warehouseOutExecutor/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutExecutor/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseOutExecutor warehouseOutExecutor = warehouseOutExecutorService.selectById(id);
        model.putResult(warehouseOutExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecutor/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseOutExecutor/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutExecutor warehouseOutExecutor = (WarehouseOutExecutor)HttpUtils.pageData2Entity(pd, new WarehouseOutExecutor());
        warehouseOutExecutorService.save(warehouseOutExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecutor/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseOutExecutor/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutExecutor warehouseOutExecutor = (WarehouseOutExecutor)HttpUtils.pageData2Entity(pd, new WarehouseOutExecutor());
        warehouseOutExecutorService.update(warehouseOutExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @GetMapping("/warehouse/warehouseOutExecutor/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutExecutor/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseOutExecutorService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecutor/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseOutExecutor/deleteByIds 执行开始 ################# ");
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
            warehouseOutExecutorService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecutor/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseOutExecutor/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseOutExecutorList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecutor/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseOutExecutor/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.dataList(pd);
        model.putResult(warehouseOutExecutorList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/





    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-11-01
     */
    @PostMapping("/warehouse/warehouseOutExecutor/updateExecutor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateExecutor()  throws Exception {

        logger.info("################warehouseOutExecutor/updateExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecutorService.updateExecutor(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/updateExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecutor/listPageWarehouseOutExecutors")
    public ResultModel listPageWarehouseOutExecutors()  throws Exception {

        logger.info("################warehouseOutExecutor/listPageWarehouseOutExecutors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseOutExecutorService.listPageWarehouseOutExecutors(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/listPageWarehouseOutExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



