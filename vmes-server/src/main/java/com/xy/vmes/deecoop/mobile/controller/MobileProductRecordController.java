package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.MobileProductRecordService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileProductRecordController {
    private Logger logger = LoggerFactory.getLogger(MobileProductRecordController.class);

    @Autowired
    private MobileProductRecordService mobileProductRecordService;

    @PostMapping("/mobile/mobileProductRecord/findListProductRecord")
    public ResultModel findListProductRecord() throws Exception {
        logger.info("################/mobile/mobileProductRecord/listPageProductRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData findMap = new PageData();
        PageData pd = HttpUtils.parsePageData();
        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        findMap.put("companyId", companyId);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map<String, Object>> varList = mobileProductRecordService.findListProductRecord(findMap, pg);

        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProductRecord/findListProductRecord 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileProductRecord/findListProductRecordByCode")
    public ResultModel findListProductRecordByCode() throws Exception {
        logger.info("################/mobile/mobileProductRecord/findListProductRecordByCode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData findMap = new PageData();
        PageData pd = HttpUtils.parsePageData();

        String code = pd.getString("code");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("批次号为空或空字符串！");
            return model;
        }
        findMap.put("code", code);

        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        findMap.put("companyId", companyId);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map<String, Object>> varList = mobileProductRecordService.findListProductRecordByCode(findMap, pg);

        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProductRecord/findListProductRecordByCode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
