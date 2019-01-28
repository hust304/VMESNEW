package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;



/**
* 说明：出库明细Controller
* @author 刘威 自动生成
* @date 2018-10-23
*/
@RestController
@Slf4j
public class WarehouseOutDetailController {

    private Logger logger = LoggerFactory.getLogger(WarehouseOutDetailController.class);

    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @GetMapping("/warehouse/warehouseOutDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseOutDetail warehouseOutDetail = warehouseOutDetailService.selectById(id);
        model.putResult(warehouseOutDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouse/warehouseOutDetail/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseOutDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutDetail warehouseOutDetail = (WarehouseOutDetail)HttpUtils.pageData2Entity(pd, new WarehouseOutDetail());
        warehouseOutDetailService.save(warehouseOutDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouse/warehouseOutDetail/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseOutDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutDetail warehouseOutDetail = (WarehouseOutDetail)HttpUtils.pageData2Entity(pd, new WarehouseOutDetail());
        warehouseOutDetailService.update(warehouseOutDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @GetMapping("/warehouse/warehouseOutDetail/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseOutDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouse/warehouseOutDetail/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseOutDetail/deleteByIds 执行开始 ################# ");
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
            warehouseOutDetailService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouse/warehouseOutDetail/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseOutDetail/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseOutDetail> warehouseOutDetailList = warehouseOutDetailService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseOutDetailList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouse/warehouseOutDetail/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseOutDetail/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseOutDetail> warehouseOutDetailList = warehouseOutDetailService.dataList(pd);
        model.putResult(warehouseOutDetailList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/





    /**
     * 出库单明细退单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutDetail/rebackWarehouseOutDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/rebackWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutDetailService.rebackWarehouseOutDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/rebackWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }











    /**
     * 出库单明细派单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutDetail/dispatchWarehouseOutDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel dispatchWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/dispatchWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutDetailService.dispatchWarehouseOutDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/dispatchWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }





    /**
     * 恢复出库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutDetail/recoveryWarehouseOutDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/recoveryWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutDetailService.recoveryWarehouseOutDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/recoveryWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消出库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutDetail/cancelWarehouseOutDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/cancelWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutDetailService.cancelWarehouseOutDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/cancelWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除出库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutDetail/deleteWarehouseOutDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/deleteWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutDetailService.deleteWarehouseOutDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/deleteWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }







    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouse/warehouseOutDetail/listPageWarehouseOutDetails")
    public ResultModel listPageWarehouseOutDetails()  throws Exception {

        logger.info("################warehouseOutDetail/listPageWarehouseOutDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseOutDetailService.listPageWarehouseOutDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/listPageWarehouseOutDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }





    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouse/warehouseOutDetail/listPageWarehouseOutDetailsOutRecords")
    public ResultModel listPageWarehouseOutDetailsOutRecords()  throws Exception {

        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsOutRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseOutDetailService.listPageWarehouseOutDetailsOutRecords(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsOutRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouse/warehouseOutDetail/listPageWarehouseOutDetailsExecute")
    public ResultModel listPageWarehouseOutDetailsExecute()  throws Exception {

        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseOutDetailService.listPageWarehouseOutDetailsExecute(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }





    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouse/warehouseOutDetail/listPageWarehouseOutDetailsDispatch")
    public ResultModel listPageWarehouseOutDetailsDispatch()  throws Exception {

        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsDispatch 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseOutDetailService.listPageWarehouseOutDetailsDispatch(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsDispatch 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouse/warehouseOutDetail/exportExcelWarehouseOutDetails")
    public void exportExcelWarehouseOutDetails() throws Exception {
        logger.info("################warehouseOutDetail/exportExcelWarehouseOutDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseOutDetailService.exportExcelWarehouseOutDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/exportExcelWarehouseOutDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouse/warehouseOutDetail/importExcelWarehouseOutDetails")
    public ResultModel importExcelWarehouseOutDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseOutDetail/importExcelWarehouseOutDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseOutDetailService.importExcelWarehouseOutDetails(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/importExcelWarehouseOutDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



