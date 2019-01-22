package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.service.MobileWarehouseCheckService;
import com.xy.vmes.service.WarehouseCheckDetailService;
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
public class MobileWarehouseCheckController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseCheckController.class);
    @Autowired
    private MobileWarehouseCheckService mobileWarehouseCheckService;

    //获得盘点任务详细信息
    @PostMapping("/mobileWarehouseCheck/findWarehouseCheckByDetailId")
    //@GetMapping("/mobileWarehouseCheck/findWarehouseCheckByDetailId")
    public ResultModel findWarehouseCheckByDetailId()  throws Exception {
        logger.info("################/mobileWarehouseCheck/findWarehouseCheckByDetailId执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        List<Map> varList = mobileWarehouseCheckService.findWarehouseCheck(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseCheck/findWarehouseCheckByDetailId  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

}
