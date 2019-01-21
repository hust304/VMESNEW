package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.service.WarehouseOutDetailService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseOutController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseOutController.class);
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @PostMapping("/mobileWarehouseOut/findWarehouseOutByDetailId")
    //@GetMapping("/mobileWarehouseOut/findWarehouseOutByDetailId")
    public ResultModel listPageWarehouseOutDetailByDetail()  throws Exception {
        logger.info("################/mobileWarehouseOut/findWarehouseOutByDetailId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        List<Map> varList = warehouseOutDetailService.findWarehouseOutMobile(pd);

        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/findWarehouseOutByDetailId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

    @PostMapping("/mobileWarehouseOut/getWarehouseOutWarehouseByDetail")
    //@GetMapping("/mobileWarehouseOut/getWarehouseOutWarehouseByDetail")
    public ResultModel getWarehouseOutWarehouseByDetail()  throws Exception {
        logger.info("################/mobileWarehouseOut/getWarehouseOutWarehouseByDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();






        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/getWarehouseOutWarehouseByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }
}
