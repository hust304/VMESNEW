package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.SaleLockDate;
import com.xy.vmes.service.SaleLockDateService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
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
* 说明：设置锁库时间Controller
* @author 刘威 自动生成
* @date 2018-12-12
*/
@RestController
@Slf4j
public class SaleLockDateController {

    private Logger logger = LoggerFactory.getLogger(SaleLockDateController.class);

    @Autowired
    private SaleLockDateService saleLockDateService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @GetMapping("/sale/saleLockDate/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleLockDate/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        SaleLockDate saleLockDate = saleLockDateService.selectById(id);
        model.putResult(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/sale/saleLockDate/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################saleLockDate/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleLockDate saleLockDate = (SaleLockDate)HttpUtils.pageData2Entity(pd, new SaleLockDate());
        saleLockDateService.save(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/sale/saleLockDate/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/sale/saleLockDate/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleLockDate saleLockDate = (SaleLockDate)HttpUtils.pageData2Entity(pd, new SaleLockDate());
        saleLockDateService.update(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @GetMapping("/sale/saleLockDate/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleLockDate/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        saleLockDateService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/sale/saleLockDate/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/sale/saleLockDate/deleteByIds 执行开始 ################# ");
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
            saleLockDateService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/sale/saleLockDate/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################/sale/saleLockDate/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleLockDate> saleLockDateList = saleLockDateService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleLockDateList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/sale/saleLockDate/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/sale/saleLockDate/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleLockDate> saleLockDateList = saleLockDateService.dataList(pd);
        model.putResult(saleLockDateList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    @PostMapping("/sale/saleLockDate/updateSaleLockDate")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleLockDate()  throws Exception {
        logger.info("################/sale/saleLockDate/updateSaleLockDate 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleLockDateService.updateSaleLockDate(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/updateSaleLockDate 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/sale/saleLockDate/saveSaleLockDate")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel saveSaleLockDate() throws Exception {
        logger.info("################/sale/saleLockDate/saveSaleLockDate 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleLockDateService.saveSaleLockDate(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/saveSaleLockDate 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleLockDate/selectSaleLockDateByCompanyId")
    public ResultModel selectSaleLockDateByCompanyId() throws Exception {
        logger.info("################/sale/saleLockDate/selectSaleLockDateByCompanyId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleLockDateService.selectSaleLockDateByCompanyId(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/selectSaleLockDateByCompanyId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-12
    */
    @PostMapping("/sale/saleLockDate/listPageSaleLockDates")
    public ResultModel listPageSaleLockDates()  throws Exception {
        logger.info("################/sale/saleLockDate/listPageSaleLockDates 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleLockDateService.listPageSaleLockDates(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/listPageSaleLockDates 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-12
    */
    @PostMapping("/sale/saleLockDate/exportExcelSaleLockDates")
    public void exportExcelSaleLockDates() throws Exception {
        logger.info("################/sale/saleLockDate/exportExcelSaleLockDates 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleLockDateService.exportExcelSaleLockDates(pd,pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/exportExcelSaleLockDates 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-12
    */
    @PostMapping("/sale/saleLockDate/importExcelSaleLockDates")
    public ResultModel importExcelSaleLockDates(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleLockDate/importExcelSaleLockDates 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = saleLockDateService.importExcelSaleLockDates(file);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleLockDate/importExcelSaleLockDates 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



