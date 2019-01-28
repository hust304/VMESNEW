package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.*;
import com.yvan.*;
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
* 说明：vmes_warehouse_in:仓库入库单Controller
* @author 陈刚 自动生成
* @date 2018-10-16
*/
@RestController
@Slf4j
public class WarehouseInController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouse/warehouseIn/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseIn/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseIn warehouseIn = (WarehouseIn)HttpUtils.pageData2Entity(pd, new WarehouseIn());
        warehouseInService.save(warehouseIn);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouse/warehouseIn/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseIn/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseIn warehouseIn = (WarehouseIn)HttpUtils.pageData2Entity(pd, new WarehouseIn());
        warehouseInService.update(warehouseIn);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @GetMapping("/warehouse/warehouseIn/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseIn/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseInService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouse/warehouseIn/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseIn/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
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
            warehouseInService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouse/warehouseIn/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseIn/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseIn> warehouseInList = warehouseInService.dataList(pd);
        model.putResult(warehouseInList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouse/warehouseIn/listPageWarehouseIn")
    public ResultModel listPageWarehouseIn() throws Exception {
        logger.info("################warehouseIn/listPageWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInService.listPageWarehouseIn(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/listPageWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseIn/addWarehouseIn")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/addWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInService.addWarehouseIn(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/addWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库单
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseIn/updateWarehouseIn")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/updateWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInService.updateWarehouseIn(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/updateWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消入库单(取消整个入库单-入库单明细)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseIn/cancelWarehouseIn")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/cancelWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInService.cancelWarehouseIn(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/cancelWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复入库单(恢复整个入库单-入库单明细)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseIn/recoveryWarehouseIn")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/recoveryWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInService.recoveryWarehouseIn(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/recoveryWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库单
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseIn/deleteWarehouseIn")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/deleteWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInService.deleteWarehouseIn(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/deleteWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouse/warehouseIn/exportExcelWarehouseIns")
    public void exportExcelWarehouseIn() throws Exception {
        logger.info("################warehouseIn/exportExcelWarehouseIns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseInService.exportExcelWarehouseIn(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/exportExcelWarehouseIns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouse/warehouseIn/importExcelWarehouseIns")
    public ResultModel importExcelWarehouseIn(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseIn/importExcelWarehouseIns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseInService.importExcelWarehouseIn(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/importExcelWarehouseIns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



