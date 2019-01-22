package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.service.MobileWarehouseMoveService;
import com.xy.vmes.service.WarehouseMoveDetailService;
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
public class MobileWarehouseMoveController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseMoveController.class);
    @Autowired
    private MobileWarehouseMoveService mobileWarehouseMoveService;

    // 获得移库任务详细信息
    @PostMapping("/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId")
    //@GetMapping("/mobileWarehouseMove/findWarehouseMoveByDetailId")
    public ResultModel findWarehouseMoveByDetailId()  throws Exception {

        logger.info("################/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        List<Map> varList = mobileWarehouseMoveService.findWarehouseMove(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

}
