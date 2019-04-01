package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
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
* 说明：移库单Controller
* @author 刘威 自动生成
* @date 2018-11-16
*/
@RestController
@Slf4j
public class WarehouseMoveController {

    private Logger logger = LoggerFactory.getLogger(WarehouseMoveController.class);

    @Autowired
    private WarehouseMoveService warehouseMoveService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouse/warehouseMove/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMove/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        WarehouseMove warehouseMove = warehouseMoveService.selectById(id);
        model.putResult(warehouseMove);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMove/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseMove/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMove warehouseMove = (WarehouseMove)HttpUtils.pageData2Entity(pd, new WarehouseMove());
        warehouseMoveService.save(warehouseMove);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMove/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseMove/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMove warehouseMove = (WarehouseMove)HttpUtils.pageData2Entity(pd, new WarehouseMove());
        warehouseMoveService.update(warehouseMove);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouse/warehouseMove/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMove/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseMoveService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMove/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseMove/deleteByIds 执行开始 ################# ");
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
            warehouseMoveService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMove/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseMove/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseMove> warehouseMoveList = warehouseMoveService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseMoveList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMove/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseMove/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseMove> warehouseMoveList = warehouseMoveService.dataList(pd);
        model.putResult(warehouseMoveList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/




    /**
     * 删除移库单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMove/deleteWarehouseMove")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseMove() throws Exception {
        logger.info("################/warehouseMove/deleteWarehouseMove 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveService.deleteWarehouseMove(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMove/deleteWarehouseMove 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-11-16
     */
    @PostMapping("/warehouse/warehouseMove/saveWarehouseMove")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel saveWarehouseMove()  throws Exception {

        logger.info("################warehouseMove/saveWarehouseMove 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveService.saveWarehouseMove(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/saveWarehouseMove 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-11-16
     */
    @PostMapping("/warehouse/warehouseMove/saveWarehouseMoveDispatch")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel saveWarehouseMoveDispatch()  throws Exception {

        logger.info("################/warehouse/warehouseMove/saveWarehouseMoveDispatch 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveService.saveWarehouseMoveDispatch(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMove/saveWarehouseMoveDispatch 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMove/listPageWarehouseMoves")
    public ResultModel listPageWarehouseMoves()  throws Exception {

        logger.info("################warehouseMove/listPageWarehouseMoves 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseMoveService.listPageWarehouseMoves(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/listPageWarehouseMoves 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMove/exportExcelWarehouseMoves")
    public void exportExcelWarehouseMoves() throws Exception {
        logger.info("################warehouseMove/exportExcelWarehouseMoves 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseMoveService.exportExcelWarehouseMoves(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/exportExcelWarehouseMoves 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMove/importExcelWarehouseMoves")
    public ResultModel importExcelWarehouseMoves(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseMove/importExcelWarehouseMoves 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseMoveService.importExcelWarehouseMoves(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/importExcelWarehouseMoves 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



