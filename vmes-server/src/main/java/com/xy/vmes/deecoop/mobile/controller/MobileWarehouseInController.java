package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.service.MobileWarehouseInService;
import com.xy.vmes.service.WarehouseInDetailService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseInController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseInController.class);
    @Autowired
    private MobileWarehouseInService mobileWarehouseInService;

    //获得入库任务详细信息
    @PostMapping("/mobileWarehouseIn/findWarehouseInByDetailId")
    //@GetMapping("/mobileWarehouseIn/findWarehouseInByDetailId")
    public ResultModel findWarehouseInByDetailId()  throws Exception {
        logger.info("################/mobileWarehouseIn/findWarehouseInByDetailId  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        List<Map> varList = mobileWarehouseInService.findWarehouseIn(pd);

        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseIn/findWarehouseInByDetailId  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }
}
