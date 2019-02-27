package com.xy.vmes.deecoop.purchase.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.BomTree;
import com.xy.vmes.service.BomTreeService;
import com.xy.vmes.service.BundleAnalysisService;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* 说明：操作日志Controller
* @author 刘威 自动生成
* @date 2018-10-09
*/
@RestController
@Slf4j
public class BundleAnalysisController {

    private Logger logger = LoggerFactory.getLogger(BundleAnalysisController.class);

    @Autowired
    private BundleAnalysisService bundleAnalysisService;


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/purchase/bundleAnalysis/getBomTreeProduct")
    public ResultModel getBomTreeProduct()  throws Exception {
        logger.info("################/purchase/bundleAnalysis/getBomTreeProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
//        pd.getString("productId"),pd.getString("expectCount")
        ResultModel model = bundleAnalysisService.getBomTreeProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/bundleAnalysis/getBomTreeProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



