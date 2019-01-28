package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseOutRecommend;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseOutRecommendService;
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
* 说明：出库推荐Controller
* @author 刘威 自动生成
* @date 2018-11-07
*/
@RestController
@Slf4j
public class WarehouseOutRecommendController {

    private Logger logger = LoggerFactory.getLogger(WarehouseOutRecommendController.class);

    @Autowired
    private WarehouseOutRecommendService warehouseOutRecommendService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-07
    */
    @GetMapping("/warehouse/warehouseOutRecommend/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutRecommend/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseOutRecommend warehouseOutRecommend = warehouseOutRecommendService.selectById(id);
        model.putResult(warehouseOutRecommend);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-07
    */
    @PostMapping("/warehouse/warehouseOutRecommend/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseOutRecommend/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutRecommend warehouseOutRecommend = (WarehouseOutRecommend)HttpUtils.pageData2Entity(pd, new WarehouseOutRecommend());
        warehouseOutRecommendService.save(warehouseOutRecommend);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-07
    */
    @PostMapping("/warehouse/warehouseOutRecommend/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseOutRecommend/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutRecommend warehouseOutRecommend = (WarehouseOutRecommend)HttpUtils.pageData2Entity(pd, new WarehouseOutRecommend());
        warehouseOutRecommendService.update(warehouseOutRecommend);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-07
    */
    @GetMapping("/warehouse/warehouseOutRecommend/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutRecommend/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseOutRecommendService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-07
    */
    @PostMapping("/warehouse/warehouseOutRecommend/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseOutRecommend/deleteByIds 执行开始 ################# ");
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
            warehouseOutRecommendService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-07
    */
    @PostMapping("/warehouse/warehouseOutRecommend/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseOutRecommend/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseOutRecommend> warehouseOutRecommendList = warehouseOutRecommendService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseOutRecommendList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-07
    */
    @PostMapping("/warehouse/warehouseOutRecommend/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseOutRecommend/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseOutRecommend> warehouseOutRecommendList = warehouseOutRecommendService.dataList(pd);
        model.putResult(warehouseOutRecommendList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-07
    */
    @PostMapping("/warehouse/warehouseOutRecommend/listPageWarehouseOutRecommends")
    public ResultModel listPageWarehouseOutRecommends()  throws Exception {

        logger.info("################warehouseOutRecommend/listPageWarehouseOutRecommends 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseOutRecommendService.listPageWarehouseOutRecommends(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/listPageWarehouseOutRecommends 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-07
    */
    @PostMapping("/warehouse/warehouseOutRecommend/exportExcelWarehouseOutRecommends")
    public void exportExcelWarehouseOutRecommends() throws Exception {
        logger.info("################warehouseOutRecommend/exportExcelWarehouseOutRecommends 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseOutRecommendService.exportExcelWarehouseOutRecommends(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/exportExcelWarehouseOutRecommends 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-07
    */
    @PostMapping("/warehouse/warehouseOutRecommend/importExcelWarehouseOutRecommends")
    public ResultModel importExcelWarehouseOutRecommends(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseOutRecommend/importExcelWarehouseOutRecommends 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseOutRecommendService.importExcelWarehouseOutRecommends(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutRecommend/importExcelWarehouseOutRecommends 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



