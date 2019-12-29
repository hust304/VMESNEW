package com.xy.vmes.deecoop.quality.controller;

import com.xy.vmes.service.QualityService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_quality:质量检验项目Controller
* @author 陈刚 自动生成
* @date 2019-12-28
*/
@RestController
@Slf4j
public class QualityController {
    private Logger logger = LoggerFactory.getLogger(QualityController.class);

    @Autowired
    private QualityService qualityService;

    /**
     * (质量-采购质检)分页查询
     *
     * @author 陈刚
     * @date 2019-12-28
     */
    @PostMapping("/quality/quality/listPageProductByQuality")
    public ResultModel listPageProductByQuality() throws Exception {
        logger.info("################/quality/quality/listPageProductByQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = qualityService.listPageProductByQuality(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/quality/quality/listPageProductByQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改货品质验方式
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/quality/quality/updateProductQuality")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateProductQuality() throws Exception {
        logger.info("################/quality/quality/updateProductQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //货品id ','逗号分隔的字符串
        String productIds = pageData.getString("productIds");
        if (productIds == null || productIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串！");
            return model;
        }

        //采购货品质验方式
        String purchaseQualityType = pageData.getString("purchaseQualityType");
        if (purchaseQualityType == null || purchaseQualityType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(采购)质验方式为空或空字符串！");
            return model;
        }

        //business:业务名称 (purchase:采购)
        String business = pageData.getString("business");
        if (business == null || business.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(business:业务名称)为空或空字符串！");
            return model;
        }

        qualityService.updateProductQuality(business, productIds, purchaseQualityType);

        Long endTime = System.currentTimeMillis();
        logger.info("################/quality/quality/updateProductQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2019-12-28
     */
    @PostMapping("/quality/quality/listPageQuality")
    public ResultModel listPageQuality() throws Exception {
        logger.info("################/quality/quality/listPageQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = qualityService.listPageQuality(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/quality/quality/listPageQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 添加质检项
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/quality/quality/addQuality")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addQuality() throws Exception {
        logger.info("################/quality/quality/addQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = qualityService.addQuality(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/quality/quality/addQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除质检项
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/quality/quality/deleteQuality")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteQuality() throws Exception {
        logger.info("################/quality/quality/deleteQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("质检项id为空或空字符串！");
            return model;
        }

        qualityService.deleteById(id);

        Long endTime = System.currentTimeMillis();
        logger.info("################/quality/quality/deleteQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



