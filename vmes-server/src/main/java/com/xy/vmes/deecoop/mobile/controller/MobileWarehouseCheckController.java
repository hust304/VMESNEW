package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.WarehouseCheckDetailService;
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
public class MobileWarehouseCheckController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseCheckController.class);
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @PostMapping("/mobileWarehouseCheck/listPageWarehouseCheckDetailByDetail ")
    //@GetMapping("/mobileWarehouseCheck/listPageWarehouseCheckDetailByDetail ")
    public ResultModel listPageWarehouseCheckDetailByDetail()  throws Exception {
        logger.info("################/mobileWarehouseCheck/listPageWarehouseCheckDetailByDetail  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();


        List<Map> varList = warehouseCheckDetailService.findListPageWarehouseCheckDetail(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseCheck/listPageWarehouseCheckDetailByDetail  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

}
