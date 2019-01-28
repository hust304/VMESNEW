package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseMoveDetail;
import com.xy.vmes.entity.WarehouseMoveExecute;
import com.xy.vmes.entity.WarehouseMoveExecutor;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseMoveDetailService;
import com.xy.vmes.service.WarehouseMoveExecuteService;
import com.xy.vmes.service.WarehouseMoveExecutorService;
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
* 说明：移库单执行人Controller
* @author 刘威 自动生成
* @date 2018-11-16
*/
@RestController
@Slf4j
public class WarehouseMoveExecutorController {

    private Logger logger = LoggerFactory.getLogger(WarehouseMoveExecutorController.class);

    @Autowired
    private WarehouseMoveExecutorService warehouseMoveExecutorService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouse/warehouseMoveExecutor/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveExecutor/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseMoveExecutor warehouseMoveExecutor = warehouseMoveExecutorService.selectById(id);
        model.putResult(warehouseMoveExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecutor/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseMoveExecutor/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveExecutor warehouseMoveExecutor = (WarehouseMoveExecutor)HttpUtils.pageData2Entity(pd, new WarehouseMoveExecutor());
        warehouseMoveExecutorService.save(warehouseMoveExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecutor/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseMoveExecutor/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveExecutor warehouseMoveExecutor = (WarehouseMoveExecutor)HttpUtils.pageData2Entity(pd, new WarehouseMoveExecutor());
        warehouseMoveExecutorService.update(warehouseMoveExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouse/warehouseMoveExecutor/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveExecutor/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseMoveExecutorService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecutor/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseMoveExecutor/deleteByIds 执行开始 ################# ");
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
            warehouseMoveExecutorService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecutor/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseMoveExecutor/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseMoveExecutor> warehouseMoveExecutorList = warehouseMoveExecutorService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseMoveExecutorList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecutor/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseMoveExecutor/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseMoveExecutor> warehouseMoveExecutorList = warehouseMoveExecutorService.dataList(pd);
        model.putResult(warehouseMoveExecutorList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/





    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-11-01
     */
    @PostMapping("/warehouse/warehouseMoveExecutor/updateExecutor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateExecutor()  throws Exception {

        logger.info("################warehouseMoveExecutor/updateExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveExecutorService.updateExecutor(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/updateExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }






    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecutor/listPageWarehouseMoveExecutors")
    public ResultModel listPageWarehouseMoveExecutors()  throws Exception {

        logger.info("################warehouseMoveExecutor/listPageWarehouseMoveExecutors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseMoveExecutorService.listPageWarehouseMoveExecutors(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/listPageWarehouseMoveExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecutor/exportExcelWarehouseMoveExecutors")
    public void exportExcelWarehouseMoveExecutors() throws Exception {
        logger.info("################warehouseMoveExecutor/exportExcelWarehouseMoveExecutors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseMoveExecutorService.exportExcelWarehouseMoveExecutors(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/exportExcelWarehouseMoveExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecutor/importExcelWarehouseMoveExecutors")
    public ResultModel importExcelWarehouseMoveExecutors(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseMoveExecutor/importExcelWarehouseMoveExecutors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseMoveExecutorService.importExcelWarehouseMoveExecutors(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecutor/importExcelWarehouseMoveExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



