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
* 说明：移库单明细Controller
* @author 刘威 自动生成
* @date 2018-11-16
*/
@RestController
@Slf4j
public class WarehouseMoveDetailController {

    private Logger logger = LoggerFactory.getLogger(WarehouseMoveDetailController.class);

    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouse/warehouseMoveDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseMoveDetail warehouseMoveDetail = warehouseMoveDetailService.selectById(id);
        model.putResult(warehouseMoveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveDetail/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseMoveDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveDetail warehouseMoveDetail = (WarehouseMoveDetail)HttpUtils.pageData2Entity(pd, new WarehouseMoveDetail());
        warehouseMoveDetailService.save(warehouseMoveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveDetail/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseMoveDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveDetail warehouseMoveDetail = (WarehouseMoveDetail)HttpUtils.pageData2Entity(pd, new WarehouseMoveDetail());
        warehouseMoveDetailService.update(warehouseMoveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouse/warehouseMoveDetail/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseMoveDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveDetail/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseMoveDetail/deleteByIds 执行开始 ################# ");
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
            warehouseMoveDetailService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveDetail/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseMoveDetail/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseMoveDetail> warehouseMoveDetailList = warehouseMoveDetailService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseMoveDetailList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveDetail/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseMoveDetail/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseMoveDetail> warehouseMoveDetailList = warehouseMoveDetailService.dataList(pd);
        model.putResult(warehouseMoveDetailList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/





    /**
     * 出库单明细退单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveDetail/rebackWarehouseMoveDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseMoveDetail() throws Exception {
        logger.info("################/warehouseMoveDetail/rebackWarehouseMoveDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveDetailService.rebackWarehouseMoveDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveDetail/rebackWarehouseMoveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 删除移库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveDetail/deleteWarehouseMoveDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseMoveDetail() throws Exception {
        logger.info("################/warehouseMoveDetail/deleteWarehouseMoveDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveDetailService.deleteWarehouseMoveDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveDetail/deleteWarehouseMoveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 取消移库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveDetail/cancelWarehouseMoveDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseMoveDetail() throws Exception {
        logger.info("################/warehouseMoveDetail/cancelWarehouseMoveDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveDetailService.cancelWarehouseMoveDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveDetail/cancelWarehouseMoveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 恢复移库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveDetail/recoveryWarehouseMoveDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseMoveDetail() throws Exception {
        logger.info("################/warehouseMoveDetail/recoveryWarehouseMoveDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveDetailService.recoveryWarehouseMoveDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveDetail/recoveryWarehouseMoveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }






    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouse/warehouseMoveDetail/listPageWarehouseMoveDetailsExecute")
    public ResultModel listPageWarehouseMoveDetailsExecute()  throws Exception {

        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetailsExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseMoveDetailService.listPageWarehouseMoveDetailsExecute(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetailsExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouse/warehouseMoveDetail/listPageWarehouseMoveDetailsRecords")
    public ResultModel listPageWarehouseMoveDetailsRecords()  throws Exception {

        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetailsRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseMoveDetailService.listPageWarehouseMoveDetailsRecords(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetailsRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }






    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveDetail/listPageWarehouseMoveDetails")
    public ResultModel listPageWarehouseMoveDetails()  throws Exception {

        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseMoveDetailService.listPageWarehouseMoveDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveDetail/exportExcelWarehouseMoveDetails")
    public void exportExcelWarehouseMoveDetails() throws Exception {
        logger.info("################warehouseMoveDetail/exportExcelWarehouseMoveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseMoveDetailService.exportExcelWarehouseMoveDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/exportExcelWarehouseMoveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveDetail/importExcelWarehouseMoveDetails")
    public ResultModel importExcelWarehouseMoveDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseMoveDetail/importExcelWarehouseMoveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseMoveDetailService.importExcelWarehouseMoveDetails(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/importExcelWarehouseMoveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



