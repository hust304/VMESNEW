package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import java.util.*;



/**
* 说明：移库单执行Controller
* @author 刘威 自动生成
* @date 2018-11-16
*/
@RestController
@Slf4j
public class WarehouseMoveExecuteController {

    private Logger logger = LoggerFactory.getLogger(WarehouseMoveExecuteController.class);

    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouse/warehouseMoveExecute/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveExecute/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteService.selectById(id);
        model.putResult(warehouseMoveExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecute/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseMoveExecute/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveExecute warehouseMoveExecute = (WarehouseMoveExecute)HttpUtils.pageData2Entity(pd, new WarehouseMoveExecute());
        warehouseMoveExecuteService.save(warehouseMoveExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecute/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseMoveExecute/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveExecute warehouseMoveExecute = (WarehouseMoveExecute)HttpUtils.pageData2Entity(pd, new WarehouseMoveExecute());
        warehouseMoveExecuteService.update(warehouseMoveExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouse/warehouseMoveExecute/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveExecute/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseMoveExecuteService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecute/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseMoveExecute/deleteByIds 执行开始 ################# ");
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
            warehouseMoveExecuteService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecute/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseMoveExecute/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseMoveExecuteList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecute/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseMoveExecute/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.dataList(pd);
        model.putResult(warehouseMoveExecuteList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * 出库执行
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveExecute/executeWarehouseMoveExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseMoveExecute() throws Exception {
        logger.info("################/warehouseMoveExecute/executeWarehouseMoveExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveExecuteService.executeWarehouseMoveExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveExecute/executeWarehouseMoveExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 移库删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveExecute/deleteWarehouseMoveExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseMoveExecute() throws Exception {
        logger.info("################/warehouseMoveExecute/deleteWarehouseMoveExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveExecuteService.deleteWarehouseMoveExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveExecute/deleteWarehouseMoveExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * 出库编辑
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveExecute/updateWarehouseMoveExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseMoveExecute() throws Exception {
        logger.info("################/warehouseMoveExecute/updateWarehouseMoveExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveExecuteService.updateWarehouseMoveExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveExecute/updateWarehouseMoveExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecute/listPageWarehouseMoveExecutes")
    public ResultModel listPageWarehouseMoveExecutes()  throws Exception {

        logger.info("################warehouseMoveExecute/listPageWarehouseMoveExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseMoveExecuteService.listPageWarehouseMoveExecutes(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/listPageWarehouseMoveExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecute/exportExcelWarehouseMoveExecutes")
    public void exportExcelWarehouseMoveExecutes() throws Exception {
        logger.info("################warehouseMoveExecute/exportExcelWarehouseMoveExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseMoveExecuteService.exportExcelWarehouseMoveExecutes(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/exportExcelWarehouseMoveExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouse/warehouseMoveExecute/importExcelWarehouseMoveExecutes")
    public ResultModel importExcelWarehouseMoveExecutes(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseMoveExecute/importExcelWarehouseMoveExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseMoveExecuteService.importExcelWarehouseMoveExecutes(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/importExcelWarehouseMoveExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



